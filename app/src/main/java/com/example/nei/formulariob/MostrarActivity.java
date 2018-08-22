package com.example.nei.formulariob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MostrarActivity extends AppCompatActivity {
    private TextView tnombre,tpass,tcorreo,tsexo,tpasatiempo,tciudad,tfecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        Bundle args = getIntent().getExtras();
        tciudad=findViewById(R.id.tciudad);
        tcorreo=findViewById(R.id.tcorreo);
        tfecha=findViewById(R.id.tfecha);
        tnombre=findViewById(R.id.tnombre);
        tpasatiempo=findViewById(R.id.tpasatiempos);
        tpass=findViewById(R.id.tpass);
        tsexo=findViewById(R.id.tsexo);

        tnombre.setText(args.getString("nombre"));
        tsexo.setText(args.getString("sexo"));
        tpass.setText(args.getString("contraseña"));
        tpasatiempo.setText(args.getString("pasatiempos"));
        tfecha.setText(args.getString("fecha"));
        tcorreo.setText(args.getString("correo"));
        tciudad.setText(args.getString("ciudad"));

    }
}
