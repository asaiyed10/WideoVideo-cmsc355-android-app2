package cmsc355wideo.wideo_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_record = (Button) findViewById(R.id.button);
        Button button_gallery = (Button) findViewById(R.id.button2);
        Button button_settings = (Button) findViewById(R.id.button3);
        Button button_quit = (Button) findViewById(R.id.button4);
        Button button_friends = (Button) findViewById(R.id.button5);
        button_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        button_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(camera);
            }
        });}


    public void onClick(View v) {
        Intent contacts = new Intent(MainActivity.this, Contacts.class);
        startActivity(contacts);
    }
}



