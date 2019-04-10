package cn.logcode.traffic.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;


public class RegisterActivity extends BaseActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        hideLeftMenu();
        showDesc();
        setTitle("注册", null);


    }


}
