package com.boo.restvolley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by rflledo on 16/05/2017.
 * Clase que realiza peticiones usando la libreria volley y devuelve la respuesta a un manejador
 * o a una funcion
 */

public abstract class RestVolley {
    public static int POST=1;
    public static int GET=2;
    private Context context;

    public RestVolley() {
    }

    public RestVolley(Context context) {
        this.context = context;
    }

    public void getJsonObjectList(int metodo, String url, JSONArray parametros,
                                  final Map<String,String> headers, final String bodyContentType) {
        JsonArrayRequest request = new JsonArrayRequest(metodo, url, parametros,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        respuestaCorrecta(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        respuestaError(error);
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
            @Override
            public String getBodyContentType() {
                return bodyContentType;
            }
        };

        VolleySingleton.getInstance(context).addToRequestQueue(request);
    }

    public void getJsonObject(int metodo, String url, JSONObject parametros,
                                  final Map<String,String> headers, final String bodyContentType) {
        JsonObjectRequest request = new JsonObjectRequest(metodo, url, parametros,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
            @Override
            public String getBodyContentType() {
                return bodyContentType;
            }
        };

        VolleySingleton.getInstance(context).addToRequestQueue(request);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void respuestaCorrecta(JSONArray respuesta);
    public abstract void respuestaError(VolleyError error);
}
