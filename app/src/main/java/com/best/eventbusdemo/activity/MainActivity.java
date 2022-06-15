package com.best.eventbusdemo.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.best.eventbusdemo.R;
import com.best.eventbusdemo.fragment.EventBusFragment;
import com.best.eventbusdemo.model.MessageEvent;
import org.greenrobot.eventbus.EventBus;


public class MainActivity extends AppCompatActivity {

    private FrameLayout fmContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fmContainer = findViewById(R.id.fm_container);

        if (savedInstanceState == null) {
            showEventBusFragment();
            EventBus.getDefault().postSticky(new MessageEvent("Test Event Bus"));
        }
    }

    private void showEventBusFragment() {
        EventBusFragment eventBusFragment = new EventBusFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fm_container, eventBusFragment, "event_bus_Fragment");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}