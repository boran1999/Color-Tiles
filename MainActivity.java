package com.example.color_tipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View[][] tiles=new View[4][4];
    Toast toast;
    int dark, light;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiles[0][0]=findViewById(R.id.a1);
        tiles[0][1]=findViewById(R.id.a2);
        tiles[0][2]=findViewById(R.id.a3);
        tiles[0][3]=findViewById(R.id.a4);
        tiles[1][0]=findViewById(R.id.a5);
        tiles[1][1]=findViewById(R.id.a6);
        tiles[1][2]=findViewById(R.id.a7);
        tiles[1][3]=findViewById(R.id.a8);
        tiles[2][0]=findViewById(R.id.a9);
        tiles[2][1]=findViewById(R.id.a10);
        tiles[2][2]=findViewById(R.id.a11);
        tiles[2][3]=findViewById(R.id.a12);
        tiles[3][0]=findViewById(R.id.a13);
        tiles[3][1]=findViewById(R.id.a14);
        tiles[3][2]=findViewById(R.id.a15);
        tiles[3][3]=findViewById(R.id.a16);
        Resources r = getResources();
        dark=r.getColor(R.color.dark);
        light=r.getColor(R.color.light);
        int x1,y1;
        for(int i=0;i<16;i++){
            x1=i/4;
            y1=i%4;
            int randick=0+(int)(Math.random()*10);
            if(randick%2==0){
                tiles[x1][y1].setBackgroundColor(dark);
            }
            else
                tiles[x1][y1].setBackgroundColor(light);
        }
    }
    public void changeColor(View v){
        ColorDrawable color = (ColorDrawable) v.getBackground();
        if(color.getColor()==dark)
            v.setBackgroundColor(light);
        else
            v.setBackgroundColor(dark);
    }
    public void onClick(View v) {
        String tag = v.getTag().toString();
        int inttag = Integer.parseInt(tag);
        int x, y;
        x = (inttag - 1) / 4;
        y = (inttag - 1) % 4;
        changeColor(v);
        for (int i = 0; i < 4; i++) {
            changeColor(tiles[x][i]);
            changeColor(tiles[i][y]);
        }
        ColorDrawable color1 = (ColorDrawable) tiles[0][0].getBackground();
        int x1, y1;
        int flg = 1;
        for (int i = 1; i < 16; i++) {
            x1 = i / 4;
            y1 = i % 4;
            ColorDrawable color2 = (ColorDrawable) tiles[x1][y1].getBackground();
            if (color1.getColor() != color2.getColor()) {
                flg = 0;
                break;
            }
        }
        if(flg==1){
            toast=Toast.makeText(this,"VICTORY!", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
