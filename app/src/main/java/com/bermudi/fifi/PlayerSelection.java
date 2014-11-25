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

import com.google.gson.Gson;


public class PlayerSelection extends Activity {
    //Names for Preferences Keys
    private static final String PREF_FR = "firstRun";
    private static final String API = "1.0";

    private static Team[] TEAMS = new Team[16];

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

            createDefaults();
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

    private void createDefaults() {

        TEAMS[0] = new Team("Manchester United", 5f, R.drawable.crest1);
        TEAMS[1] = new Team("Real Madrid", 5f, R.drawable.crest2);
        TEAMS[2] = new Team("Paris Saint Germain", 5f, R.drawable.crest3);
        TEAMS[3] = new Team("Liverpool", 4.5f, R.drawable.crest4);
        TEAMS[4] = new Team("Arsenal", 4.5f, R.drawable.crest5);
        TEAMS[5] = new Team("F.C. Barcelona", 5f, R.drawable.crest6);
        TEAMS[6] = new Team("Chelsea", 5f, R.drawable.crest7);
        TEAMS[7] = new Team("Tottenham Hotspur", 4.5f, R.drawable.crest8);
        TEAMS[8] = new Team("A.C. Milan", 4.5f, R.drawable.crest9);
        TEAMS[9] = new Team("Juventus", 5f, R.drawable.crest10);
        TEAMS[10] = new Team("Internazionale Milano", 4.5f, R.drawable.crest11);
        TEAMS[11] = new Team("Manchester City", 5f, R.drawable.crest12);
        TEAMS[12] = new Team("Atlético Madrid", 4.5f, R.drawable.crest13);
        TEAMS[13] = new Team("Borussia Dortmund", 5f, R.drawable.crest14);
        TEAMS[14] = new Team("Bayern Munich", 5f, R.drawable.crest15);
        TEAMS[15] = new Team("Galatasaray SK", 4f, R.drawable.crest16);

        saveTeams();

    }

    private void saveTeams() {

        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key) + API, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        for (Team t : TEAMS) {
            Gson gsonTeam = new Gson();
            String i = Integer.toString(t.getID());
            editor.putString(i, gsonTeam.toJson(t));
        }

        editor.apply();

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
