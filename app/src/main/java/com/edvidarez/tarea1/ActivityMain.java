package com.edvidarez.tarea1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    EditText name, phone;
    RadioGroup radiogroup;
    CheckBox cbx;
    Button limpiar;
    AutoCompleteTextView actv;
    Spinner escolaridad;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_save:{
                //String nombre,String telefono, String escolaridad, int escolaridad_index, boolean male, String librofavorito, int libro_index, boolean deporte
                String escolaridadAlumno = escolaridad.getSelectedItem().toString();
                boolean male = radiogroup.getCheckedRadioButtonId() == R.id.masculino;
                Alumno a = new Alumno(name.getText().toString(),phone.getText().toString(),escolaridadAlumno,male,actv.getText().toString(),cbx.isChecked());
                Toast.makeText(this,a.toString(),Toast.LENGTH_LONG).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        radiogroup = findViewById(R.id.radios);
        actv = findViewById(R.id.libros);
        cbx = findViewById(R.id.deporte);
        escolaridad = findViewById(R.id.escolaridad);
        String[] librosString = getResources().getStringArray(R.array.libros);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,librosString);

        actv.setAdapter(adapter);
        limpiar = findViewById(R.id.limpiar);
        final ActivityMain am = this;
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(am);

                // set title
                alertDialogBuilder.setTitle("Desea limpiar el contenido");
                alertDialogBuilder
                       // .setMessage("")
                       // .setCancelable(false)
                        .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                name.setText("");
                                phone.setText("");
                                radiogroup.clearCheck();
                                cbx.setChecked(false);
                                actv.setText("");
                                String[] escolaridadArray = getResources().getStringArray(R.array.escolaridad);
                                ArrayAdapter<String> adap = new ArrayAdapter<String>(am,R.layout.support_simple_spinner_dropdown_item,escolaridadArray);
                                escolaridad.setAdapter(adap);
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();



            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        radiogroup.check(savedInstanceState.getInt("RADIOS"));
        name.setText(savedInstanceState.getString("NAME"));
        phone.setText(savedInstanceState.getString("PHONE"));
        cbx.setChecked(savedInstanceState.getBoolean("DEPORTE"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("NAME",name.getText().toString());
        outState.putString("PHONE",phone.getText().toString());
        outState.putBoolean("DEPORTE",cbx.isChecked());
        outState.putInt("RADIOS",radiogroup.getCheckedRadioButtonId());

        super.onSaveInstanceState(outState);
    }
}
