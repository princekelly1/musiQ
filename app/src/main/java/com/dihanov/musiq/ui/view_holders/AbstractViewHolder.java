package com.dihanov.musiq.ui.view_holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dihanov.musiq.interfaces.ClickableArtistViewHolder;
import com.dihanov.musiq.ui.adapters.AbstractAdapter;

/**
 * Created by dimitar.dihanov on 2/1/2018.
 */

public abstract class AbstractViewHolder extends RecyclerView.ViewHolder implements ClickableArtistViewHolder{
    private boolean isFavorited = false;

    public AbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void showPopupMenu(Context context, View view, AbstractAdapter adapter);

    @Override
    public boolean getIsFavorited() {
        return isFavorited;
    }

    @Override
    public void setIsFavorited(boolean isFavorited) {
        this.isFavorited = isFavorited;
    }
}
