package cmsc355Wideo.Wideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button buttonQuality = (Button) findViewById(R.id.buttonq);
        Button buttonFlash = (Button) findViewById(R.id.buttonf);
        Button buttonStorage = (Button) findViewById(R.id.buttons);
        Button buttonVoiceRecognition = (Button) findViewById(R.id.buttonv);
        Button buttonAboutUs = (Button) findViewById(R.id.buttona);

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



    }
}
