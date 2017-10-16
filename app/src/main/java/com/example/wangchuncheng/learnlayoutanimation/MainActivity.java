package com.example.wangchuncheng.learnlayoutanimation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import static com.example.wangchuncheng.learnlayoutanimation.R.id.activity_main;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rootView;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rootView.removeView(v);
        }
    };
    private void addButton() {
        Button btn = new Button(this);
        btn.setText("Remove Me");
        rootView.addView(btn);
        btn.setOnClickListener(listener);
    }
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = (LinearLayout) findViewById(R.id.activity_main);
        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
        sa.setDuration(350);

        LayoutAnimationController loc = new LayoutAnimationController(sa,0.5f);
        loc.setOrder(LayoutAnimationController.ORDER_RANDOM);//随机

        rootView.setLayoutAnimation(loc);
//        if(savedInstanceState==null){
//            getSupportFragmentManager().beginTransaction()
//                    .add(activity_main,new BlankFragment())
//                    .commit();
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                return true;
            case R.id.action_add:
                addButton();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }
}
