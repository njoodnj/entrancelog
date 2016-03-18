package com.example.nkssa.entrancelog;

/**
 * Created by nkssa on 3/19/2016.
 */

public class visitorphp extends visitorchanges {
    String URL = "http://10.197.101.229/ES/entrancelog.php";
    String url = "";
    String response = "";

    public String tampilBiodata() {
        try {
            url = URL + "?operation=view";
            System.out.println("URL Tampil visitorphp: " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

}


