package com.bermudi.fifi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PlayerSelection extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);

        final Intent intent = new Intent(getApplicationContext(), Tournament_A_layout.class);

        final Button btn3players = (Button)findViewById(R.id.btn3players);
        btn3players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("players",1);
                startActivity(intent);

            }
        });

        final Button btn4players = (Button)findViewById(R.id.btn4players);
        btn4players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("players",2);
                startActivity(intent);

            }
        });

        final Button btn5players = (Button)findViewById(R.id.btn5players);
        btn5players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent asd = new Intent(getApplicationContext(), );

                /* Plan
                1. Provide all images as resources
                2. add field to team for downloaded crest
                3. check if team has modified crest
                4. deliver modified crest

                 */

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.player_selection, menu);
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
    }

}
