package com.yjn.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 注册EventBus
        EventBus.getDefault().register(this);

        btn = (Button) findViewById(R.id.btn_try);
        textView = (TextView) findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    // 方法名随意取, 要加行注解 Subscribe
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onEventString(FirstEventString firstEvent) {
        String msg = firstEvent.getStr();
        textView.setText(msg);
        Toast.makeText(this, "收到String: " + msg, Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onEventList(FirstEventList firstEventList) {
        List list = firstEventList.getList();
        textView.setText("list长度:" + list.size());
        Toast.makeText(this, "list长度:" + list.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 反注册EventBus
        EventBus.getDefault().unregister(this);
    }

}
