package com.zch.resultsent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * 用来学习onActivityResult和setResult
 */
public class MainActivity extends AppCompatActivity {
    public Button mButton;
    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.sendmsg);
        result = findViewById(R.id.result);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //注意这里是startActivityForResult
                startActivityForResult(intent,100);
            }
        });
    }

    //这个函数相应下一个Activity传回的数据，再下一个Activity点击了setResult的时候调用
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //这里是识别码，可以进行双重判断  这里的主要目的是区分消息来自哪一个Activity
        //识别码当然是自定的
        if(20 == resultCode){
            //从Activity传回的data获取需要的数据
            //带有标示
            String bookname = data.getExtras().getString("bookname");
            String booksale = data.getExtras().getString("booksale");
            result.setText("名称：" + bookname + "价钱："+booksale+"元");
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}
