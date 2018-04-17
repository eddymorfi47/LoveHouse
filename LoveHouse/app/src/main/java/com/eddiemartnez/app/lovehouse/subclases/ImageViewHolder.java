package com.eddiemartnez.app.lovehouse.subclases;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.eddiemartnez.app.lovehouse.R;
import com.google.android.flexbox.FlexboxLayoutManager;

/**
 * Created by Brian on 11/10/16.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {
    //public LinearLayout box;
    public ImageView image;
    public ImageViewHolder(View itemView) {
        super(itemView);
        image =  itemView.findViewById(R.id.image);
        //box =  itemView.findViewById(R.id.box);
    }
    public void bindTo() {
        ViewGroup.LayoutParams lp = image.getLayoutParams();
        if (lp instanceof FlexboxLayoutManager.LayoutParams) {
            FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
            flexboxLp.setFlexGrow(1.0f);
        }
    }
}