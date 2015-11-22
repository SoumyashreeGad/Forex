package com.example.soumyashree.forex;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;


public class LocalCurrency extends AppCompatActivity {
    private static Button lower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_currency);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView tv=(TextView) findViewById(R.id.textView3);
        String country = getApplicationContext().getResources().getConfiguration().locale.getDisplayCountry();
        tv.setText(country);
        TextView tv1=(TextView) findViewById(R.id.textView12);
        tv1.setText("USD");
        lower= (Button) findViewById(R.id.button5);
        lower.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.soumyashree.forex.ShowLowerDenominations");
                        startActivity(intent);
                        System.out.println("Attention: Starting the local currency");
                    }
                }
        );
        //URL oracle = null;
        /*try {
            oracle = new URL("http://www.apilayer.net/api/live?access_key=1de28e638f9a598d292f0eb2b173d3c2");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            URL url = new URL("https://www.google.com");
            Document doc= Jsoup
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/

       /* try {
            url = new URL("http://www.apilayer.net/api/live?access_key=1de28e638f9a598d292f0eb2b173d3c2");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("url connection");
        }
/*        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String ExRAte="";
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
          //  String InData= new String(in);
            char[] buffer = new char[1024];
            //readStream(in);
            if (in != null) {
                Writer writer = new StringWriter();


                try {
                    Reader reader = new BufferedReader(
                            new InputStreamReader(in, "UTF-8"));
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, n);
                    }
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                //return writer.toString();
            }
            //else {
              //  return "";
            //}
            String input = new String(buffer);
            if(input.contains("USDINR")){
                int USDIndex=input.indexOf("USDINR");
                 ExRAte=input.substring(USDIndex+2,USDIndex+7 );
            }
            TextView Ex=(TextView) findViewById(R.id.textView5);
            Ex.setText(ExRAte);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        finally {
            urlConnection.disconnect();
        }*/
      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/

        makeHttpConnection();
}
private void makeHttpConnection(){
   // private DefaultHttpClient client = new DefaultHttpClient();
    /*URL url;
    String response = "";
    try {
        String requestURL="";
        url = new URL(requestURL);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(15000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);


        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write(getPostDataString(postDataParams));

        writer.flush();
        writer.close();
        os.close();
        int responseCode=conn.getResponseCode();

        if (responseCode == HttpsURLConnection.HTTP_OK) {
            String line;
            BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line=br.readLine()) != null) {
                response+=line;
            }
        }
        else {
            response="";

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
*/
    URL url;

    try {
        // get URL content
        url = new URL("http://www.google.com");
        System.out.println("In http req");
       URLConnection conn = url.openConnection();

        // open the stream and put it into BufferedReader
      // BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        InputStreamReader in= new InputStreamReader(conn.getInputStream());
/*        String inputLine;

        //save to this filename
        String
        fileName = "/users/test.html";
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        //use FileWriter to write file
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        while ((inputLine = br.readLine()) != null) {
            bw.write(inputLine);
        }

        bw.close();
        br.close();

        System.out.println("executing http request");
*/
    }

        catch (MalformedURLException e) {
        e.printStackTrace();
    }
        catch (IOException e) {
        e.printStackTrace();
    }
}


}
