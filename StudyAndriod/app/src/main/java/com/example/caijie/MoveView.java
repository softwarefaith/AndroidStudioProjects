package com.example.caijie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by caijie on 16/3/23.
 */
public class MoveView extends View{

    private float currentX = 40;
    private float currentY = 50;

    Paint paint = new Paint();

    public void setCurrentX(float currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(float currentY) {
        this.currentY = currentY;
    }

    public MoveView(Context context) {
        super(context);
    }

    public MoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       // return super.onTouchEvent(event);

        currentX = event.getX();
        currentY = event.getY();
        //通知当前组件重绘自己
        invalidate();

        return true;

    }
}
