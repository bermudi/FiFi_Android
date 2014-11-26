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

//import java.awt.image.BufferedImage; @FIXME
//import javax.imageio.ImageIO;         @FIXME


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;


public class Team {

    private static String API = PlayerSelection.getApi();

    //public static final String TEAM_LOC = "res/crests"; //@FIXME is this needed?

    private static int teamQty = 0;

    private String name;
    private float rating;
    private int crest;
    private int id;

//    public String getCrestWebLink(String team) {
//        String crestLink = "";
//        team = team.replaceAll(" ", "%20");
//
//        try {
//            UserAgent userAgent = new UserAgent();
//            userAgent.visit("http://en.wikipedia.org/wiki/Special:Search?search=" + team);
//            crestLink = userAgent.doc.findFirst("<table class=\"infobox vcard\">").findFirst("<img>").getAt("src");
//        } catch (JauntException e) {         //if an HTTP/connection error occurs, handle JauntException.
//            System.err.println(e);
//        }
//
//        return crestLink;
//    }

//    private String saveCrestFile(String link) throws IOException {
//        String filename;
//        String ext = link.substring(link.length() - 3);
//        filename = "crest" + id + "." + ext;
//
//        BufferedImage image = null;
//        URL url = new URL(link);
//        image = ImageIO.read(url);
//        File outputfile = new File(TEAM_LOC + "/" + filename);
//        ImageIO.write(image, ext, outputfile);
//
//        return filename;
//    }

    public Team(String n, float r, int i) {
        name = n;
        rating = r;
        crest = i;
        id = teamQty++;
    }

    public Team() {
        name = "";
        rating = 0f;
        crest = 0;
        id = teamQty++;
    }

    private static SharedPreferences getSharedPrefs(Context c) {

        SharedPreferences sharedPref = c.getSharedPreferences(
                c.getResources().getString(
                        R.string.preference_file_key) + API, Context.MODE_PRIVATE);

        return sharedPref;
    }

    public static Team[] loadTeams(Team[] teams, Context c) {

        SharedPreferences sp = getSharedPrefs(c);
        Gson gsonTeam = new Gson();
        String strTeam;

        for (int i = 0; i < teams.length; i++) {
            strTeam = sp.getString(Integer.toString(i), "");
            teams[i] = gsonTeam.fromJson(strTeam, Team.class);
        }

        return teams;

    }

    public static Team[] saveTeams(Team[] teams, Context c) {

        SharedPreferences sp = getSharedPrefs(c);
        SharedPreferences.Editor editor = sp.edit();

        for (Team t : teams) {
            Gson gsonTeam = new Gson();
            String i = Integer.toString(t.getID());
            editor.putString(i, gsonTeam.toJson(t));
        }

        editor.apply();
        return teams;
    }

    public static void createDefaults(Context c) {

        Team[] teams = new Team[16];

        teams[0] = new Team("Manchester United", 5f, R.drawable.crest1);
        teams[1] = new Team("Real Madrid", 5f, R.drawable.crest2);
        teams[2] = new Team("Paris Saint Germain", 5f, R.drawable.crest3);
        teams[3] = new Team("Liverpool", 4.5f, R.drawable.crest4);
        teams[4] = new Team("Arsenal", 4.5f, R.drawable.crest5);
        teams[5] = new Team("F.C. Barcelona", 5f, R.drawable.crest6);
        teams[6] = new Team("Chelsea", 5f, R.drawable.crest7);
        teams[7] = new Team("Tottenham Hotspur", 4.5f, R.drawable.crest8);
        teams[8] = new Team("A.C. Milan", 4.5f, R.drawable.crest9);
        teams[9] = new Team("Juventus", 5f, R.drawable.crest10);
        teams[10] = new Team("Internazionale Milano", 4.5f, R.drawable.crest11);
        teams[11] = new Team("Manchester City", 5f, R.drawable.crest12);
        teams[12] = new Team("Atlético Madrid", 4.5f, R.drawable.crest13);
        teams[13] = new Team("Borussia Dortmund", 5f, R.drawable.crest14);
        teams[14] = new Team("Bayern Munich", 5f, R.drawable.crest15);
        teams[15] = new Team("Galatasaray SK", 4f, R.drawable.crest16);

        saveTeams(teams, c);
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public int getID() {
        return id;
    }

    public int getCrest() {
        return crest;
    }

}
