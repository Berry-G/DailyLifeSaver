package com.ksnu.dailylifesaver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
//            intent i = new Intent(context, ScreenService.class)
        }
    }
}
