package kr.hkit.iotmobile;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import kr.hkit.iotmobile.preference.AddressPreference;
import kr.hkit.iotmobile.socket.SocketClient;
import kr.hkit.iotmobile.socket.SocketClientListener;


public class TextActivity extends AppCompatActivity {

    private EditText sendEditText;
    private TextView receiveMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        sendEditText = findViewById(R.id.sendEditText);
        receiveMessageTextView = findViewById(R.id.receiveMessageTextView);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(onSendClickListener);
    }

    private View.OnClickListener onSendClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(sendEditText.getText().length() > 0) {
                String sendMessage = sendEditText.getText().toString();

                AddressPreference ap = new AddressPreference(getBaseContext());
                String ip = ap.getIP();
                int port = ap.getPort();

                SocketClient socketClient = new SocketClient(ip, port, sendMessage, socketClientListener);
                socketClient.execute();
            }
        }
    };

    private SocketClientListener socketClientListener = new SocketClientListener() {
        @Override
        public void onReceiveMessage(String receiveMessage) {
            receiveMessageTextView.setText(receiveMessage);
        }
    };
}