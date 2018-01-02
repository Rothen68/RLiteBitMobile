package com.rothenflue.services.web;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by apest on 02/01/2018.
 */

public class WebRequestService {

    RequestQueue requestQueue;

    public WebRequestService(Context context) {
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1 * 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);

        requestQueue.start();
    }


    public void sendGETWebRequest(String url, final ResponseListener listener) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.networkResponse.statusCode, error.getMessage());
            }
        });

        requestQueue.add(request);
    }

    public void cancelAllRequests() {
        requestQueue.cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
    }

    public void clearCache() {
        requestQueue.getCache().clear();
    }

    public interface ResponseListener {
        void onResponse(String response);

        void onError(int statusCode, String message);
    }

}
