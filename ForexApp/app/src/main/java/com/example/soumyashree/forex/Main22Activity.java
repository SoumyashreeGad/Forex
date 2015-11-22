package com.example.soumyashree.forex;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;

public class Main22Activity extends AppCompatActivity {

    private static final String LOG_THREAD_ACTIVITY = "1";
    private String rcvd;
    private String rcvd1;
    private static Button button_setreminder;
    private static Button button_currconv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // new HttpTask().execute("http://www.google.com");
        setContentView(R.layout.activity_main22);
        Intent i =getIntent();
        if(i!=null){
            rcvd=i.getStringExtra("uname");
            rcvd1 = i.getStringExtra("mailid");
            TextView tvname=(TextView) findViewById(R.id.textView2);
            tvname.setText("Hello , "+rcvd+"!");
           // String country = getApplicationContext().getResources().getConfiguration().locale.getDisplayCountry();
            //tvname.setText("you're in" +country);
        }
        onClickbuttonListener();

    }
    public void onClickbuttonListener(){

        button_setreminder = (Button)findViewById(R.id.button2);
        button_currconv = (Button)findViewById(R.id.button3);
        button_setreminder.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.soumyashree.forex.SetReminderActivity");
                        intent.putExtra("email", rcvd1);
                        startActivity(intent);
                    }
                }
        );
        button_currconv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.soumyashree.forex.LocalCurrency");
                        Log.d("POKJ","in local currency");
                        startActivity(intent);
                       System.out.println("Attention: Starting the local currency");
                    }
                }
        );
    }
   /* public String getWebPage(String adresse) {

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet();

        InputStream inputStream = null;

        String response = null;

        try {

            URI uri = new URI(adresse);
            httpGet.setURI(uri);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            int statutCode = httpResponse.getStatusLine().getStatusCode();
            int length = (int) httpResponse.getEntity().getContentLength();

            Log.v(LOG_THREAD_ACTIVITY, "HTTP GET: " + adresse);
            Log.v(LOG_THREAD_ACTIVITY, "HTTP StatutCode: " + statutCode);
            Log.v(LOG_THREAD_ACTIVITY, "HTTP Lenght: " + length + " bytes");

            inputStream = httpResponse.getEntity().getContent();
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            int inChar;
            StringBuffer stringBuffer = new StringBuffer();

            while ((inChar = reader.read()) != -1) {
                stringBuffer.append((char) inChar);
            }

            response = stringBuffer.toString();

        } catch (ClientProtocolException e) {
            Log.e(LOG_THREAD_ACTIVITY, "HttpActivity.getPage() ClientProtocolException error", e);
        } catch (IOException e) {
            Log.e(LOG_THREAD_ACTIVITY, "HttpActivity.getPage() IOException error", e);
        } catch (URISyntaxException e) {
            Log.e(LOG_THREAD_ACTIVITY, "HttpActivity.getPage() URISyntaxException error", e);
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();

            } catch (IOException e) {
                Log.e(LOG_THREAD_ACTIVITY, "HttpActivity.getPage() IOException error lors de la fermeture des flux", e);
            }
        }

        return response;
    }*/

}


