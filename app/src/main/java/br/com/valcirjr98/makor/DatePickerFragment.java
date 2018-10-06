package br.com.valcirjr98.makor;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendar = Calendar.getInstance();
            int ano = calendar.get(Calendar.YEAR);
            int mes = calendar.get(Calendar.MONTH);
            int dia = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),  (android.app.DatePickerDialog.OnDateSetListener) getActivity(), ano, mes, dia);
        }
    }


