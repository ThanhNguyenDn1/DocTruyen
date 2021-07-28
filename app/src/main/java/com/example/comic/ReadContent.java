package com.example.comic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.comic.FAKEDATA.DataComic;
import com.example.comic.R;

public class ReadContent extends AppCompatActivity {
    private TextView tvcomic;
    private TextView tvcontentcomic;
    private DataComic dataComic;
    private TextView tvnext;
    private TextView tvprevious;
    String content;
    int status=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_content);
        dataComic=new DataComic();
        addEvent();
        setEvent();
        setContent();
    }

    private void setContent() {
            Intent intent=getIntent();
            String s=intent.getStringExtra("namecomic");
        Log.d("1111",s);
            for(int i=0; i<dataComic.listComic.size(); i++){
                if(s.equals(dataComic.listComic.get(i).getName())){
                    tvcomic.setText(dataComic.listComic.get(i).getName());
                    content=dataComic.listComic.get(i).getContent();
                    tvcontentcomic.setText(content.substring(0,getindexstt(status+1300)));
                    status=status+1300;

                }
            }

    }

    private void setEvent() {
        tvnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status+1300>content.length()){
                    tvcontentcomic.setText(content.substring(getindexstt(status),content.length()-1));
                    Log.d("EEEE",status+" "+content.length());
                }
                if(status+1300<content.length()){
                    tvcontentcomic.setText(content.substring(getindexstt(status),getindexstt(status+1300)));
                    status=status+1300;
                    Log.d("EEEE",status+" "+content.length());
                }
              }
        });
        tvprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status>=2*1300){
                    tvcontentcomic.setText(content.substring(getindexstt(status-1300),getindexstt(status)));
                    status=status-1300;
                    Log.d("EEEE",status+" "+content.length());
                }
                else {
                    if(status<=1300){
                        Log.d("EEEE",status+" "+content.length());
                        tvcontentcomic.setText(content.substring(0,getindexstt(status)));
                    }
                }
            }
        });

    }

    int getindexstt(int a){
        for(int i=a; i<content.length();i++){
            if(content.charAt(i)=='.'){
                return i;
            }
        }
        return 0;
    }

    private void addEvent() {
        tvcomic=(TextView)findViewById(R.id.tv_comic);
        tvcontentcomic=(TextView)findViewById(R.id.tv_contentcomic);
        tvnext=(TextView)findViewById(R.id.tv_next);
        tvprevious=(TextView)findViewById(R.id.tv_privious);
    }
}