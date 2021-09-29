package com.example.note;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class Observer  implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void myVoid(LifecycleOwner source, Lifecycle.Event event){
        Log.d("EventT",event.toString());
    }
}
