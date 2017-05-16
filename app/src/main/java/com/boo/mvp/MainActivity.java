package com.boo.mvp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.boo.mvp.interfaces.RequiredViewOps;
import com.boo.mvp.presentador.PresentadorImpl;

public class MainActivity extends AppCompatActivity implements RequiredViewOps {
    PresentadorImpl presentador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentador = new PresentadorImpl(this);

    }
}
