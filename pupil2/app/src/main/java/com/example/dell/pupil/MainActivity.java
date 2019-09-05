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



    public void buttonset()
    {
        handler_buttonbishun();
        handler_buttongushi();
//        handler_buttonzuoye();
        handler_buttonzuoyeext();
        handler_button_eveningtory();
        handler_button_recorderror();
    }

    public void handler_buttonbishun()
    {
        Button btn_bishun = (Button)findViewById(R.id.button_bishun);
        btn_bishun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texttmp = (String)getResources().getString(R.string.text_bishun);
                Uri uri = Uri.parse(texttmp);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    public void handler_buttongushi()
    {
        Button btn_gushi = (Button)findViewById(R.id.button_gushi);
        btn_gushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texttmp = (String)getResources().getString(R.string.text_gushi);
                Uri uri = Uri.parse(texttmp);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
//                MainActivity.this.startActivityForResult(intent, 0x11);
            }
        });
    }

    public void handler_buttonzuoye()
    {
        Button btn_zuoye = (Button)findViewById(R.id.button_zuoye);
        btn_zuoye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ComponentName comp=new ComponentName(MainActivity.this,SecondActivity.class);
                ComponentName comp=new ComponentName("com.example.dell.pupil",
                        "com.example.dell.pupil.SecondActivity");
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
                MainActivity.this.startActivityForResult(intent,0x22);
            }
        });
    }



    public void handler_buttonzuoyeext()
    {
        Button btn_zuoye = (Button)findViewById(R.id.button_zuoye);
        btn_zuoye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pubIntentJump("com.tencent.mobileqq",
                        "com.tencent.mobileqq.activity.SplashActivity",
                        "手机未安装QQ"
                );
            }
        });
    }

    public void handler_button_eveningtory()
    {
        Button btn_story = (Button)findViewById(R.id.button_eveningstory);
        btn_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pubIntentJump("com.ximalaya.ting.android",
                        "com.ximalaya.ting.android.host.activity.MainActivity",
                        "手机未安装喜马拉雅"
                );
            }
        });
    }

    public void handler_button_recorderror()
    {
        Button btn_record = (Button)findViewById(R.id.button_record);
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pubIntentJump("com.miui.notes",
                        "com.miui.notes.ui.NotesListActivity",
                        "手机未记事本"
                );
            }
        });
    }


    public  void pubIntentJump(String pkgname, String activyname, String iferrtips)
    {
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
            Toast toast=Toast.makeText(MainActivity.this,iferrtips,Toast.LENGTH_SHORT    );
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
