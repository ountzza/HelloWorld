package com.example.pondd.helloworld;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        Log.d("width", "" + width);
        Log.d("height", "" + height);

        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        txtView = (TextView) findViewById(R.id.textResult);
        final RadioGroup rbSigned = (RadioGroup) findViewById(R.id.rgGroup);

        Button calButton = (Button) findViewById(R.id.firstButton);
        calButton.setText("Calculate");
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result1 = Integer.valueOf("0" + editText1.getText().toString());
                int result2 = Integer.valueOf("0" + editText2.getText().toString());
                int checked = rbSigned.getCheckedRadioButtonId();
                int result = result1 + result2;
                if (checked == R.id.rbPlus) {
                    txtView.setText((result1 + result2) + "");
                } else if (checked == R.id.rbMinus) {
                    txtView.setText((result1 - result2) + "");
                } else if (checked == R.id.rbMultiply) {
                    txtView.setText((result1 * result2) + "");
                } else if (checked == R.id.rbDivide) {
                    txtView.setText((result1 / result2) + "");
                }
                Intent intent = new Intent(MainActivity.this, SecoundActivity.class);
                intent.putExtra("result", result);
                startActivityForResult(intent,12345);
                //startActivity(intent);
            }
        });
        CustomViewGroup customViewGroup = (CustomViewGroup) findViewById(R.id.customViewGroup1);
        customViewGroup.setTxtName("World");


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==12345){
            // resultCode
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString("text",txtView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       // txtView.setText(savedInstanceState.getString("text"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
