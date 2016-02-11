package com.example.wiraazharan.ayrell;

/**
 * Created by wiraazharan on 4/22/15.
 */
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.VideoView;

import java.util.Calendar;

/**
 * Created by wiraazharan on 4/22/15.
 */
public class VideoTwo extends Activity{

    VideoView vidone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vid_two);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();
            }
        }, 203000);


        vidone = (VideoView) findViewById(R.id.vid2);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.two);
        vidone.setVideoURI(video);

        vidone.requestFocus();
        vidone.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        setupAlarm(1,true,1000);
    }


    private void setupAlarm(int seconds, boolean s, int repeat) {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(getBaseContext(), ForceOpen.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                VideoTwo.this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);



        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, seconds);

        if (s == true){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), repeat, pendingIntent);
        }


    }

}
