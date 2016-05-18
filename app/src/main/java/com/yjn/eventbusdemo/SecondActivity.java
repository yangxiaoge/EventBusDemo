package com.yjn.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Author:0027008122 [yang.jianan@zte.com.cn]
 * Date:2016-05-18
 * Time:15:05
 * Version:1.0
 * TaskId:
 */
public class SecondActivity extends AppCompatActivity {
    Button btn_first_event;
    Button btn_second_event;
    List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        for (int i = 'A'; i < 'z'; i++) {
            list = new ArrayList();
            list.add("" + (char) i);
        }

        btn_first_event = (Button) findViewById(R.id.btn_first_event);
        btn_first_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过 FirstEventString 测试传输一个 字符串
                EventBus.getDefault().post(new FirstEventString("来自星星的你!"));
                SecondActivity.this.finish();
            }
        });

        btn_second_event = (Button) findViewById(R.id.btn_second_event);
        btn_second_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过 FirstEventList 测试传输一个 集合
                EventBus.getDefault().post(new FirstEventList(list));
                SecondActivity.this.finish();
            }
        });
    }
}
