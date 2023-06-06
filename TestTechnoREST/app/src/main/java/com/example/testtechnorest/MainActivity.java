package com.example.testtechnorest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testtechnorest.rest.HttpUtils;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = findViewById(R.id.label_REST);

        HttpUtils connection = new HttpUtils();

        JSONObject loginData = new JSONObject();
        RequestParams params = new RequestParams();

        params.put(fkUtilisateur, 1);

        connection.post("http://dougoudg.emf-informatique.ch/151_personal-projet-DOUGOUD-Guillaume/Server/livreManager.php",params,responseHandlerGet());

        label.setText("Bien le bonjour");
    }

    private static void responseHandlerGet(){


    }

}
