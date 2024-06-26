package com.example.animangic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

public class SlideActivity extends AppCompatActivity {

     public static ViewPager viewPager;
    SlideViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_slide );
        viewPager=findViewById ( R.id.pageViewer);
        adapter=new SlideViewPagerAdapter ( this );
        viewPager.setAdapter ( adapter );

        if (isOpenAlread ()) {
            Intent intent=new Intent (SlideActivity.this,MainActivity.class);
            intent.setFlags ( Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity ( intent );
        }else {
            SharedPreferences.Editor editor=getSharedPreferences ( "slide",MODE_PRIVATE).edit ();
            editor.putBoolean ( "slide",true );
            editor.commit ();
        }
    }

    private boolean isOpenAlread() {
        SharedPreferences sharedPreferences=getSharedPreferences ( "slide",MODE_PRIVATE );
        boolean result=sharedPreferences.getBoolean ( "slide",false );
        return  result;
    }
}