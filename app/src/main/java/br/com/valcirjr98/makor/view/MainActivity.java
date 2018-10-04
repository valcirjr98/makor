package br.com.valcirjr98.makor.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.valcirjr98.makor.R;
import br.com.valcirjr98.makor.utils.ConfiguracaoFirebase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;

    private Button buttonCadastrar;

    private TextView textViewFazerLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        buttonCadastrar = findViewById(R.id.buttonCadastarInicio);
        textViewFazerLogin = findViewById(R.id.textViewFazerLogin);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });

        textViewFazerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });





    }
    @Override
    protected void onStart() {
        super.onStart();
        verificaUsuarioLogado();
    }

    public void verificaUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        if( autenticacao.getCurrentUser() != null){
            abreTelaPrincipal();
        }
    }

    private void abreTelaPrincipal() {
        startActivity(new Intent(this, MenuPrincipalActivity.class));
    }


}
