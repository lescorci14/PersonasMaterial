package com.example.cuc.personasmaterial;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarPersona extends AppCompatActivity {
    private EditText cajaCedula, cajaNombre, cajaApellido;
    private TextInputLayout icajaCedula, icajaNombre, icajaApellido;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        cajaCedula = (EditText)findViewById(R.id.txtCedula);
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);

        icajaCedula = (TextInputLayout)findViewById(R.id.cedulaPersona);
        icajaNombre = (TextInputLayout)findViewById(R.id.nombrePersona);
        icajaApellido = (TextInputLayout)findViewById(R.id.apellidoPersona);

        res = this.getResources();
    }

    public int fotoAleatoria(){
        int fotos[] = {R.drawable.images,R.drawable.images2,R.drawable.images3};
        int numero = (int)(Math.random() * 3);
        return fotos[numero];
    }

    public boolean validarTodo(){
        if(cajaCedula.getText().toString().isEmpty()){
            icajaCedula.setError("Digite la cédula");
            cajaCedula.requestFocus();
            return false;
        }
        if(cajaNombre.getText().toString().isEmpty()){
            icajaNombre.setError("Digite el Nombre");
            cajaNombre.requestFocus();
            return false;
        }
        if(cajaApellido.getText().toString().isEmpty()){
            icajaApellido.setError("Digite el Apellido");
            cajaApellido.requestFocus();
            return false;
        }

        return true;
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarPersona.this,Principal.class);
        startActivity(i);
    }

    public void guardar(View v){
        String foto,cedula,nombre,apellido;
        Persona p;

        if(validarTodo()){
            cedula = cajaCedula.getText().toString();
            foto = String.valueOf(fotoAleatoria());
            nombre = cajaNombre.getText().toString();
            apellido=cajaApellido.getText().toString();


            p = new Persona(foto,cedula,nombre,apellido);
            p.guardar(getApplicationContext());

            InputMethodManager imp = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imp.hideSoftInputFromWindow(cajaCedula.getWindowToken(),0);

            Snackbar.make(v,"Persona Guardada Exitosamente!",Snackbar.LENGTH_SHORT).show();

            limpiar();

        }
    }

    public void limpiar(){
        cajaCedula.setText("");
        cajaNombre.setText("");
        cajaApellido.setText("");
        cajaCedula.requestFocus();
    }
}
