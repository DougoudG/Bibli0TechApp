package com.example.testtechnorest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testtechnorest.rest.HttpUtils;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = findViewById(R.id.label_REST);

        HttpUtils connection = new HttpUtils();

        RequestParams params = new RequestParams();

        params.put("fkUtilisateur", 1);

        connection.get("http://dougoudg.emf-informatique.ch/151_personal-projet-DOUGOUD-Guillaume/Server/utilisateurManager.php", params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                label.setText(statusCode+": "+responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                label.setText(responseString);
            }
        });

    }

}
