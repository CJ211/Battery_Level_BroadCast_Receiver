package com.example.jay.battery_level_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView btv;
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context arg0, Intent intent) {
            // TODO Auto-generated method stub
            int level = intent.getIntExtra("level", 0);
            btv.setText("Battery Level Remaining:"+String.valueOf(level) + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btv=(TextView) findViewById(R.id.tv1);
        this.registerReceiver(this.mBatInfoReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }
}
