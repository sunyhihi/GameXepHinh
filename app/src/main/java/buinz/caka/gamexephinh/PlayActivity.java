package buinz.caka.gamexephinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import buinz.caka.gamexephinh.database.DBHelper;
import buinz.caka.gamexephinh.databinding.ActivityPlayBinding;

public class PlayActivity extends AppCompatActivity {
    private ActivityPlayBinding activityPlayBinding;
    private ImageView[][] gridImageViews = new ImageView[4][4];
    private int[][] imageIds = new int[4][4];
    private int emptyCellX = -1;
    private int emptyCellY = -1;
    int childCount;
    private ImageView selectedImageView1 = null;
    private ImageView selectedImageView2 = null;
    private ArrayList<Integer> imageList;
    private ArrayList<Integer> imageListCopy;

    private int selectedX1 = -1;
    private int selectedY1 = -1;
    private int selectedX2 = -1;
    private int selectedY2 = -1;
    private static final int EMPTY_IMAGE_ID = R.drawable.img_44_1_item_44;
    private int countMoves = 0;
    private int seconds = 0;
    private boolean running = true;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private int type;
    private int option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPlayBinding = ActivityPlayBinding.inflate(getLayoutInflater());
        View view = activityPlayBinding.getRoot();
        setContentView(view);
        hideSystemUI();
        setUpImage();
        activityPlayBinding.restartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });
    }

    private void setUpImage() {
        Intent intent = getIntent();
        option = intent.getIntExtra("option", 0);
        imageList = new ArrayList<>();
        imageListCopy = new ArrayList<>();
        if (option == 1) {
            imageList.add(R.drawable.img_44_1_item_11);
            imageList.add(R.drawable.img_44_1_item_12);
            imageList.add(R.drawable.img_44_1_item_13);
            imageList.add(R.drawable.img_44_1_item_14);
            imageList.add(R.drawable.img_44_1_item_21);
            imageList.add(R.drawable.img_44_1_item_22);
            imageList.add(R.drawable.img_44_1_item_23);
            imageList.add(R.drawable.img_44_1_item_24);
            imageList.add(R.drawable.img_44_1_item_31);
            imageList.add(R.drawable.img_44_1_item_32);
            imageList.add(R.drawable.img_44_1_item_33);
            imageList.add(R.drawable.img_44_1_item_34);
            imageList.add(R.drawable.img_44_1_item_41);
            imageList.add(R.drawable.img_44_1_item_42);
            imageList.add(R.drawable.img_44_1_item_43);
            imageList.add(R.drawable.img_44_1_item_44);
            Collections.shuffle(imageList);

            imageListCopy.add(R.drawable.img_44_1_item_11);
            imageListCopy.add(R.drawable.img_44_1_item_12);
            imageListCopy.add(R.drawable.img_44_1_item_13);
            imageListCopy.add(R.drawable.img_44_1_item_14);
            imageListCopy.add(R.drawable.img_44_1_item_21);
            imageListCopy.add(R.drawable.img_44_1_item_22);
            imageListCopy.add(R.drawable.img_44_1_item_23);
            imageListCopy.add(R.drawable.img_44_1_item_24);
            imageListCopy.add(R.drawable.img_44_1_item_31);
            imageListCopy.add(R.drawable.img_44_1_item_32);
            imageListCopy.add(R.drawable.img_44_1_item_33);
            imageListCopy.add(R.drawable.img_44_1_item_34);
            imageListCopy.add(R.drawable.img_44_1_item_41);
            imageListCopy.add(R.drawable.img_44_1_item_42);
            imageListCopy.add(R.drawable.img_44_1_item_43);
            imageListCopy.add(R.drawable.img_44_1_item_44);
        } else if (type == 44 && option == 2) {
            imageList.add(R.drawable.img_44_2_item_11);
            imageList.add(R.drawable.img_44_2_item_12);
            imageList.add(R.drawable.img_44_2_item_13);
            imageList.add(R.drawable.img_44_2_item_14);
            imageList.add(R.drawable.img_44_2_item_21);
            imageList.add(R.drawable.img_44_2_item_22);
            imageList.add(R.drawable.img_44_2_item_23);
            imageList.add(R.drawable.img_44_2_item_24);
            imageList.add(R.drawable.img_44_2_item_31);
            imageList.add(R.drawable.img_44_2_item_32);
            imageList.add(R.drawable.img_44_2_item_33);
            imageList.add(R.drawable.img_44_2_item_34);
            imageList.add(R.drawable.img_44_2_item_41);
            imageList.add(R.drawable.img_44_2_item_42);
            imageList.add(R.drawable.img_44_2_item_43);
            imageList.add(R.drawable.img_44_1_item_44);
            Collections.shuffle(imageList);

            imageListCopy.add(R.drawable.img_44_2_item_11);
            imageListCopy.add(R.drawable.img_44_2_item_12);
            imageListCopy.add(R.drawable.img_44_2_item_13);
            imageListCopy.add(R.drawable.img_44_2_item_14);
            imageListCopy.add(R.drawable.img_44_2_item_21);
            imageListCopy.add(R.drawable.img_44_2_item_22);
            imageListCopy.add(R.drawable.img_44_2_item_23);
            imageListCopy.add(R.drawable.img_44_2_item_24);
            imageList.add(R.drawable.img_44_2_item_31);
            imageList.add(R.drawable.img_44_2_item_32);
            imageList.add(R.drawable.img_44_2_item_33);
            imageList.add(R.drawable.img_44_2_item_34);
            imageList.add(R.drawable.img_44_2_item_41);
            imageList.add(R.drawable.img_44_2_item_42);
            imageList.add(R.drawable.img_44_2_item_43);
            imageList.add(R.drawable.img_44_1_item_44);
            //if (type == 44 && option == 3)
        } else {
            imageList.add(R.drawable.img_44_3_item_11);
            imageList.add(R.drawable.img_44_3_item_12);
            imageList.add(R.drawable.img_44_3_item_13);
            imageList.add(R.drawable.img_44_3_item_14);
            imageList.add(R.drawable.img_44_3_item_21);
            imageList.add(R.drawable.img_44_3_item_22);
            imageList.add(R.drawable.img_44_3_item_23);
            imageList.add(R.drawable.img_44_3_item_24);
            imageList.add(R.drawable.img_44_3_item_31);
            imageList.add(R.drawable.img_44_3_item_32);
            imageList.add(R.drawable.img_44_3_item_33);
            imageList.add(R.drawable.img_44_3_item_34);
            imageList.add(R.drawable.img_44_3_item_41);
            imageList.add(R.drawable.img_44_3_item_42);
            imageList.add(R.drawable.img_44_3_item_43);
            imageList.add(R.drawable.img_44_1_item_44);
            Collections.shuffle(imageList);

            imageListCopy.add(R.drawable.img_44_3_item_11);
            imageListCopy.add(R.drawable.img_44_3_item_12);
            imageListCopy.add(R.drawable.img_44_3_item_13);
            imageListCopy.add(R.drawable.img_44_3_item_14);
            imageListCopy.add(R.drawable.img_44_3_item_21);
            imageListCopy.add(R.drawable.img_44_3_item_22);
            imageListCopy.add(R.drawable.img_44_3_item_23);
            imageListCopy.add(R.drawable.img_44_3_item_24);
            imageListCopy.add(R.drawable.img_44_3_item_31);
            imageListCopy.add(R.drawable.img_44_3_item_32);
            imageListCopy.add(R.drawable.img_44_3_item_33);
            imageListCopy.add(R.drawable.img_44_3_item_34);
            imageListCopy.add(R.drawable.img_44_3_item_41);
            imageListCopy.add(R.drawable.img_44_3_item_42);
            imageListCopy.add(R.drawable.img_44_3_item_43);
            imageListCopy.add(R.drawable.img_44_1_item_44);
        }
        int childCount = activityPlayBinding.gridLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView child = (ImageView) activityPlayBinding.gridLayout.getChildAt(i);
            if (i < imageList.size()) { // Đảm bảo không vượt quá kích thước của imageList
                child.setImageResource(imageList.get(i));
            }
        }
        setUp();
    }
    private void setUp() {
        activityPlayBinding.tilesTv.setText("15 Tiles");
        int row = 4;
        int col = 4;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int childIndex = i * col + j;
                ImageView child = (ImageView) activityPlayBinding.gridLayout.getChildAt(childIndex);
                if (child != null) {
                    imageIds[i][j] = imageList.get(childIndex);
                    int finalI = i;
                    int finalJ = j;
                    child.setOnClickListener(v -> handleImageClick(finalI, finalJ, child));
                }
            }
        }
    }
    private void handleImageClick(int x, int y, ImageView clickedView) {
        if (selectedImageView1 == null) {
            selectedImageView1 = clickedView;
            selectedX1 = x;
            selectedY1 = y;
            selectedImageView1.setBackgroundColor(Color.LTGRAY);
        } else if (selectedImageView1 != clickedView && selectedImageView2 == null) {
            selectedImageView2 = clickedView;
            selectedX2 = x;
            selectedY2 = y;

            // Kiểm tra xem hai ô có nằm cạnh nhau và ít nhất một ô có hình ảnh trống không
            //areAdjacent(selectedX1, selectedY1, selectedX2, selectedY2) &&
            if (areAdjacent(selectedX1, selectedY1, selectedX2, selectedY2) &&
                    (isEmptyImage(selectedImageView1) || isEmptyImage(selectedImageView2))) {

                Drawable tempDrawable = selectedImageView1.getDrawable();
                selectedImageView1.setImageDrawable(selectedImageView2.getDrawable());
                selectedImageView2.setImageDrawable(tempDrawable);
                selectedImageView1.setBackgroundColor(Color.TRANSPARENT);
                Collections.swap(imageList, x * 4 + y, selectedX1 * 4 + selectedY1);
                resetSelection();
                countMoves++;
                activityPlayBinding.movesTv.setText(countMoves + " Moves");
                if (imageListCopy.equals(imageList)) {
                    Toast.makeText(this, "Bạn đã chiến thắng!", Toast.LENGTH_SHORT).show();
                    DBHelper db = new DBHelper(this);
                    String timeValue = activityPlayBinding.timeTv.getText().toString();
                    String movesValue = activityPlayBinding.movesTv.getText().toString();
                    db.addGame(type + "", timeValue, movesValue);
                    // Thực hiện tiếp tục các công việc lưu dữ liệu vào SQLite
                    Intent intent = new Intent(PlayActivity.this, DetailPlayActivity.class);
                    startActivity(intent);
                    finish();
                }
            } else {
                selectedImageView1.setBackgroundColor(Color.TRANSPARENT);
                resetSelection();
            }
        }
    }
    private boolean isEmptyImage(ImageView imageView) {
        Drawable currentDrawable = imageView.getDrawable();
        Drawable emptyDrawable = getResources().getDrawable(EMPTY_IMAGE_ID, null);
        return currentDrawable.getConstantState() == emptyDrawable.getConstantState();
    }

    private boolean areAdjacent(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1 - x2) == 1 && y1 == y2) || (Math.abs(y1 - y2) == 1 && x1 == x2);
    }

    private void resetSelection() {
        selectedImageView1 = null;
        selectedImageView2 = null;
        selectedX1 = -1;
        selectedY1 = -1;
        selectedX2 = -1;
        selectedY2 = -1;
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }


    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
        running = true;
        updateTextView();
    }

    private void updateTextView() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String time = String.format("%02d:%02d:%02d", hours, minutes, secs);

        activityPlayBinding.timeTv.setText(time);

        if (running) {
            seconds++;
        }

        handler.postDelayed(this::updateTextView, 1000);
    }
}