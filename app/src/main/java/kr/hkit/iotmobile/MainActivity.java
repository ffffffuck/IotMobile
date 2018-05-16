package kr.hkit.iotmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button speechButton = findViewById(R.id.speechButton);
        speechButton.setOnClickListener(onSpeechClickListener);


        Button textButton = findViewById(R.id.textButton);
        textButton.setOnClickListener(onTextClickListener);

        Button settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(onSettingListener);

        ImageButton imgButton = findViewById(R.id.imgButton);
        imgButton.setOnClickListener(onImgListener);
    }


    private View.OnClickListener onSpeechClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(),SpeechActivity.class);

            startActivity(intent);
        }
    };

    private View.OnClickListener onTextClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(),TextActivity.class);

            startActivity(intent);

        }
    };

    private View.OnClickListener onSettingListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(),SettingActivity.class);

            startActivity(intent);
        }
    };

    private View.OnClickListener onImgListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(),SpeechActivity.class);

            startActivity(intent);
        }
    };
}
