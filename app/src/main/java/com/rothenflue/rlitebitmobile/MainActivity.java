package com.rothenflue.rlitebitmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rothenflue.services.bdd.entities.Currency;
import com.rothenflue.services.bdd.entities.CurrencyAvailability;
import com.rothenflue.services.web.WebRequestService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

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
                        loadContent(response);
                    }

                    @Override
                    public void onError(int statusCode, String message) {
                        etxtResult.setText(statusCode + " : " + message);
                    }
                });
            }
        });

    }

    private void loadContent(String response) {
        etxtResult.setText(response);

        try {
            JSONObject reader = new JSONObject(response);
            JSONObject result = reader.getJSONObject("result");

            Iterator<?> keys = result.keys();

            while (keys.hasNext()) {
                String key = (String) keys.next();
                if (result.get(key) instanceof JSONObject) {
                    JSONObject cur = result.getJSONObject(key);
                    Currency c = new Currency();
                    c.setName(cur.getString("name"));
                    c.setAttr(cur.getString("abbr"));
                    ((CustomApplication) getApplication()).getDaoService().setCurrency(c);
                    CurrencyAvailability ca = new CurrencyAvailability();
                    ca.setCurrencyId(c.getId());
                    ca.setTimestamp(System.currentTimeMillis());
                    ca.setAvailable(cur.getDouble("available"));
                    ca.setVolume(cur.getDouble("volume"));
                    ca.setBuy(cur.getDouble("buy"));
                    ca.setSell(cur.getDouble("sell"));
                    ((CustomApplication) getApplication()).getDaoService().setCurrencyAvailiability(ca);
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
