package kr.hkit.iotmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kr.hkit.iotmobile.preference.AddressPreference;
import kr.hkit.iotmobile.socket.SocketClient;
import kr.hkit.iotmobile.socket.SocketClientListener;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView ledTextview = findViewById(R.id.ledTextView);
        TextView tvTextview = findViewById(R.id.tvTextView);

        Button ledButton = findViewById(R.id.ledButton);
        ledButton.setOnClickListener(onLedListener);

        Button tvButton = findViewById(R.id.tvButton);
        tvButton.setOnClickListener(onTvListener);
    }

    public View.OnClickListener onLedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            AddressPreference ap = new AddressPreference(getBaseContext());
            String ip = ap.getIP();
            int port = ap.getPort();

            SocketClient socketClient = new SocketClient(ip, port, "LED", socketClientListener);
            socketClient.execute();
        }
    };

    public View.OnClickListener onTvListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AddressPreference ap = new AddressPreference(getBaseContext());
            String ip = ap.getIP();
            int port = ap.getPort();

            SocketClient socketClient = new SocketClient(ip, port, "TV", socketClientListener);
            socketClient.execute();
        }
    };

    private SocketClientListener socketClientListener = new SocketClientListener() {
        @Override
        public void onReceiveMessage(String receiveMessage) {
            TextView ledTextview = findViewById(R.id.ledTextView);
            TextView tvTextview = findViewById(R.id.tvTextView);

            if(receiveMessage.contains("TV ON")){
                tvTextview.setText("ON");
            }else if(receiveMessage.contains("TV OFF")){
                tvTextview.setText(getString(R.string.OFF));
            }

            if(receiveMessage.contains("LED ON")){
                ledTextview.setText(getString(R.string.ON));
            }else if(receiveMessage.contains("LED OFF")){
                ledTextview.setText(getString(R.string.OFF));
            }
        }
    };
}
