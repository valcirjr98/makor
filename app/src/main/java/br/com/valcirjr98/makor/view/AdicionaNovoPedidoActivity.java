package br.com.valcirjr98.makor.view;

import android.app.DatePickerDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.DatePicker;
import android.widget.TextView;

import com.santalu.widget.MaskEditText;

import java.text.DateFormat;
import java.util.Calendar;

import br.com.valcirjr98.makor.DatePickerFragment;
import br.com.valcirjr98.makor.R;
import br.com.valcirjr98.makor.utils.DateCustom;

public class AdicionaNovoPedidoActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    private TextView textEscolherData;

    private TextView textViewData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_novo_pedido);

        textEscolherData = findViewById(R.id.textViewDataEscolhida);
        textViewData = findViewById(R.id.textViewData);

        textEscolherData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

       //textEscolherData.setText(DateCustom.dataAtual());



    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dataAtual = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        textEscolherData.setText(dataAtual);

            }



}
