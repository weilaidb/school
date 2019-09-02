package com.example.dell.pupil
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View  //记得导入所需文件
import android.widget.Toast //记得导入所需文件


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        button2.setOnClickListener(this)

    }

    fun onClick(v: View?) {
//        textView.setText("超级酷")           //这是一个点击按钮后执行的代码，点击按钮这个操作之后，textview的文字被设置为超级酷
        showToast("测试成功")

    }

    fun  showToast(str:String) //       写一个方法显示测试成功，浮现于程序表面，数秒之后消失
    {
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    private fun Button.setOnClickListener(mainActivity: MainActivity) {
        showToast("测试成功 +OK")
//        val intent = Intent()
//        //获取intent对象
//        intent.setClass(this,Main2Activity::class.java)
//        // 获取class是使用::反射
//        startActivity(intent)
    }
}

