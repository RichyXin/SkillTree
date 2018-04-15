package com.richy.skilltree.multiProcess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.blankj.ALog;
import com.richy.skilltree.aidl.Book;
import com.richy.skilltree.aidl.IMyAidlInterface;

public class ProcessService extends Service {
    public ProcessService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mIBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ALog.d("onStartCommand");
        return START_STICKY;
    }

    private IBinder mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public String getInfo(String s) throws RemoteException {
            return "server info Clientinfo=" + s;
        }

        @Override
        public String getName(char name) throws RemoteException {
            return name +" is too short";
        }

        @Override
        public String getBook(Book book) throws RemoteException {
            return book.toString();
        }
    };
}
