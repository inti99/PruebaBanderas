package com.aperez.apps.androidfunwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import BD_Usuario.UsuarioDb;
import DatosUsuario.UsuarioDatos;

public class Registrar extends AppCompatActivity {


    private EditText textNombre;
    private EditText textUsuario;
    private EditText textClave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        textNombre=findViewById(R.id.editTextNombre);
        textUsuario=findViewById(R.id.editTextUsuario);
        textClave=findViewById(R.id.editTextClaveText);

    }

    public void Salir(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void RegistrarUsuario(View view){

        String nombre = textNombre.getText().toString();

        String usuario = textUsuario.getText().toString();
        String clave = textClave.getText().toString();

        if(!nombre.equals("") && !usuario.equals("") && !clave.equals("") ){
            UsuarioDatos usuarioDatos = new UsuarioDatos(this);
            long id =usuarioDatos.insertarUsuario( nombre,  usuario, clave);

            if(id > 0){
                Toast.makeText(this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                Limpiar();
            }else
                Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG).show();

        }else
            Toast.makeText(this, "Llene los campos", Toast.LENGTH_LONG).show();

    }


    private void Limpiar(){

        textNombre.setText("");
        textUsuario.setText("");
        textClave.setText("");
    }
}