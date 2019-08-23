package nl.deholtmans.collapsabletoolbarondoubletap;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    public OnSwipeTouchListener(Context ctx, TouchListener touchListener) {
        gestureDetector = new GestureDetector(ctx, new GestureListener(touchListener));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 300;
        private static final int SWIPE_VELOCITY_THRESHOLD = 300;
        private TouchListener touchListener;

        GestureListener(TouchListener touchListener) {
            super();
            this.touchListener = touchListener;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.i("TAG", "onSingleTapConfirmed:");
            //Toast.makeText(context, "Single Tap Detected", Toast.LENGTH_SHORT).show();
            touchListener.onSingleTap();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.i("TAG", "onLongPress:");
            //Toast.makeText(context, "Long Press Detected", Toast.LENGTH_SHORT).show();
            touchListener.onLongPress();
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            //Toast.makeText(context, "Double Tap Detected", Toast.LENGTH_SHORT).show();
            touchListener.onDoubleTap();
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            touchListener.onSwipeRight();
                        } else {
                            touchListener.onSwipeLeft();
                        }
                        result = true;
                    }
                } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        touchListener.onSwipeDown();
                    } else {
                        touchListener.onSwipeUp();
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }
}
