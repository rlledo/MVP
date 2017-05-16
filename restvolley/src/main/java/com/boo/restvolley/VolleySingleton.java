package com.boo.restvolley;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by rflledo on 16/05/2017.
 */

public class VolleySingleton {
    private static VolleySingleton singleton;
    private static Context context;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private VolleySingleton(Context context) {
        VolleySingleton.context = context;
        requestQueue = getRequesQueue();

        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(30);
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }
    public static synchronized VolleySingleton getInstance(Context context) {
        if (singleton==null) {
            singleton = new VolleySingleton(context);
        }
        return singleton;
    }
    public RequestQueue getRequesQueue() {
        if (requestQueue==null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public void addToRequestQueue(Request req) {
        getRequesQueue().add(req);
    }
    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
