package com.rothenflue.rlitebitmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rothenflue.services.web.WebRequestService;

public class MainActivity extends AppCompatActivity {

    EditText etxtResult;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        etxtResult = findViewById(R.id.etxtResult);

        final WebRequestService webService = new WebRequestService(this);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webService.sendGETWebRequest("https://api.litebit.eu/markets", new WebRequestService.ResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        etxtResult.setText(response);
                    }

                    @Override
                    public void onError(int statusCode, String message) {
                        etxtResult.setText(statusCode + " : " + message);
                    }
                });
            }
        });

    }
}
