package gaza.ssd.parkheonjin.sunbaenim;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

public class EmailSendActivity extends AppCompatActivity {

    Button sendButton = null;
    ProgressDialog dialog;
    EditText message;
    GMailSender sender;
    View view;

    boolean interupt = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.main_title);
        setContentView(R.layout.activity_email_send);

        //인터넷 사용을 위한 권한을 허용(이메일을 사용할 준비하는 코드)
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork().build());

        sendButton = (Button) findViewById(R.id.send_button);
        message = (EditText) findViewById(R.id.message);

        //전송하기 버튼 이벤트 처리
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sender = new GMailSender("b2akcon@gmail.com", "vkfks157"); // SUBSTITUTE ID PASSWORD
                timeThread();
            }
        });
    }

    public void timeThread() {
        dialog = new ProgressDialog(this);
        dialog.setTitle("Wait...");
        dialog.setMessage("의견을 보내는 중입니다.");
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();
        new Thread(new Runnable() {

            public void run() {

                // TODO Auto-generated method stub
                try {
                    sender.sendMail("의견보내기", // subject.getText().toString(),
                            message.getText().toString(), // body.getText().toString(),
                            "b2akcon@gmail.com", // from.getText().toString(),
                            "b2akcon@gmail.com" // to.getText().toString()
                    );
                    sleep(3000);
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "네트워크 상태를 확인해주세요.", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                    interupt = false;
                    finish();

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (interupt) {
                            Toast.makeText(getApplicationContext(), "의견 주셔서 감사합니다:)", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
                finish();
            }

            private void sleep(int i) {
                // TODO Auto-generated method stub

            }

        }).start();
    }

}


