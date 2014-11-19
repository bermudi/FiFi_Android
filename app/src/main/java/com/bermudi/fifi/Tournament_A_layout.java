package com.bermudi.fifi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOError;
import java.util.Random;


public class Tournament_A_layout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int players = getIntent().getExtras().getInt("players");

        switch (players) {
            case 1:
                setContentView(R.layout.activity_tournament__a_layout);
                break;
            case 2:
                setContentView(R.layout.activity_tournament__b_layout);
                break;
            case 3:
                setContentView(R.layout.activity_tournament__b_layout);
                break;
        }


        ImageView[] imageViews = new ImageView[16];               //Create array of Imageviews to iterate
        int crestIDs[] = new int[16];                             //Save all picture IDs in array to iterate

        imageViews[0] = (ImageView)findViewById(R.id.imageView16); //FIXME
        imageViews[1] = (ImageView)findViewById(R.id.imageView1);       //TODO is there a more efficient way of doing this?
        imageViews[2] = (ImageView)findViewById(R.id.imageView2);
        imageViews[3] = (ImageView)findViewById(R.id.imageView3);
        imageViews[4] = (ImageView)findViewById(R.id.imageView4);
        imageViews[5] = (ImageView)findViewById(R.id.imageView5);
        imageViews[6] = (ImageView)findViewById(R.id.imageView6);
        imageViews[7] = (ImageView)findViewById(R.id.imageView7);
        imageViews[8] = (ImageView)findViewById(R.id.imageView8);
        imageViews[9] = (ImageView)findViewById(R.id.imageView9);
        imageViews[10] = (ImageView)findViewById(R.id.imageView10);
        imageViews[11] = (ImageView)findViewById(R.id.imageView11);
        imageViews[12] = (ImageView)findViewById(R.id.imageView12);
        imageViews[13] = (ImageView)findViewById(R.id.imageView13);
        imageViews[14] = (ImageView)findViewById(R.id.imageView14);
        imageViews[15] = (ImageView)findViewById(R.id.imageView15);

        crestIDs[0] = (R.drawable.crest16);
        crestIDs[1] = (R.drawable.crest1);
        crestIDs[2] = (R.drawable.crest2);
        crestIDs[3] = (R.drawable.crest3);
        crestIDs[4] = (R.drawable.crest4);
        crestIDs[5] = (R.drawable.crest5);
        crestIDs[6] = (R.drawable.crest6);
        crestIDs[7] = (R.drawable.crest7);
        crestIDs[8] = (R.drawable.crest8);
        crestIDs[9] = (R.drawable.crest9);
        crestIDs[10] = (R.drawable.crest10);
        crestIDs[11] = (R.drawable.crest11);
        crestIDs[12] = (R.drawable.crest12);
        crestIDs[13] = (R.drawable.crest13);
        crestIDs[14] = (R.drawable.crest14);
        crestIDs[15] = (R.drawable.crest15);

        shuffleArray(crestIDs);

        int i=0;
        for (ImageView iv: imageViews) {
            iv.setImageResource(crestIDs[i]);
            i++;
        }

    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(int[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tournament__a_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
