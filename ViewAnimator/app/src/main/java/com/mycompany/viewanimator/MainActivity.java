package com.mycompany.viewanimator;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewAnimator;


public class MainActivity extends ActionBarActivity {

    ViewAnimator viewAnimator;
    Button prev,next;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewAnimator = (ViewAnimator)findViewById(R.id.viewAnimator);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.ic_launcher);
        prev = (Button)findViewById(R.id.button);
        next = (Button)findViewById(R.id.button2);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void PreviousUse(View view){
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_left));
        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_right));
        viewAnimator.showPrevious();
    }
    public void NextUse(View view){
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
        viewAnimator.showNext();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
