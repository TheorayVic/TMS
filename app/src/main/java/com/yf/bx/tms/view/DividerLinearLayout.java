package com.yf.bx.tms.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by 洋 on 2016/11/10.
 */

public class DividerLinearLayout extends LinearLayout {
    private static final String TAG = "Linear";

    public DividerLinearLayout(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public DividerLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

    }

    public DividerLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DividerLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);

    }

    Paint mPaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (mPaint == null) {
//            mPaint = new Paint();
//            mPaint.setColor(Color.BLACK);
//        }
//        if (getOrientation() == HORIZONTAL) {
//            drawHorizontal(canvas);
//        } else {
//            drawVertical(canvas);
//        }

    }

    private void drawVertical(Canvas canvas) {

    }

    private void drawHorizontal(Canvas canvas) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Log.i(TAG, "drawHorizontal: " + child.getX() + "     " + child.getY() + "    " + getHeight() + "");
            if (i == 0) {
                canvas.drawLine(child.getX(), child.getY(), child.getX() + 5, child.getY() - getHeight()
                        , mPaint);
            } else {
                canvas.drawLine(child.getX() + child.getWidth() + 5, child.getY(), child.getX() + child
                        .getWidth(), child.getY() - getHeight(), mPaint);
            }
        }
    }
}
