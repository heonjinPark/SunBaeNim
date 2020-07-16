package gaza.ssd.parkheonjin.sunbaenim;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageActivity extends AppCompatActivity {
    int menuImg;
    ImageView menuImage;
    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide(); //ActionBar 숨기기
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //상태바 가리기
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        menuImg = intent.getIntExtra("image", 0);

        menuImage = findViewById(R.id.menu_image);
        menuImage.setImageResource(menuImg);

        mAttacher = new PhotoViewAttacher(menuImage); //이미지를 축소 및 확대(오픈소스 사용)
    }
}
