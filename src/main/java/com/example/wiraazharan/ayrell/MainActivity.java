package com.example.wiraazharan.ayrell;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    Button one,two,three,four,five,six,seven,eight,camera,video;
    static final int REQUEST_VIDEO_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 2;
    MediaPlayer mediaPlayer;
    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random ran = new Random();
        int x = ran.nextInt(5) + 1;

        if (x == 1){
            mediaPlayer = MediaPlayer.create(this, R.raw.bgsound);
            mediaPlayer.setVolume(100, 100);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        }else if (x == 2){
            mediaPlayer = MediaPlayer.create(this, R.raw.bgsound2);
            mediaPlayer.setVolume(100, 100);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        }else if (x == 3){
            mediaPlayer = MediaPlayer.create(this, R.raw.bgsound3);
            mediaPlayer.setVolume(100, 100);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        }else if (x == 4){
            mediaPlayer = MediaPlayer.create(this, R.raw.bgsound4);
            mediaPlayer.setVolume(100, 100);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        }else if (x == 5){
            mediaPlayer = MediaPlayer.create(this, R.raw.bgsound5);
            mediaPlayer.setVolume(100, 100);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        }


        setupAlarm(1,true,1000);

        one = (Button)findViewById(R.id.vid1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i = new Intent(MainActivity.this, VideoOne.class);
                startActivity(i);
            }
        });

        two = (Button)findViewById(R.id.vid2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i = new Intent(MainActivity.this, VideoTwo.class);
                startActivity(i);

            }
        });

        three = (Button)findViewById(R.id.vid3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i = new Intent(MainActivity.this, VideoThree.class);
                startActivity(i);
            }
        });

        four = (Button)findViewById(R.id.vid4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i = new Intent(MainActivity.this, VideoFour.class);
                startActivity(i);
            }
        });

        five = (Button)findViewById(R.id.vid5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i = new Intent(MainActivity.this, VideoFive.class);
                startActivity(i);
            }
        });

        six = (Button)findViewById(R.id.vid6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i = new Intent(MainActivity.this, VideoSix.class);
                startActivity(i);
            }
        });

        seven = (Button)findViewById(R.id.vid7);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i = new Intent(MainActivity.this, VideoSeven.class);
                startActivity(i);
            }
        });

        eight = (Button)findViewById(R.id.vid8);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i = new Intent(MainActivity.this, VideoEight.class);
                startActivity(i);
            }
        });

        camera = (Button)findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dispatchTakePictureIntent();

            }
        });

        video = (Button)findViewById(R.id.video);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                dispatchTakeVideoIntent();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {

        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        View promptsView = li.inflate(R.layout.passwordfield, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        alertDialogBuilder.setView(promptsView);


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Enter",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                EditText edit = (EditText) ((AlertDialog) dialog).findViewById(R.id.editText1);
                                String userpass = edit.getText().toString();


                                if (userpass.equals("444")) {
                                    setupAlarm(1,false,1000);
                                    finish();

                                } else {
                                    Toast.makeText(getApplicationContext(), "Sorry sangat ayrell, Tok Ibu x kasi keluar", Toast.LENGTH_LONG).show();
                                }

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();






    }



    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }


    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }


    private void setupAlarm(int seconds, boolean s, int repeat) {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(getBaseContext(), ForceOpen.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                MainActivity.this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);



        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, seconds);


        if(s == false){
            alarmManager.cancel(pendingIntent);
        }else if ( s == true )
        {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), repeat, pendingIntent);
        }


    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }


    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        //setupAlarm(1,true,1000);
    }

    @Override
    protected void onResume() {
        if(mediaPlayer != null && !mediaPlayer.isPlaying())
        {
            Random ran = new Random();
            int x = ran.nextInt(5) + 1;

            if (x == 1){
                mediaPlayer = MediaPlayer.create(this, R.raw.bgsound);
                mediaPlayer.setVolume(100, 100);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();

            }else if (x == 2){
                mediaPlayer = MediaPlayer.create(this, R.raw.bgsound2);
                mediaPlayer.setVolume(100, 100);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();

            }else if (x == 3){
                mediaPlayer = MediaPlayer.create(this, R.raw.bgsound3);
                mediaPlayer.setVolume(100, 100);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();

            }else if (x == 4){
                mediaPlayer = MediaPlayer.create(this, R.raw.bgsound4);
                mediaPlayer.setVolume(100, 100);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();

            }else if (x == 5){
                mediaPlayer = MediaPlayer.create(this, R.raw.bgsound5);
                mediaPlayer.setVolume(100, 100);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();

            }



        }

        super.onResume();

    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }
}
