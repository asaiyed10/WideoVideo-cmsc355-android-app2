package cmsc355wideo.wideo_1;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.hardware.Camera;

import java.io.IOException;

import static android.content.ContentValues.TAG;


public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback  {
    private SurfaceHolder mHolder;
     private Camera mCamera;

     public CameraPreview(Context context, Camera camera) {
         super(context);
         mCamera = camera;


         mHolder = getHolder();
         mHolder.addCallback(this);
         mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

    public void surfaceCreated(SurfaceHolder holder) {

        try {
             mCamera.setPreviewDisplay(holder);
             mCamera.startPreview();
             }
        catch (IOException e) {
            Log.d(TAG, "Error setting camera preview: " + e.getMessage());
             }

    }
        public void surfaceDestroyed(SurfaceHolder holder) {

         }


    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {

        if (mHolder.getSurface() == null){
            // preview surface does not exist
             return;
            }

         // stop preview before making changes
        try {
             mCamera.stopPreview();
            } catch (Exception e){
           }

        // start preview with new settings
         try {
             mCamera.setPreviewDisplay(mHolder);
             mCamera.startPreview();

            } catch (Exception e){
            Log.d(TAG, "Error starting camera preview: " + e.getMessage());
            }
         }

}

