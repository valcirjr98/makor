package br.com.valcirjr98.makor.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import br.com.valcirjr98.makor.MenuPrincipalActivity;
import br.com.valcirjr98.makor.R;
import br.com.valcirjr98.makor.model.Usuario;
import br.com.valcirjr98.makor.utils.ConfiguracaoFirebase;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextSenha;

    private Button buttonEntrar;

    private TextView textViewCadastro;

    private Usuario usuario;

    private FirebaseAuth autenticacao;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        progressBar = findViewById(R.id.progressBarLogin);
        buttonEntrar = findViewById(R.id.buttonEntrar);

        progressBar.setVisibility(View.GONE);
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();

                if ( !email.isEmpty() ){
                    if ( !senha.isEmpty() ){

                        usuario = new Usuario();
                        usuario.setEmail( email );
                        usuario.setSenha( senha );
                        validaLogin();

                    }else {
                        Toast.makeText(LoginActivity.this,
                                "Preencha a senha!",
                                Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this,
                            "Preencha o e-mail!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        textViewCadastro = findViewById(R.id.textViewCadastre);


        textViewCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));

            }
        });
    }

    public void validaLogin(){

        progressBar.setVisibility(View.VISIBLE);
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail(),
                usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    progressBar.setVisibility(View.VISIBLE);

                    abreTelaPrincipal();

                }else{
                    String excecao = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        excecao = "Usuário não cadastrado. Clique em Cadastre-se";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "E-mail ou senha inválidos!";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário:" +e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void abreTelaPrincipal(){
        Toast.makeText(LoginActivity.this, "Login efetuado!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MenuPrincipalActivity.class));
        finish();
    }
}
