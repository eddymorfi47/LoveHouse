package com.eddiemartnez.app.lovehouse.db;

import com.eddiemartnez.app.lovehouse.db.Database;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Eddie Martínez on 5/2/2018.
 */
@Table(database = Database.class)
public class ToDoTable extends BaseModel{
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String nombre;

    @Column
    public String usuario;

    @Column
    public String contrasenna;


    @Column
    public int estado;


}
