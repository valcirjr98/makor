package br.com.valcirjr98.makor.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blackcat.currencyedittext.CurrencyEditText;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.valcirjr98.makor.R;
import br.com.valcirjr98.makor.model.Cliente;
import br.com.valcirjr98.makor.model.Produto;

public class AdicionaNovoProdutoActivity extends AppCompatActivity {

    private TextInputEditText codigodoProduto;

    private TextInputEditText nomeDoProduto;

    private TextInputEditText pesoDoProduto;

    private CurrencyEditText precoDoProduto;

    private Button buttonSalvarProduto;


    private Produto produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_novo_produto);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        produto = (Produto) getIntent().getSerializableExtra("produto");

        codigodoProduto = findViewById(R.id.textCodigo);
        nomeDoProduto = findViewById(R.id.textNomeProduto);
        pesoDoProduto = findViewById(R.id.textPeso);
        precoDoProduto = findViewById(R.id.textPreco);

        buttonSalvarProduto = findViewById(R.id.buttonSalvarProduto);

        buttonSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (capturarProduto()) {
                    SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_config), Context.MODE_PRIVATE);
                    String id = sharedPreferences.getString(getString(R.string.id), "");

                    DatabaseReference myRef = database.getReference("usuarios");
                    myRef.child("produtos").child(id).push().setValue(produto).addOnSuccessListener(new OnSuccessListener<Void>() {
                        public void onSuccess(Void aVoid) {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(AdicionaNovoProdutoActivity.this);
                            alerta.setTitle("Novo Produto");
                            alerta.setMessage("Produto adicionado com sucesso!");
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

            public boolean capturarProduto() {
                String codigo = codigodoProduto.getText().toString();
                String nome = nomeDoProduto.getText().toString();
                String peso = pesoDoProduto.getText().toString();
                String preco = precoDoProduto.getText().toString().replace("R$", "").replace(",", ".");

                if (nome.isEmpty()) {
                    nomeDoProduto.setError("Campo em branco!");
                    return false;
                }

                produto = new Produto();
                produto.setCodigo(codigo);
                produto.setNome(nome);
                produto.setPeso(peso);
                produto.setPreco(preco);


                return true;

            }


        });

    }
}