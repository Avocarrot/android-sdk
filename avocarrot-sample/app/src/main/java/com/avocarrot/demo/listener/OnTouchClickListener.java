package com.avocarrot.demo.listener;

import android.view.MotionEvent;
import android.view.View;

public abstract class OnTouchClickListener implements View.OnTouchListener {
    private static final int RELEASED = 0;
    private static final int TOUCHED = 1;
    private static final int DRAGGING = 2;
    private static final int UNDEFINED = 3;
    private int fingerState;
    private float downX;
    private float downY;

    @Override
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = motionEvent.getX();
                downY = motionEvent.getY();
                fingerState = fingerState == RELEASED ? TOUCHED : UNDEFINED;
                break;
            case MotionEvent.ACTION_UP:
                if (fingerState != DRAGGING) {
                    fingerState = RELEASED;
                    onClick(view, motionEvent);
                } else {
                    fingerState = RELEASED;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                final float deltaX = motionEvent.getX() - downX;
                final float deltaY = motionEvent.getY() - downY;
                if (Math.sqrt(deltaX * (deltaX) + (deltaY) * (deltaY)) < 5f) {
                    break;
                }
                if (fingerState == TOUCHED || fingerState == DRAGGING) {
                    fingerState = DRAGGING;
                } else {
                    fingerState = UNDEFINED;
                }
                break;
            default:
                fingerState = UNDEFINED;
        }
        return false;
    }

    public abstract void onClick(View view, MotionEvent motionEvent);
}
