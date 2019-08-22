package nl.deholtmans.collapsabletoolbarondoubletap;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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

        setupGestureDetector();
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mGestureDetector.onTouchEvent(motionEvent);
                return true;

            }
        });
    }

    private void setupGestureDetector() {

        mGestureDetector = new GestureDetector(this,

                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onDoubleTap(MotionEvent e) {
                        UserFeedback.show("onDoubleTap");
                        isExpanded = !isExpanded;
                        appbar.setExpanded(isExpanded);
                        return true;
                    }

                    @Override
                    public boolean onDoubleTapEvent(MotionEvent e) {
                        UserFeedback.show("onDoubleTapEvent");
                        return true;
                    }

                    @Override
                    public boolean onDown(MotionEvent e) {
                        UserFeedback.show("onDown");
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        UserFeedback.show("onFling");
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        UserFeedback.show("onLongPress");
                    }

                    @Override
                    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                            float distanceX, float distanceY) {
                        UserFeedback.show("onScroll");
                        return true;
                    }

                    @Override
                    public void onShowPress(MotionEvent e) {
                        UserFeedback.show("onShowPress");
                    }

                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        UserFeedback.show("onSingleTapConfirmed");
                        return true;
                    }

                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        UserFeedback.show("onSingleTapUp");
                        return true;
                    }
                });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mGestureDetector != null) {
            return mGestureDetector.onTouchEvent(event);
        } else {
            return super.onTouchEvent(event);
        }

    }
}
