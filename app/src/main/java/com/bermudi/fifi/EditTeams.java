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

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class EditTeams extends Activity {

    private static Team[] TEAMS = new Team[16];
    private static String API = PlayerSelection.getApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_teams);
        ActionBar ab = getActionBar();
        ab.hide();

        TEAMS = Team.loadTeams(TEAMS, this);

        ImageView[] crests = new ImageView[16];
        TextView[] teamNames = new TextView[16];
        String idCrests[] = new String[16];
        String idNames[] = new String[16];

        for (int i = 0; i < 16; i++) {
            idCrests[i] = "crest" + Integer.toString(i + 1);
            idNames[i] = "team" + Integer.toString(i + 1);
        }

        for (int i = 0; i < 16; i++) {
            int resID1 = getResources().getIdentifier(idCrests[i], "id", "com.bermudi.fifi");
            crests[i] = (ImageView) findViewById(resID1);
            int resID2 = getResources().getIdentifier(idNames[i], "id", "com.bermudi.fifi");
            teamNames[i] = (TextView) findViewById(resID2);
        }

        for (int i = 0; i < 16; i++) {
            crests[i].setImageResource(TEAMS[i].getCrest());
            teamNames[i].setText(TEAMS[i].getName());
        }

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_edit_teams, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
