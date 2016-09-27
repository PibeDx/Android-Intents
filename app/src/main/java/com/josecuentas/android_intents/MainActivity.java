package com.josecuentas.android_intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    EditText edtNombre;
    RadioGroup rgSexo;
    RadioButton rbMasculino, rbFemenino;
    Spinner spCiudad;
    Button btnNext;


    String nombre = "", sexo = "", ciudad = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombre = (EditText) findViewById(R.id.edt_nombre);
        rgSexo = (RadioGroup) findViewById(R.id.rg_sexo);
        rbMasculino = (RadioButton) findViewById(R.id.rb_masculino);
        rbFemenino = (RadioButton) findViewById(R.id.rb_femenino);
        spCiudad = (Spinner) findViewById(R.id.sp_ciudad);
        btnNext = (Button) findViewById(R.id.btn_next);

        initData();
        initEvents();
    }

    private void initData() {
        List<String> ciudadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ciudadList.add("Ciudad " + (i + 1));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, ciudadList);
        spCiudad.setAdapter(adapter);
    }

    private void initEvents() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                getData();
                Log.v(TAG, nombre + " " + sexo + " " + ciudad);
                Bundle bundle = new Bundle();
                bundle.putString("nombre", nombre);
                bundle.putString("sexo", sexo);
                bundle.putString("ciudad", ciudad);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.rb_masculino:
                        sexo = "masculino";
                        break;
                    case R.id.rb_femenino:
                        sexo = "femenino";
                }
            }
        });

        spCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad = (String) adapterView.getItemAtPosition(i);
            }

            @Override public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void getData (){
        nombre = edtNombre.getText().toString();
    }

}
