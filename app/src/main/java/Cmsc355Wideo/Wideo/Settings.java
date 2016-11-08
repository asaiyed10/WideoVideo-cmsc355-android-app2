package cmsc355wideo.wideo;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class Settings extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button buttonQuality = (Button) findViewById(R.id.buttonq);
        Button buttonFlash = (Button) findViewById(R.id.buttonf);
        Button buttonStorage = (Button) findViewById(R.id.buttons);
        Button buttonVoiceRecognition = (Button) findViewById(R.id.buttonv);
        Button buttonAboutUs = (Button) findViewById(R.id.buttona);
        Button shareButton = (Button) findViewById(R.id.buttonshare);

        buttonQuality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quality = new Intent(Settings.this, Quality.class);
                startActivity(quality);
            }
        });
        buttonFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent flash = new Intent(Settings.this, Flash.class);
                startActivity(flash);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent ShareIntent = new Intent(Intent.ACTION_SEND);
                ShareIntent.setType("Text/Plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                ShareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                ShareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(ShareIntent, "Share Using"));
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Settings Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}