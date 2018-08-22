package com.example.nei.formulariob;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText enombre, ecorreo,epass,erepass,ebuscar;
    private static EditText efecha;
    //private TextView tnombre,tcorreo,tpass,tfecha,tciudad,tsexo,tdormir,tleer,tinternet,tdeporte;
    private Button bguardar,bbuscar;
    private RadioButton rmasculino, rfemenino;
    private CheckBox cdormir, cleer,cdeporte,cinternet;
    private Spinner sciudad,snombres;

    String ciudad,pasatiempos;
    private String[] nombre = new String[15];
    private String[] pass = new String[15];
    private String[] correo = new String[15];
    private String[] pasatiemposs = new String[15];
    private String[] sexo = new String[15];
    private String[] fecha = new String[15];
    private String[] ciudadd = new String[15];
    ArrayAdapter<String> adapter1;
     ArrayAdapter<CharSequence> adapter;
     String buscando;
     boolean band= false;

    int cont;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        snombres=findViewById(R.id.snombre);
        bbuscar=findViewById(R.id.bbuscar);
        ebuscar=findViewById(R.id.ebuscar);
        enombre=findViewById(R.id.enombre);
        ecorreo=findViewById(R.id.ecorreo);
        epass=findViewById(R.id.epass);
        erepass=findViewById(R.id.erepass);
        bguardar=findViewById(R.id.bguardar);
        rmasculino=findViewById(R.id.rmasculino);
        rfemenino=findViewById(R.id.rfemenino);
        cdormir=findViewById(R.id.cdormir);
        cdeporte=findViewById(R.id.cdeporte);
        cleer=findViewById(R.id.cleer);
        cinternet=findViewById(R.id.cinternet);
        sciudad=findViewById(R.id.sciudad);
        efecha=findViewById(R.id.efecha);
        adapter1= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nombre);
        snombres.setAdapter(adapter1);
        //llena elvector
        for(int j=0;j<15;j++) {
            nombre[j] = "";
        }
        //muestra las ciudades
        adapter=ArrayAdapter.createFromResource(this, R.array.ciudad, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sciudad.setAdapter(adapter);

        sciudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ciudad= adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        snombres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                buscando=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



    public void showDatePickerDialog(View view) {


        DialogFragment newFragment = new    DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePickers");
    }
    public void mostrar(View view) {
        pasatiempos="";
        if (enombre.getText().toString().trim().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), "ingrese nombre", Toast.LENGTH_SHORT).show();


        } else if (epass.getText().toString().trim().equalsIgnoreCase("") && erepass.getText().toString().trim().equalsIgnoreCase("")) {

            Toast.makeText(getApplicationContext(), "ingrese contraseña", Toast.LENGTH_SHORT).show();

        } else if (efecha.getText().toString().trim().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), "ingrese fecha", Toast.LENGTH_SHORT).show();


        }else
        if(ciudad.equals("ciudad de nacimiento")){
            Toast.makeText(getApplicationContext(), "ciudad de nacimiento", Toast.LENGTH_SHORT).show();


        }else
        if(cont>14){
            Toast.makeText(getApplicationContext(), "contactos llenos", Toast.LENGTH_SHORT).show();


        }else{
            if (epass.getText().toString().equals(erepass.getText().toString())) {
                for (int i = 0; i < 15; i++) {
                    if (nombre[i].equals("")) {
                        //contador que limita elagrego
                        cont++;
                        //llena los vectores
                        Log.d("tengo","cont"+cont);
                        nombre[i] = enombre.getText().toString();
                        pass[i] = epass.getText().toString();
                        fecha[i] = efecha.getText().toString();
                        correo[i] = ecorreo.getText().toString();
                        ciudadd[i] = ciudad;
                        if (rfemenino.isChecked()) {
                            sexo[i] = rfemenino.getText().toString();
                        } else {
                            sexo[i] = rmasculino.getText().toString();
                        }
                        if (cdormir.isChecked()) {
                            pasatiempos = cdormir.getText().toString();
                        }

                        if (cleer.isChecked()) {
                            pasatiempos = pasatiempos + ", " + cleer.getText().toString();
                        }
                        if (cdeporte.isChecked()) {
                            pasatiempos = pasatiempos + ", " + cdeporte.getText().toString();
                        }
                        if (cinternet.isChecked()) {
                            pasatiempos = pasatiempos + ", " + cinternet.getText().toString();
                        }
                        pasatiemposs[i] = pasatiempos;

                        //vacia los edittext una vez guarda
                        enombre.setText("");
                        ecorreo.setText("");
                        epass.setText("");
                        erepass.setText("");
                        efecha.setText("");
                        sciudad.setAdapter(adapter);
                        if(cdeporte.isChecked()){
                            cdeporte.toggle();
                        }
                        if(cdormir.isChecked()){
                            cdormir.toggle();
                        }
                        if(cleer.isChecked()){
                            cleer.toggle();
                        }
                        if(cinternet.isChecked()){
                            cinternet.toggle();
                        }



                        break;

                    }





                }


            }
            else {
                Toast.makeText(getApplicationContext(), "contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                epass.setText("");
                erepass.setText("");
            }
        }
    }

    public void acceder(View view) {
        Intent intent = new Intent(MainActivity.this, MostrarActivity.class);
        for(int k=0;k<15;k++){ Log.d("buscnado",buscando);

            if(buscando.equals(nombre[k])){
                if(buscando.equals("")){
                    Toast.makeText(getApplicationContext(), "no hay contacto", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    band = true;
                    intent.putExtra("nombre", nombre[k]);
                    intent.putExtra("contraseña", pass[k]);
                    intent.putExtra("fecha", fecha[k]);
                    intent.putExtra("correo", correo[k]);
                    intent.putExtra("ciudad", ciudadd[k]);
                    intent.putExtra("sexo", sexo[k]);
                    intent.putExtra("pasatiempos", pasatiemposs[k]);
                    startActivity(intent);
                }


            }
        }

//        if(band==false){
//            Toast.makeText(getApplicationContext(), "contacto no encontrado", Toast.LENGTH_SHORT).show();
//
//        }else {
//            startActivity(intent);
//            band=false;
//        }
    }

    public void buscar(View view) {
        String buscan;
        buscan=ebuscar.getText().toString();
        Intent intent = new Intent(MainActivity.this, MostrarActivity.class);
        for(int l=0;l<15;l++){
            ;
            if(buscan.equals(nombre[l])){
                if(buscan.equals("")){
                }else{
                    band = true;
                    intent.putExtra("nombre", nombre[l]);
                    intent.putExtra("contraseña", pass[l]);
                    intent.putExtra("fecha", fecha[l]);
                    intent.putExtra("correo", correo[l]);
                    intent.putExtra("ciudad", ciudadd[l]);
                    intent.putExtra("sexo", sexo[l]);
                    intent.putExtra("pasatiempos", pasatiemposs[l]);

                }


            }
        }

        if(band==false){
            Toast.makeText(getApplicationContext(), "contacto no encontrado", Toast.LENGTH_SHORT).show();

        }else {
            startActivity(intent);
            band=false;
        }

    }

    public void eliminar(View view) {
        for(int h=0;h<15;h++){
            if(nombre[h].equals(buscando)){
                if(nombre[h].equals("")){

                }else{
                Toast.makeText(getApplicationContext(), "contacto "+nombre[h]+" ha sido eliminado", Toast.LENGTH_SHORT).show();
                nombre[h]="";
                snombres.setAdapter(adapter1);}


            }
        }
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            efecha.setText( day+  "-"+ (month+1)+ "- "+ year);
        }

    }




}





