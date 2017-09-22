package com.amk.examen.utils;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by andresaleman on 9/22/17.
 */

public class FunctionJson
{
    public final static int GET = 1;
    public final static int POST = 2;
    public final static int PUT = 3;
    public final static int DELETE = 4;

    public String RequestHttp(String url, int method, String params)
    {
        String response="";

        try
        {
            if(method==1)
            {
                response = GetResponse(url);
            }
        }
        catch (Exception ex)
        {

        }
        return response;
    }

    private String GetResponse(String url) throws Exception
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        String responseGet="";
        try
        {

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");


            //add request header
            //con.setRequestProperty("begin", "1430295300000");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                responseGet += inputLine;
            }
            in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return responseGet;

    }
}
