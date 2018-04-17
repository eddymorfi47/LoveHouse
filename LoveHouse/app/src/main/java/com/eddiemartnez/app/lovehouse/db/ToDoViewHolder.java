package com.eddiemartnez.app.lovehouse.db;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import com.eddiemartnez.app.lovehouse.R;

import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * Created by Eddie Martínez on 26/2/2018.
 */

public class ToDoViewHolder extends RecyclerView.ViewHolder {

    public HtmlTextView html;
    public ImageView borrar;
    public ToDoViewHolder(View itemView){
        super(itemView);
        html=itemView.findViewById(R.id.html_text);
        borrar=itemView.findViewById(R.id.delete);

    }
}
