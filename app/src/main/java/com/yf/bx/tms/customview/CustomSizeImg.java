package com.yf.bx.tms.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

//不规则图片点击效果
public class CustomSizeImg extends FrameLayout {

    private int width = -1;
    private int height = -1;
    private Bitmap bitmap;

    public CustomSizeImg(Context context) {
        super( context);
    }

    public CustomSizeImg(Context context, AttributeSet attrs, int defStyle) {
        super( context, attrs, defStyle);
    }

    public CustomSizeImg(Context context, AttributeSet attrs) {
        super( context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action != MotionEvent.ACTION_DOWN) {
            return super.onTouchEvent( event);
        }
        int x = (int)event.getX();
        int y = (int)event.getY();
        if(width == -1 || height == -1) {
            Drawable drawable = getBackground().getCurrent();
            bitmap = ((BitmapDrawable)drawable).getBitmap();
            width = bitmap.getWidth();
            height = bitmap.getHeight();
        }
        if(null == bitmap || x < 0 || y < 0 || x >= width || y >= height) {
            return false;
        }
        if ((x<width)&&(y<height)){
            int pixel = bitmap.getPixel(x, y);
            if(Color.TRANSPARENT == pixel) {
            return false;
        }
        }
        return super.onTouchEvent(event);
    }
}
