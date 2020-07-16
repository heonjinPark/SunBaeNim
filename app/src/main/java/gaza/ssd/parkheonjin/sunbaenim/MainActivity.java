package gaza.ssd.parkheonjin.sunbaenim;

import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView mainButton1, mainButton2, mainButton3, mainButton4, mainButton5;
    ImageView mainButton6, mainButton7;

    Button questionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActionBar 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.main_title);

        setContentView(R.layout.activity_main);

        //인터넷 사용을 위한 권한을 허용(이메일을 사용할 준비하는 코드)
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork().build());

        //애드몹 광고를 받아오는 소스(?)
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        MobileAds.initialize(this, "ca-app-pub-5865593614990239~4152530442");

        //tab1 : 메인화면 9개 ImageButton(음식별)
        mainButton1 = (ImageButton) findViewById(R.id.tab1_main_button1);
        mainButton2 = (ImageButton) findViewById(R.id.tab1_main_button2);
        mainButton3 = (ImageButton) findViewById(R.id.tab1_main_button3);
        mainButton4 = (ImageButton) findViewById(R.id.tab1_main_button4);
        mainButton5 = (ImageButton) findViewById(R.id.tab1_main_button5);
        mainButton6 = (ImageButton) findViewById(R.id.tab1_main_button6);
        mainButton7 = (ImageButton) findViewById(R.id.tab1_main_button7);
        questionButton = (Button) findViewById(R.id.question_button);
        mainButton1.setOnClickListener(this);
        mainButton2.setOnClickListener(this);
        mainButton3.setOnClickListener(this);
        mainButton4.setOnClickListener(this);
        mainButton5.setOnClickListener(this);
        mainButton6.setOnClickListener(this);
        mainButton7.setOnClickListener(this);
        questionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //메인화면 9개 이미지버튼
        if (v == mainButton1) {
            Intent intent = new Intent(MainActivity.this, MainListActivity.class);
            intent.putExtra("index", 0);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        } else if (v == mainButton2) {
            Intent intent = new Intent(MainActivity.this, MainListActivity.class);
            intent.putExtra("index", 1);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        } else if (v == mainButton3) {
            Intent intent = new Intent(MainActivity.this, MainListActivity.class);
            intent.putExtra("index", 2);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        } else if (v == mainButton4) {
            Intent intent = new Intent(MainActivity.this, MainListActivity.class);
            intent.putExtra("index", 3);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        } else if (v == mainButton5) {
            Intent intent = new Intent(MainActivity.this, MainListActivity.class);
            intent.putExtra("index", 4);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        } else if (v == mainButton6) {
            Intent intent = new Intent(MainActivity.this, MainListActivity.class);
            intent.putExtra("index", 5);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        } else if (v == mainButton7) {
            Intent intent = new Intent(MainActivity.this, MainListActivity.class);
            intent.putExtra("index", 6);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        } else if (v == questionButton) {
            Intent intent = new Intent(MainActivity.this, EmailSendActivity.class);
            startActivity(intent);
        }
    }
}



