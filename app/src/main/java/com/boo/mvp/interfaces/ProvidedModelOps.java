package com.boo.mvp.interfaces;

import java.util.ArrayList;

/**
 * Created by rflledo on 16/05/2017.
 * operaciones a las cuales tiene acceso el presentador y son implementadas por el modelo
 * Presentador->Modelo
 */

public interface ProvidedModelOps {
    ArrayList<Object> getDatos();
}
