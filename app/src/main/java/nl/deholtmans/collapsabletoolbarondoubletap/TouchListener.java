package nl.deholtmans.collapsabletoolbarondoubletap;

public interface TouchListener  {
    void onSingleTap();
    default void onDoubleTap() {
        Logger.d( "Double tap");
    }
    default void onLongPress() {
        Logger.d( "Long press");
    }
    default void onSwipeLeft() {
        Logger.d( "Swipe left");
    }
    default void onSwipeRight() {
        Logger.d( "Swipe right");
    }
    default void onSwipeUp() {
        Logger.d( "Swipe up");
    }
    default void onSwipeDown() {
        Logger.d( "Swipe down");
    }
}
