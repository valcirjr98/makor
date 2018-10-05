package br.com.valcirjr98.makor.utils;

import java.text.SimpleDateFormat;

public class DateCustom {

    public static  String dataAtual(){
        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MONTH yyyy");
        String dataString = simpleDateFormat.format(data);
        return dataString;

    }


}
