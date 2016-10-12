package cmsc355wideo.wideo_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class quality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality);

        Button button_quality = (Button) findViewById(R.id.button720);
        Button button_flash= (Button) findViewById(R.id.button1080);
        Button button_storage= (Button) findViewById(R.id.button4k);

    }

}
