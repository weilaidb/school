package com.example.dell.pupil;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        buttonset();
    }


    public void buttonset() {
        handler_buttonbishun();
        handler_buttongushi();
        handler_button_pub_url(R.id.button_shouchaobao, "https://www.banbaowang.com/shouchaobao/");

        handler_button_pub(R.id.button_zuoye, "com.tencent.mobileqq",
                 "com.tencent.mobileqq.activity.SplashActivity",
                "手机未安装QQ");
        handler_button_pub(R.id.button_eveningstory, "com.ximalaya.ting.android",
                "com.ximalaya.ting.android.host.activity.MainActivity",
                "手机未安装喜马拉雅");
        handler_button_pub(R.id.button_record, "com.miui.notes",
                "com.miui.notes.ui.NotesListActivity",
                "手机未安装记事本");
        handler_button_pub(R.id.button_photo_homework, "com.android.camera",
                "com.android.camera.Camera",
                "手机未安装相机");
        handler_button_pub(R.id.button_yongzhong, "com.wiseman.writing",
                "com.wiseman.writing.activity.SplashAdActivity",
                "手机未安装相机");
        handler_button_pub(R.id.button_findthings, "cn.wps.moffice_eng",
                "cn.wps.moffice.documentmanager.PreStartActivity",
                "手机未安装WPS");

    }

    public void handler_buttonbishun() {
        handler_button_pub_url(R.id.button_bishun, getResources().getString(R.string.text_bishun));
    }

    public void handler_buttongushi() {
        handler_button_pub_url(R.id.button_gushi, getResources().getString(R.string.text_gushi));
    }

    public void handler_button_pub_url(int id, final String surl) {
        Button btn = (Button) findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String texttmp = (String) surl;
                    Uri uri = Uri.parse(texttmp);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
//                MainActivity.this.startActivityForResult(intent, 0x11);
                } catch (Exception e) {
                    Toast toast = Toast.makeText(MainActivity.this, "打开网址失败" + surl, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
    }


    public void handler_button_pub(int id, final String pkgname, final String activityname, final String errortip) {
        Button btn = (Button) findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pubIntentJump(pkgname,
                        activityname,
                        errortip
                );
            }
        });
    }


    public void pubIntentJump(String pkgname, String activyname, String iferrtips) {
        try {
            ComponentName componentName = new ComponentName(
                    pkgname,
                    activyname);
            Intent intent = new Intent(Intent.ACTION_QUICK_VIEW);
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(componentName);
            startActivity(intent);
//                    startActivityForResult(intent,0x33);
        } catch (Exception e) {
            Toast toast = Toast.makeText(MainActivity.this, iferrtips, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 0x11) {
        Toast.makeText(this, "我回来了", Toast.LENGTH_SHORT).show();
//        }
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
