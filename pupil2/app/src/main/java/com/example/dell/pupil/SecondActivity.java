package com.example.dell.pupil;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//
//        Toast toast=Toast.makeText(SecondActivity.this,"Second Activity",Toast.LENGTH_SHORT    );
//        toast.show();
        try {
            ComponentName componentName = new ComponentName(
                    "com.tencent.mobileqq",
                    "com.tencent.mobileqq.activity.SplashActivity");
            Intent intent = new Intent(Intent.ACTION_QUICK_VIEW);
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(componentName);
            startActivityForResult(intent,0x33);
        } catch (Exception e) {
            Toast toast=Toast.makeText(SecondActivity.this,"手机未安装QQ",Toast.LENGTH_SHORT    );
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
}
