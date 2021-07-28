package com.example.comic.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class comic {
    int id;
    String name;
    String content;
    Bitmap image;
    String uri;
    int category;


    public comic(String name, String content, Bitmap image, int category,String uri,int id) {
        this.name = name;
        this.content = content;
        this.image = image;
        this.category = category;
        this.id=id;
        this.uri=uri;
    }

    public String getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }



    public String getContent() {
        return content;
    }



    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
