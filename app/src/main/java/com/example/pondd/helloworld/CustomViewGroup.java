package com.example.pondd.helloworld;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Pondd on 12/24/14 AD.
 */
public class CustomViewGroup extends FrameLayout {
    private TextView txtName;

    public CustomViewGroup(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs);
    }

    private void initInflate(){
        LayoutInflater inflater = (LayoutInflater)getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_sample, this);
    }
    private void initInstances(){
        txtName = (TextView) findViewById(R.id.txtView);
    }
    private void initWithAttrs(AttributeSet attrs){

    }

    public void setTxtName(String text){
        txtName.setText(text);
    }
}
