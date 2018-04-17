package com.eddiemartnez.app.lovehouse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eddiemartnez.app.lovehouse.R;
import com.eddiemartnez.app.lovehouse.activities.MainActivity;
import com.eddiemartnez.app.lovehouse.activities.intro;
import com.eddiemartnez.app.lovehouse.activities.registro;
import com.eddiemartnez.app.lovehouse.db.ToDoTable;
import com.eddiemartnez.app.lovehouse.db.ToDoTable_Table;
import com.eddiemartnez.app.lovehouse.db.ToDoViewHolder;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;

import java.util.List;

public class UsersControl extends AppCompatActivity {
    private RecyclerView lista;
    private static Context QuickContext;
    String pww;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_control);
        QuickContext = this;
        FlowManager.init(this);


        lista = findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));

        List<ToDoTable> info = SQLite.select().from(ToDoTable.class).queryList();
        lista.setAdapter(new ToDoAdapter(info));
    }

    public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {
        private final List<ToDoTable> listToDoTable;
        private final LayoutInflater inflater;

        public ToDoAdapter(List<ToDoTable> listToDoTables) {
            this.inflater = LayoutInflater.from(QuickContext);
            this.listToDoTable = listToDoTables;
        }

        @Override
        public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.activity_objeto, parent, false);
            return new ToDoViewHolder(view);
        }

        public void animateTo(List<ToDoTable> models) {
            applyAndAnimateRemovals(models);
            applyAndAnimateAdditions(models);
            applyAndAnimateMovedItems(models);
        }

        private void applyAndAnimateRemovals(List<ToDoTable> newModels) {
            for (int i = listToDoTable.size() - 1; i >= 0; i--) {
                final ToDoTable model = listToDoTable.get(i);
                if (!newModels.contains(model)) {
                    removeItem(i);
                }
            }
        }

        private void applyAndAnimateAdditions(List<ToDoTable> newModels) {
            for (int i = 0, count = newModels.size(); i < count; i++) {
                final ToDoTable model = newModels.get(i);
                if (!listToDoTable.contains(model)) {
                    addItem(i, model);
                }
            }
        }

        private void applyAndAnimateMovedItems(List<ToDoTable> newModels) {
            for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
                final ToDoTable model = newModels.get(toPosition);
                final int fromPosition = listToDoTable.indexOf(model);
                if (fromPosition >= 0 && fromPosition != toPosition) {
                    moveItem(fromPosition, toPosition);
                }
            }
        }

        public ToDoTable removeItem(int position) {
            final ToDoTable model = listToDoTable.remove(position);
            notifyItemRemoved(position);
            return model;
        }

        public void addItem(int position, ToDoTable model) {
            listToDoTable.add(position, model);
            notifyItemInserted(position);
        }

        public void moveItem(int fromPosition, int toPosition) {
            final ToDoTable model = listToDoTable.remove(fromPosition);
            listToDoTable.add(toPosition, model);
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onBindViewHolder(final ToDoViewHolder holder, final int position) {//bind=enlazar
            final ToDoTable current = listToDoTable.get(position);
            holder.html.setHtml(ActividadAString(current),
                    new HtmlResImageGetter(holder.html));
            holder.html.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(current.estado < 2){
                        current.estado=2;

                    }else {
                        current. estado=1;
                    }
                    notifyDataSetChanged();
                }
            });
            holder.borrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    final AlertDialog.Builder pwBuilder = new AlertDialog.Builder(UsersControl.this);
                    View mView = getLayoutInflater().inflate(R.layout.dialog_password, null);

                    //Este es el campo de evaluación de la contraseña, contra la columna de contraseña en base de datos
                    final EditText pwverify = (EditText) mView.findViewById(R.id.pwverification);


                    Button btnverify = (Button) mView.findViewById(R.id.btnverify);

                    btnverify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {




                            pww = pwverify.getText().toString();
                            boolean isLoggedIn= false;
                            isLoggedIn = isLoggedIn = SQLite.selectCountOf().from(ToDoTable.class).where(ToDoTable_Table.contrasenna.eq(pww)).hasData();
                            ToDoTable todotable = SQLite.select().from(ToDoTable.class).where(ToDoTable_Table.contrasenna.eq(pww)).querySingle();
                            if (isLoggedIn){
                                current.delete();
                                removeItem(position);
                                notifyDataSetChanged();
                                pwverify.setText("");

                            }else{
                                Toast.makeText (UsersControl.this ,"Las contraseña es invalida.", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                    pwBuilder.setView(mView);
                    AlertDialog dialog = pwBuilder.create();
                    dialog.show();









                    //Toast.makeText (UsersControl.this ,"Las contraseña es invalida.", Toast.LENGTH_LONG).show();

                }
            });
        }
        private String ActividadAString(ToDoTable todo){
            String html = "<a><b>" +"Nombre: " + todo.nombre+"<b>";
            html+= "<br>" +"Usuario: "+todo.usuario+"</a>";
            html+= "<br>" +"Contraseña: *********"+"</a>";
            return html;
        }


        @Override
        public int getItemCount() {
            return listToDoTable.size();
        }




    }

}
