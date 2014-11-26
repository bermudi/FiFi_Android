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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Random;


public class Tournament extends Activity {

    private static Team[] TEAMS = new Team[16];
    private static String API = PlayerSelection.getApi();

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(Team[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Team a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int players = getIntent().getExtras().getInt("players");

        switch (players) {
            case 3:
                setContentView(R.layout.three_player_layout);  //@FIXME
                break;
            case 4:
                setContentView(R.layout.four_player_layout); //@FIXME
                break;
            case 5:
                setContentView(R.layout.five_player_layout);
                break;
        }

        loadTeams();
        shuffleArray(TEAMS);

        ImageView[] crests = new ImageView[16];
        TextView[] teamNames = new TextView[16];
        TextView[] teamRat = new TextView[16];
        String idCrests[] = new String[16];
        String idNames[] = new String[16];
        String idRat[] = new String[16];

        for (int i = 0; i < 16; i++) {
            idCrests[i] = "crest" + Integer.toString(i + 1);
            idNames[i] = "team" + Integer.toString(i + 1);
            idRat[i] = "rating" + Integer.toString(i + 1);
        }

        for (int i = 0; i < 16; i++) {
            int resID1 = getResources().getIdentifier(idCrests[i], "id", "com.bermudi.fifi");
            crests[i] = (ImageView) findViewById(resID1);
            int resID2 = getResources().getIdentifier(idNames[i], "id", "com.bermudi.fifi");
            teamNames[i] = (TextView) findViewById(resID2);
            int resID3 = getResources().getIdentifier(idRat[i], "id", "com.bermudi.fifi");
            teamRat[i] = (TextView) findViewById(resID3);
        }

        for (int i = 0; i < 16; i++) {
            crests[i].setImageResource(TEAMS[i].getCrest());
            teamNames[i].setText(TEAMS[i].getName());
            teamRat[i].setText(Float.toString(TEAMS[i].getRating()));
        }
    }

    private void loadTeams() {

        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key) + API, Context.MODE_PRIVATE);

        Gson gsonTeam = new Gson();
        String strTeam;

        for (int i = 0; i < 16; i++) {
            strTeam = sharedPref.getString(Integer.toString(i), "");
            TEAMS[i] = gsonTeam.fromJson(strTeam, Team.class);
        }

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.tournament__a_layout, menu);
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
