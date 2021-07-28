package com.example.comic;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.comic.model.comic;


import java.util.List;

public class Adapterss  extends ArrayAdapter<comic> {
    private Context context;
    private int resource;
    private List<comic> comics;
    public Adapterss(@NonNull Context context, int resource, @NonNull List<comic> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.comics=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        viewOlder viewOlder;
        if(convertView==null){
            viewOlder=new viewOlder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_of_list_comic,parent,false);
            viewOlder.name=(TextView) convertView.findViewById(R.id.tv_namecomic);
            viewOlder.imageView=(ImageView) convertView.findViewById(R.id.img_avatar);
            convertView.setTag(viewOlder);
        }
        else {
            viewOlder=(viewOlder) convertView.getTag();
        }

        ViewListComic viewListComic=new ViewListComic();
        comic comic=comics.get(position);
        viewOlder.name.setText(comic.getName());
        viewOlder.imageView.setImageBitmap(comic.getImage());

        return convertView;
    }
    public  class  viewOlder{
        TextView name;
        ImageView imageView;
    }






}
