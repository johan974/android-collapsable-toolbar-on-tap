package nl.deholtmans.collapsabletoolbarondoubletap;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity {

    private GestureDetector mGestureDetector;
    private AppBarLayout appbar;
    private Toolbar toolbar;
    private FrameLayout content_frame;
    private TextView tv;
    private boolean isExpanded = true;
    static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.setTag("ToolbarCollapseDemo");
        mainActivity = this;

        setContentView(R.layout.activity_main);

        // Setup toolbar AND a click means toggling the
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isExpanded = false;
                appbar.setExpanded(isExpanded);
            }
        });

        content_frame = (FrameLayout) findViewById(R.id.content_frame);
        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View framelayout_content = inflater.inflate(R.layout.content_main, null, false);
        content_frame.addView(framelayout_content);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnTouchListener(new OnSwipeTouchListener(this, new TouchListener() {
            @Override
            public void onSingleTap() {
                UserFeedback.show("Single tap");
            }

            @Override
            public void onDoubleTap() {
                UserFeedback.show("Double tap");
                isExpanded = !isExpanded;
                appbar.setExpanded(isExpanded);
            }

            @Override
            public void onLongPress() {
                UserFeedback.show("Long press");
            }

            @Override
            public void onSwipeLeft() {
                UserFeedback.show("Swipe left");
            }

            @Override
            public void onSwipeRight() {
                UserFeedback.show("Swipe right");
            }
        }));
    }
}
