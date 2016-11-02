package cmsc355wideo.wideo_1;

import android.net.Uri;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class Flash extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);


        Button button_on = (Button) findViewById(R.id.buttonON);
        Button button_off = (Button) findViewById(R.id.buttonOFF);
        Button button_auto = (Button) findViewById(R.id.buttonAUTO);


    }
}


