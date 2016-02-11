package com.example.wiraazharan.ayrell;

/**
 * Created by wiraazharan on 4/22/15.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;




public class ForceOpen extends BroadcastReceiver {


    private static final String TAG = null;

    @Override
    public void onReceive(Context context, Intent intent) {


        Log.d(TAG, "BroadcastReceiver, in onReceive:");

        //open the main activity when the relauch time ticks

        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(i);

    }


}