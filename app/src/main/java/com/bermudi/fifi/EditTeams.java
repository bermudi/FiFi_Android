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
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EditTeams extends Activity implements View.OnLongClickListener, View.OnTouchListener {

    private static Team[] TEAMS = new Team[16];
    private static String API = PlayerSelection.getApi();
    ImageView[] crests = new ImageView[16];
    TextView[] teamNames = new TextView[16];
    ImageView[] selectedIndicator = new ImageView[16];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_teams);
        ActionBar ab = getActionBar();
        ab.hide();

        TEAMS = Team.loadTeams(TEAMS, this);

        String idCrests[] = new String[16];
        String idNames[] = new String[16];
        String indicatorNames[] = new String[16];

        for (int i = 0; i < 16; i++) {
            idCrests[i] = "editCrest" + Integer.toString(i + 1);
            idNames[i] = "editTeam" + Integer.toString(i + 1);
            indicatorNames[i] = "editSelected" + Integer.toString(i + 1);
        }

        for (int i = 0; i < 16; i++) {
            int resID1 = getResources().getIdentifier(idCrests[i], "id", "com.bermudi.fifi");
            crests[i] = (ImageView) findViewById(resID1);
            int resID2 = getResources().getIdentifier(idNames[i], "id", "com.bermudi.fifi");
            teamNames[i] = (TextView) findViewById(resID2);
            int resID3 = getResources().getIdentifier(indicatorNames[i], "id", "com.bermudi.fifi");
            selectedIndicator[i] = (ImageView) findViewById(resID3);
        }

        for (int i = 0; i < 16; i++) {
            crests[i].setImageResource(TEAMS[i].getCrest());
            crests[i].setTag(TEAMS[i]);
            teamNames[i].setText(TEAMS[i].getName());
            teamNames[i].setTag(TEAMS[i]);
            crests[i].setOnLongClickListener(this);
            crests[i].setOnTouchListener(this);
            teamNames[i].setOnLongClickListener(this);
            teamNames[i].setOnTouchListener(this);
            selectedIndicator[i].setTag(TEAMS[i]);
        }

    }

    private void editTeam() {
    }

    @Override
    public boolean onLongClick(View v) {
        Team team = (Team) v.getTag();
//        switch (team.getID()) {
//
//            case R.id.editCrest1:
//            case R.id.editTeam1:
//                editTeam();
//                break;
//            case R.id.editCrest2:
//            case R.id.editTeam2:
//                editTeam();
//                break;
//            case R.id.editCrest3:
//            case R.id.editTeam3:
//                editTeam();
//                break;
//            case R.id.editCrest4:
//            case R.id.editTeam4:
//                editTeam();
//                break;
//            case R.id.editCrest5:
//            case R.id.editTeam5:
//                editTeam();
//                break;
//            case R.id.editCrest6:
//            case R.id.editTeam6:
//                editTeam();
//                break;
//            case R.id.editCrest7:
//            case R.id.editTeam7:
//                editTeam();
//                break;
//            case R.id.editCrest8:
//            case R.id.editTeam8:
//                editTeam();
//                break;
//            case R.id.editCrest9:
//            case R.id.editTeam9:
//                editTeam();
//                break;
//            case R.id.editCrest10:
//            case R.id.editTeam10:
//                editTeam();
//                break;
//            case R.id.editCrest11:
//            case R.id.editTeam11:
//                editTeam();
//                break;
//            case R.id.editCrest12:
//            case R.id.editTeam12:
//                editTeam();
//                break;
//            case R.id.editCrest13:
//            case R.id.editTeam13:
//                editTeam();
//                break;
//            case R.id.editCrest14:
//            case R.id.editTeam14:
//                editTeam();
//                break;
//            case R.id.editCrest15:
//            case R.id.editTeam15:
//                editTeam();
//                break;
//            case R.id.editCrest16:
//            case R.id.editTeam16:
//                editTeam();
//                break;
//
//        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Team team = (Team) v.getTag();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                selectedIndicator[team.getID()].setBackgroundColor(Color.parseColor("#FF70FF60"));
                break; // if you want to handle the touch event
            case MotionEvent.ACTION_CANCEL:
                selectedIndicator[team.getID()].setBackgroundColor(Color.parseColor("#907c7c7c"));
                break; // if you want to handle the touch event
            case MotionEvent.ACTION_UP:
                selectedIndicator[team.getID()].setBackgroundColor(Color.parseColor("#907c7c7c"));
                break; // if you want to handle the touch event
        }
        return false;
    }

}
