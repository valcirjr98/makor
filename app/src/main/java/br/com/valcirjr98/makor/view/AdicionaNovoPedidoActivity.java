package br.com.valcirjr98.makor.view;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.santalu.widget.MaskEditText;

import br.com.valcirjr98.makor.R;
import br.com.valcirjr98.makor.utils.DateCustom;

public class AdicionaNovoPedidoActivity extends AppCompatActivity {

    private MaskEditText dataAtual;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_novo_pedido);

        dataAtual = findViewById(R.id.editTextData);

        dataAtual.setText(DateCustom.dataAtual());


    }
}
