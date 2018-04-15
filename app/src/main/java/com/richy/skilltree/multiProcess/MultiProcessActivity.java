package com.richy.skilltree.multiProcess;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.blankj.ALog;
import com.richy.skilltree.R;
import com.richy.skilltree.aidl.IMyAidlInterface;


public class MultiProcessActivity extends AppCompatActivity {

    private Button mBtnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ALog.d("onClick");
                Intent intent = new Intent(MultiProcessActivity.this, ProcessService.class);
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });
    }

    final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ALog.d("onServiceConnected");
            IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                String info = iMyAidlInterface.getInfo("你是谁?");
                ALog.d(info);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            ALog.d("onServiceDisconnected");
        }
    };
}
