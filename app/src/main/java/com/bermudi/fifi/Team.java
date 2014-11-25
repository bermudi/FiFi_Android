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

<<<<<<< HEAD
//import java.awt.image.BufferedImage; @FIXME
//import javax.imageio.ImageIO;         @FIXME


public class Team {
=======
import java.io.Serializable;

//import java.awt.image.BufferedImage; @FIXME
//import javax.imageio.ImageIO;         @FIXME

/**
 * @author daniel
 */
public class Team implements Serializable {
>>>>>>> origin/master

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
