package cmsc355wideo.wideo_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class Flash extends AppCompatActivity {
    CameraManager mCameraManager;
    String mCameraId;
    ImageButton mTorchOnOffButton;
    Boolean isTorchOn;
    MediaPlayer mp;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        isTorchOn = false;
        Log.d("Flash", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        Button button_on = (Button) findViewById(R.id.buttonON);
        Button button_off = (Button) findViewById(R.id.buttonOFF);
        Button button_auto = (Button) findViewById(R.id.buttonAUTO);

        Boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isFlashAvailable) {

            AlertDialog alert = new AlertDialog.Builder(Flash.this)
                    .create();
            alert.setTitle("Error !!");
            alert.setMessage("Your device doesn't support flash light!");
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // closing the application
                    finish();
                    System.exit(0);
                }
            });
            alert.show();
            return;
        }

        button_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTorchOn) {
                    turnOnFlashLight();
                    isTorchOn = true;
                }
            }

        });
        button_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTorchOn) {
                    turnOffFlashLight();
                    isTorchOn = false;
                }
            }
        });






    }

    public void turnOnFlashLight(){

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mCameraManager.setTorchMode(mCameraId, true);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void turnOffFlashLight() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mCameraManager.setTorchMode(mCameraId, false);



            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isTorchOn){
            turnOffFlashLight();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isTorchOn){
            turnOffFlashLight();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isTorchOn){
            turnOnFlashLight();
        }
    }
}



