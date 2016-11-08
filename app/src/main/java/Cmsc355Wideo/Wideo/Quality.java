package Cmsc355Wideo.Wideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class Quality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality);

        Button buttonQuality = (Button) findViewById(R.id.button720);
        Button buttonFlash = (Button) findViewById(R.id.button1080);
        Button buttonStorage = (Button) findViewById(R.id.button4k);

    }

}
