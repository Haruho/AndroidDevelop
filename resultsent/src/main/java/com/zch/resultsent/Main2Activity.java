package com.zch.resultsent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    public EditText bookname;
    public EditText booksale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bookname = findViewById(R.id.name);
        booksale = findViewById(R.id.sale);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入文本的text
                String bname = bookname.getText().toString();
                String bsale = booksale.getText().toString();
                //创建传回主界面的intent  数据会包含在这个intent中
                Intent data = new Intent();
                //向intent中放入数据  带上标识
                data.putExtra("bookname",bname);
                data.putExtra("booksale",bsale);
                //第一个参数是识别码  第二个是数据
                setResult(20,data);
                //结束这个界面
                finish();
            }
        });
    }
}
