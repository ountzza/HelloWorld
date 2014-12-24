package com.example.pondd.helloworld;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Pondd on 12/24/14 AD.
 */
public class CustomView extends View {
    private boolean isBlue;
    private boolean isDown;
    private GestureDetector mGestureDetector;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithAttrs(attrs);
    }
    private void init(){
        setWillNotDraw(false);

        mGestureDetector = new GestureDetector(getContext(),new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                if (e.getAction()==MotionEvent.ACTION_DOWN)
                    isDown = true;
                else
                    isDown = false;
                invalidate();
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                isBlue = !isBlue;
                invalidate();
                return true;
            }
        });
        // Detect Click
        setClickable(true);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // Detect LingClick
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }
    private void initWithAttrs(AttributeSet attrs){
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomViewStyleable,
                0,0);
        try {
            isBlue = a.getBoolean(R.styleable.CustomViewStyleable_isBlue,false);
        } finally {
            a.recycle();
        }
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Paint p = new Paint();
        if(isBlue)
            p.setColor(0xff0000ff);
        else
            p.setColor(0xffff0000);

        if(isDown){
            p.setStrokeWidth(3);
            p.setColor(0xffff9900);
            canvas.drawLine(0 ,0 ,getMeasuredWidth(),getMeasuredHeight(),p);
        }
        canvas.drawLine(0 ,getMeasuredHeight(),getMeasuredWidth(),0,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(mGestureDetector.onTouchEvent(event))
            return true;
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                isDown = true;
//                invalidate();
//                return true;
//            case MotionEvent.ACTION_UP:
//                isDown = false;
//                invalidate();
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                isDown = false;
//                invalidate();
//                return true;
//        }
        return super.onTouchEvent(event);
    }
}
