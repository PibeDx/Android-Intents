package com.josecuentas.android_intents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tviMensaje;
    String nombre = "", sexo = "", ciudad = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tviMensaje = (TextView) findViewById(R.id.tvi_mensaje);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            nombre = bundle.getString("nombre");
            sexo = bundle.getString("sexo");
            ciudad = bundle.getString("ciudad");
        }

        String mensaje = new StringBuilder()
                .append("Nombre: ").append(nombre).append("\n")
                .append("Sexo: ").append(sexo).append("\n")
                .append("Ciudad: ").append(ciudad).append("\n").toString();

        tviMensaje.setText(mensaje);
    }

}
