package buinz.caka.gamexephinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import buinz.caka.gamexephinh.databinding.ActivityDetailPlayBinding;

public class DetailPlayActivity extends AppCompatActivity {
    private ActivityDetailPlayBinding activityDetailPlayBinding;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailPlayBinding = ActivityDetailPlayBinding.inflate(getLayoutInflater());
        View view = activityDetailPlayBinding.getRoot();
        setContentView(view);
        hideSystemUI();
        setUpData();
        activityDetailPlayBinding.option1Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPlayActivity.this, PlayActivity.class);
                intent.putExtra("option", 1);
                startActivity(intent);
            }
        });
        activityDetailPlayBinding.option2Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPlayActivity.this, PlayActivity.class);
                intent.putExtra("option", 2);
                startActivity(intent);
            }
        });
        activityDetailPlayBinding.option3Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPlayActivity.this, PlayActivity.class);
                intent.putExtra("option", 3);
                startActivity(intent);
            }
        });
    }

    private void setUpData() {
        activityDetailPlayBinding.option1Img.setImageResource(R.drawable.img_screen_44_1);
        activityDetailPlayBinding.option2Img.setImageResource(R.drawable.img_screen_44_2);
        activityDetailPlayBinding.option3Img.setImageResource(R.drawable.img_screen_44_3);
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }
}