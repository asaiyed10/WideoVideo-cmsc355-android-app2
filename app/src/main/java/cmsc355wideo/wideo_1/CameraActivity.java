package cmsc355wideo.wideo_1;

import static android.content.ContentValues.TAG;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class CameraActivity extends Activity {
    private Camera myCamera;
    private CameraPreview myPreview;
    private MediaRecorder myMediaRecorder;
    private boolean isRecording = false;
    private Button stop;
    private Button record;
    public static final int MEDIA_VIDEO = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_preview);

        myCamera = getCameraInstance();
        myPreview = new CameraPreview(this, myCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(myPreview);
        stop = (Button) findViewById(R.id.button_stop);
        record = (Button) findViewById(R.id.button_capture);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRecording) {
                    stopRecording();
                } else {
                    if (prepareVideoRecorder()) {
                        startRecording();
                    } else {
                        releaseMediaRecorder();
                    }
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                stopRecording();
            }
        });
    }

    public void onPause() {
        super.onPause();
        releaseMediaRecorder();
        cameraRelease();
    }

    public void onResume(){
        super.onResume();
        if (myCamera == null) {
            myCamera = getCameraInstance();
            myPreview = new CameraPreview(this, myCamera);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(myPreview);
        }
    }

    private void cameraRelease() {
        if (myCamera != null) {
            myCamera.release();
            myCamera = null;
        }
    }

    public static Camera getCameraInstance() {
        Camera cam = null;
        try {
            cam = Camera.open();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cam;
    }

    public void stopRecording(){
        myMediaRecorder.stop();
        releaseMediaRecorder();
        myCamera.lock();
        stop.setVisibility(View.GONE);
        record.setVisibility(View.VISIBLE);
        isRecording = false;
    }

    public void startRecording(){
        myMediaRecorder.start();
        stop.setVisibility(View.VISIBLE);
        record.setVisibility(View.GONE);
        isRecording = true;
    }

    private boolean prepareVideoRecorder() {
        myMediaRecorder = new MediaRecorder();
        myCamera.unlock();
        myMediaRecorder.setCamera(myCamera);

        myMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        myMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

        myMediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));

        myMediaRecorder.setOutputFile(getOutputMediaFile(MEDIA_TYPE_VIDEO).toString());

        myMediaRecorder.setPreviewDisplay(myPreview.getHolder().getSurface());

        try {
            myMediaRecorder.prepare();
        } catch (IllegalStateException ex) {
            Log.d(TAG, "IllegalStateException preparing MediaRecorder: " + ex.getMessage());
            releaseMediaRecorder();
            return false;
        } catch (IOException ex) {
            Log.d(TAG, "IOException preparing MediaRecorder: " + ex.getMessage());
            releaseMediaRecorder();
            return false;
        }
        return true;
    }

    private void releaseMediaRecorder() {
        if (myMediaRecorder != null) {
            myMediaRecorder.reset();
            myMediaRecorder.release();
            myMediaRecorder = null;
            myCamera.lock();
        }
    }

    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Wideo");
        if (! mediaStorageDir.exists()) {
            if (! mediaStorageDir.mkdirs()) {
                Log.d("Wideo", "failed to create directory");
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        File mediaFile;
        if (type == MEDIA_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath()
                    + File.separator + "VID_" + timeStamp + ".mp4");
        } else {
            return null;

        }
        return mediaFile;
    }

}