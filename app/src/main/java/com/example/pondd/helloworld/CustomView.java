package com.example.pondd.helloworld;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Pondd on 12/24/14 AD.
 */
public class CustomView extends View {
boolean isBlue;
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

        canvas.drawLine(0 ,0 ,getMeasuredWidth(),getMeasuredHeight(),p);
    }
}
