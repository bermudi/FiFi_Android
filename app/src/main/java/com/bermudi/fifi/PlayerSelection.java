/*
 * Copyright (c) 2014 Daniel Bermudez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.bermudi.fifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PlayerSelection extends Activity {
    //Names for Preferences Keys
    private static final String PREF_FR = "firstRun";
    private static final String API = "1.1";

    public static String getApi() {

        return API;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);

        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key) + API, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        if (sharedPref.getBoolean(PREF_FR, true)) {

            Team.createDefaults(this);
            editor.putBoolean(PREF_FR, false);
            editor.commit();
        }

        final Button btn3players = (Button) findViewById(R.id.btn3players);
        btn3players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerSelected(3);
            }
        });

        final Button btn4players = (Button) findViewById(R.id.btn4players);
        btn4players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerSelected(4);
            }
        });

        final Button btn5players = (Button) findViewById(R.id.btn5players);
        btn5players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerSelected(5);
            }
        });
    }

    private void playerSelected(int i) {

        Intent intent = new Intent(getApplicationContext(), Tournament.class);
        intent.putExtra("players", i);
        startActivity(intent);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.player_selection, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
