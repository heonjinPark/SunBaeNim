package gaza.ssd.parkheonjin.sunbaenim;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainInfoActivity extends AppCompatActivity {
    TextView restaurant;
    TextView mincharge;
    TextView delivery_fee;
    ImageView delivery_image;
    Button call_btn;
    String tel;
    int menuImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.main_title);
        setContentView(R.layout.activity_main_info);

        restaurant = (TextView) findViewById(R.id.restaurant);
        mincharge = (TextView) findViewById(R.id.min_charge);
        delivery_fee = (TextView) findViewById(R.id.delivery_fee);
        delivery_image = (ImageView) findViewById(R.id.delivery_image);
        call_btn = (Button) findViewById(R.id.call_btn);

        Intent intent = getIntent();
        String name = intent.getStringExtra("restaurant");
        String charge = intent.getStringExtra("mincharge");
        String delivery = intent.getStringExtra("delivery");
        tel = intent.getStringExtra("tel");
        menuImg = intent.getIntExtra("image", 0);
        restaurant.setText(name);
        mincharge.setText(charge);
        delivery_fee.setText(delivery);
        delivery_image.setImageResource(menuImg);

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* 사용자의 OS 버전이 마시멜로우 이상인지 체크한다. */

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    /* 사용자 단말기의 권한 중 "전화걸기" 권한이 허용되어 있는지 체크한다.
                     *  int를 쓴 이유? 안드로이드는 C기반이기 때문에, Boolean 이 잘 안쓰인다.
                     */
                    int permissionResult = checkSelfPermission(Manifest.permission.CALL_PHONE);
                    /* CALL_PHONE의 권한이 없을 때 */
                    // 패키지는 안드로이드 어플리케이션의 아이디다.( 어플리케이션 구분자 )
                    if (permissionResult == PackageManager.PERMISSION_DENIED) {
                        /* 사용자가 CALL_PHONE 권한을 한번이라도 거부한 적이 있는 지 조사한다.
                         * 거부한 이력이 한번이라도 있다면, true를 리턴한다.
                         */
                        if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainInfoActivity.this);
                            dialog.setTitle("권한이 필요합니다.")
                                    .setMessage("이 기능을 사용하기 위해서는 단말기의 \"전화걸기\" 권한이 필요합니다. 계속하시겠습니까?")
                                    .setPositiveButton("네", new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                                            }
                                        }
                                    }).setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(MainInfoActivity.this, "기능을 취소했습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    }).create().show();
                        }

                        //최초로 권한을 요청할 때
                        else {
                            // CALL_PHONE 권한을 Android OS 에 요청한다.
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    }
                    /* CALL_PHONE의 권한이 있을 때 */
                    else {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(tel));
                        startActivity(intent);
                    }
                }

                /* 사용자의 OS 버전이 마시멜로우 이하일 떄 */
                else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(tel));
                    startActivity(intent);
                }
            }
//            startActivity(new Intent("android.intent.action.CALL", Uri.parse(tel)));

        });

        delivery_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                intent.putExtra("image", menuImg);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(R.anim.activity_slide_in2, R.anim.activity_slide_out2);
        }
    }
}
