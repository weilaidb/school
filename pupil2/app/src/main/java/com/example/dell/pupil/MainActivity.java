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
        handler_buttonzuoye();
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
            }
        });
    }

    public void handler_buttonzuoye()
    {
        Button btn_zuoye = (Button)findViewById(R.id.button_zuoye);
        btn_zuoye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    ComponentName componentName = new ComponentName(
                            "com.tencent.mobileqq",
                            "com.tencent.mobileqq.activity.SplashActivity");
                    intent.setComponent(componentName);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast toast=Toast.makeText(MainActivity.this,"手机未安装QQ",Toast.LENGTH_SHORT    );
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
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
