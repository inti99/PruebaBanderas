package com.aperez.apps.androidfunwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import DatosUsuario.UsuarioDatos;
import Entidades.Usuario;

public class Login extends AppCompatActivity {

    private EditText edit_User;
    private EditText edit_clave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_User = findViewById(R.id.editTextUsua1);
        edit_clave = findViewById(R.id.editTextClave);

    }

    public void IniciarSesion(View view){

        UsuarioDatos usuarioDatos = new UsuarioDatos(this);{
            Usuario usuario = usuarioDatos.obtenerUsuario(edit_User.getText().toString(), edit_clave.getText().toString());

            if(usuario != null)
            {
                Toast.makeText(this, "Login correcto", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,MainActivity.class);
                //intent.putExtra("nombre", (usuario.getNombre() ));
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Login Incorrecto", Toast.LENGTH_LONG).show();
        }
    }

    public void Registrar(View view){
        Intent intent = new Intent(this, Registrar.class);
        startActivity(intent);
    }

}