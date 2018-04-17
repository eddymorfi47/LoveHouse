package com.eddiemartnez.app.lovehouse.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.eddiemartnez.app.lovehouse.R;
import com.eddiemartnez.app.lovehouse.UsersControl;
import com.eddiemartnez.app.lovehouse.db.ToDoTable;
import com.eddiemartnez.app.lovehouse.db.ToDoTable_Table;
import com.eddiemartnez.app.lovehouse.db.ToDoViewHolder;
import com.eddiemartnez.app.lovehouse.util.Functions;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

public class intro extends AppCompatActivity {
    private EditText usuarioingresar;
    private EditText contrasennaingresar;
    String us;
    String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        FlowManager.init(this);
        usuarioingresar = (EditText) findViewById(R.id.usuarioingresar);
        contrasennaingresar = (EditText) findViewById(R.id.contrasennaingresar);
    }

    public void onClickIngresar(View view) {

        us = usuarioingresar.getText().toString();
        pw = contrasennaingresar.getText().toString();
        boolean isLoggedIn= false;
        isLoggedIn = isLoggedIn = SQLite.selectCountOf().from(ToDoTable.class).where(ToDoTable_Table.usuario.eq(us)).and(ToDoTable_Table.contrasenna.eq(pw)).hasData();
        ToDoTable todotable = SQLite.select().from(ToDoTable.class).where(ToDoTable_Table.usuario.eq(us)).and(ToDoTable_Table.contrasenna.eq(pw)).querySingle();
        if (isLoggedIn){
            Intent i = new Intent(intro.this, MainActivity.class);
            startActivity(i);
        }else{

            Toast.makeText (intro.this ,"Usuario o contraseña incorrecto, porfavor intente de nuevo o registrese.", Toast.LENGTH_LONG).show();
        }


    }


    public void onClickRegistrar(View view) {
        Intent in = new Intent(intro.this, registro.class);
        startActivity(in);
    }
}
