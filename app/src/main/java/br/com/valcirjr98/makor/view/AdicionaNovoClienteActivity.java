package br.com.valcirjr98.makor.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.santalu.widget.MaskEditText;

import br.com.valcirjr98.makor.R;
import br.com.valcirjr98.makor.model.Cliente;

public class AdicionaNovoClienteActivity extends AppCompatActivity {

    private TextInputEditText campoNome;
    private MaskEditText campoCPF;
    private Spinner spinnerEstados;
    private TextInputEditText campoMunicipio;
    private TextInputEditText campoEndereco;
    private MaskEditText campoTelefone;
    private Button buttonSalvaCliente;
    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_novo_cliente);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        cliente = (Cliente) getIntent().getSerializableExtra("cliente");


        campoNome = findViewById(R.id.textNomeCliente);
        campoCPF = findViewById(R.id.textCPF);
        spinnerEstados = findViewById(R.id.spinnerEstados);
        campoMunicipio = findViewById(R.id.textMunicipio);
        campoEndereco = findViewById(R.id.textEndereco);
        campoTelefone = findViewById(R.id.textTelefone);

        buttonSalvaCliente = findViewById(R.id.buttonSalvarCliente);

        buttonSalvaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(capturarCliente()){
                    SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_config), Context.MODE_PRIVATE);
                    String id = sharedPreferences.getString(getString(R.string.id), "");

                    DatabaseReference myRef = database.getReference("usuarios");
                    myRef.child("clientes").child(id).push().setValue(cliente).addOnSuccessListener(new OnSuccessListener<Void>() {
                        public void onSuccess(Void aVoid) {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(AdicionaNovoClienteActivity.this);
                            alerta.setTitle("Novo cliente");
                            alerta.setMessage("Cliente adicionado com sucesso!");
                            alerta.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                            alerta.show();
                        }
                    });

                }


            }
        });
    }

    public void carregarDadosSpinner(){
        String [] estados = getResources().getStringArray(R.array.estados);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estados);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstados.setAdapter(adapter);
    }

    public boolean capturarCliente(){
        String nome = campoNome.getText().toString();
        String cpf = campoCPF.getText().toString();
        String estado = spinnerEstados.getSelectedItem().toString();
        String municipio = campoMunicipio.getText().toString();
        String endereco = campoEndereco.getText().toString();
        String telefone = campoTelefone.getText().toString();

        if(nome.isEmpty()){
            campoNome.setError("Campo em branco!");
            return false;
        }
        if(cpf.isEmpty()){
            campoCPF.setError("Campo em branco!");
            return false;
        }
        if(estado.isEmpty()){
            Toast.makeText(this, "Escolha um estado",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(municipio.isEmpty()){
            campoMunicipio.setError("Campo em branco!");
            return false;
        }
        if(endereco.isEmpty()){
            campoEndereco.setError("Campo em branco!");
            return false;
        }
        if(telefone.isEmpty()){
            campoTelefone.setError("Campo em branco!");
            return false;
        }

        cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCPF(cpf);
        cliente.setEstado(estado);
        cliente.setMunicipio(municipio);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);

        return true;

    }





}
