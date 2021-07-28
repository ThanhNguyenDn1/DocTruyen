package com.example.comic;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.comic.FAKEDATA.DataComic;
import java.io.IOException;
import java.io.InputStream;


public class ViewListComic extends AppCompatActivity {
    private  Adapterss adapterss;
    private DataComic listcomic;
    private ListView listView;
    private TextView tvLablel;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_comic);
        listcomic=new DataComic();
        setBitmaplist();
        addEvent();
        SetLabel();
        setEvent();
        adapterss=new Adapterss(this,R.layout.item_of_list_comic,listcomic.listComic);
        listView.setAdapter(adapterss);
    }

    private void setBitmaplist() {
        for(int i=0; i<listcomic.listComic.size(); i++){
            listcomic.listComic.get(i).setImage(setBitmap(listcomic.listComic.get(i).getUri()));
        }
    }

    private void setEvent() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=listcomic.listComic.get(i).getName();
                Intent intent=new Intent(ViewListComic.this,ReadContent.class);
                intent.putExtra("namecomic",name);
                startActivity(intent);
            }
        });
    }

    private void SetLabel() {
        Intent intent=this.getIntent();
        int category=intent.getIntExtra("category",0);

        Log.d("AAAA",listcomic.listCategory.size()+"");
        for(int i=0; i<listcomic.listCategory.size(); i++){
            if(category==listcomic.listCategory.get(i).getId()){
                tvLablel.setText(listcomic.listCategory.get(i).getName());
                break;
            }
        }
    }

    private void addEvent() {
        listView=(ListView)findViewById(R.id.lv_lvComic);
        tvLablel=(TextView) findViewById(R.id.tv_label);
    }

    Bitmap setBitmap(String s){
        try{
            InputStream is=getAssets().open(s);
            bitmap =BitmapFactory.decodeStream(is);

        }catch (IOException e){}
        return bitmap;
    }

}