package com.boo.mvp.modelo;

import android.content.Context;

import com.android.volley.VolleyError;
import com.boo.mvp.interfaces.ProvidedModelOps;
import com.boo.mvp.interfaces.RequiredPresenterOps;
import com.boo.restvolley.RestVolley;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by rflledo on 16/05/2017.
 */

public class ModeloImpl extends RestVolley implements ProvidedModelOps{
    ArrayList<Object> lista;
    RequiredPresenterOps requiredPresenterOps;
    public ModeloImpl(Context context, RequiredPresenterOps presenterOps) {
        super(context);
        this.requiredPresenterOps=presenterOps;
    }

    @Override
    public void respuestaCorrecta(JSONArray respuesta) {

    }

    @Override
    public void respuestaError(VolleyError error) {

    }

    @Override
    public ArrayList<Object> getDatos() {
        return lista;
    }
}
