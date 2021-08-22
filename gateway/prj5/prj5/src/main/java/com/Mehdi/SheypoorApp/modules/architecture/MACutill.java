package com.Mehdi.SheypoorApp.modules.architecture;

import java.io.IOException;

public class MACutill {

    public void getMAC() throws IOException {
        Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
        java.io.BufferedReader in = new java.io.BufferedReader(new  java.io.InputStreamReader(p.getInputStream()));
        String line;
        line = in.readLine();
        String[] result = line.split(",");

        System.out.println(result[0].replace('"', ' ').trim());
    }

}
