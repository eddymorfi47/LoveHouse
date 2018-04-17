package com.eddiemartnez.app.lovehouse.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.eddiemartnez.app.lovehouse.R;
import com.eddiemartnez.app.lovehouse.db.ToDoTable;
import com.raizlabs.android.dbflow.config.FlowManager;

public class registro extends AppCompatActivity {

    private EditText usuario;
    private EditText pw;
    private EditText pw2;
    private EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        FlowManager.init(this);
        usuario= (EditText) findViewById(R.id.usuario);
        pw = (EditText) findViewById(R.id.pwtxt1);
        pw2 = (EditText) findViewById(R.id.pwtxt2);
        nombre = (EditText) findViewById(R.id.nombre);

    }

    public void registrar(View view) {

        if (pw.getText().toString().equals(pw2.getText().toString())){
            anadir();
            Intent miIntent=new Intent(registro.this,MainActivity.class);
            startActivity(miIntent);

        }
        else{
            Toast.makeText (registro.this ,"Las contraseñas no coincides.", Toast.LENGTH_LONG).show();
        }
    }


    private boolean validación () {
        boolean send = true;
        if (nombre.getText().toString().isEmpty()) {
            return send;
        }
        if (usuario.getText().toString().isEmpty()) {
            send = false;
        }
        if (pw.getText().toString().isEmpty()) {
            send = false;

        }
        return send;
    }

    private void anadir(){
        if (validación()){
            ToDoTable registro = new ToDoTable();
            registro.nombre = nombre.getText().toString();
            registro.usuario = usuario.getText().toString();
            registro.contrasenna = pw.getText().toString();

            registro.save();
            finish();
        }
        else{
            Toast.makeText(this,"Se produjo un error al registrar el usuario.",Toast.LENGTH_LONG).show();
        }
    }




}
