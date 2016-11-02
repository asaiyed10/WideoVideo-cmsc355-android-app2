package cmsc355wideo.wideo_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button button_quality = (Button) findViewById(R.id.buttonq);
        Button button_flash= (Button) findViewById(R.id.buttonf);
        Button button_storage= (Button) findViewById(R.id.buttons);
        Button button_voicerecognition = (Button) findViewById(R.id.buttonv);
        Button button_about_us = (Button) findViewById(R.id.buttona);

        button_quality.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent quality = new Intent(settings.this, quality.class);
                                startActivity(quality);
                            }
                    });
        button_quality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flash = new Intent(settings.this, Flash.class);
                startActivity(flash);
            }
        });



    }
}
