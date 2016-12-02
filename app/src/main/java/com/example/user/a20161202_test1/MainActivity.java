package com.example.user.a20161202_test1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText editText;
    TextView tv2;
    Button writebutton,readbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("mydata",MODE_PRIVATE);       //SharedPreferences建立用get
        editText = (EditText) findViewById(R.id.editText);
        tv2 = (TextView) findViewById(R.id.textView2);
        writebutton = (Button) findViewById(R.id.button);
        readbutton = (Button) findViewById(R.id.button2);
        writebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",editText.getText().toString());     //寫入資料
                editor.commit();
            }
        });
        readbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = sp.getString("name", "Default");               //讀取資料
                tv2.setText(str);
            }
        });
    }
}
