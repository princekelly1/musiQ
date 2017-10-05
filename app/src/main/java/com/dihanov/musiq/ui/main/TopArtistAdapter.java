package com.dihanov.musiq.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dihanov.musiq.R;
import com.dihanov.musiq.models.Artist;
import com.dihanov.musiq.util.Constants;
import com.veinhorn.tagview.TagView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dimitar.dihanov on 9/27/2017.
 */

public class TopArtistAdapter extends ArrayAdapter<Artist> {
    private Context context;
    private List<Artist> topArtist;
    private int resourceId;

    public TopArtistAdapter(@NonNull Context context, int resource, ArrayList<Artist> data) {
        super(context, resource, data);
        this.topArtist = data;
        this.context = context;
        this.resourceId = resource;
    }


    private class MyViewHolder{
        TagView name;
        ImageView artist;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        MyViewHolder holder;

        if (row == null) {
            row = LayoutInflater.from(parent.getContext())
                    .inflate(resourceId, parent, false);
            holder = new MyViewHolder();
            holder.artist = (ImageView) row.findViewById(R.id.top_artist_image);
            holder.name = (TagView) row.findViewById(R.id.top_artist_name);
            row.setTag(holder);
        } else {
            holder = (MyViewHolder) row.getTag();
        }


        Artist artist = topArtist.get(position);
        Glide.with(context)
                .load(artist.getImage().get(Constants.IMAGE_XLARGE).getText())
                .crossFade(2000)
                .into(holder.artist);
        holder.name.setText(artist.getName().toLowerCase());
        holder.name.setTagColor(Color.parseColor(context.getString(R.color.colorAccent)));
        holder.name.setTagCircleRadius(10f);
        return row;
    }
}
