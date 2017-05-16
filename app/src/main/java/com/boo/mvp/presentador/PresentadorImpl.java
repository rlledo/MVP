package com.boo.mvp.presentador;

import com.boo.mvp.interfaces.RequiredPresenterOps;
import com.boo.mvp.interfaces.RequiredViewOps;
import com.boo.mvp.modelo.ModeloImpl;

/**
 * Created by rflledo on 16/05/2017.
 */

public class PresentadorImpl implements RequiredPresenterOps {
    ModeloImpl modelo;
    RequiredViewOps vista;
    public PresentadorImpl(RequiredViewOps requiredPresenterOps) {
        modelo = new ModeloImpl(null,this);
        this.vista=requiredPresenterOps;
    }
}
