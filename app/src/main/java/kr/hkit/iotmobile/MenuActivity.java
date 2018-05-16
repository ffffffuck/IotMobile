package kr.hkit.iotmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import kr.hkit.iotmobile.preference.AddressPreference;
import kr.hkit.iotmobile.socket.SocketClient;
import kr.hkit.iotmobile.socket.SocketClientListener;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button ledButton = findViewById(R.id.ledButton);
        ledButton.setOnClickListener(onLedListener);
    }

    public View.OnClickListener onLedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Toast.makeText(getBaseContext(), "LED!!", Toast.LENGTH_SHORT).show();

            AddressPreference ap = new AddressPreference(getBaseContext());
            String ip = ap.getIP();
            int port = ap.getPort();

            SocketClient socketClient = new SocketClient(ip, port, "LED", socketClientListener);
            socketClient.execute();
        }
    };

    private SocketClientListener socketClientListener = new SocketClientListener() {
        @Override
        public void onReceiveMessage(String receiveMessage) {
            Toast.makeText(getBaseContext(), receiveMessage, Toast.LENGTH_SHORT).show();
        }
    };
}
