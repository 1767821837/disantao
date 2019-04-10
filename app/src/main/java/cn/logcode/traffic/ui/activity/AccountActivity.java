package cn.logcode.traffic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;


public class AccountActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        setTitle("账户设置");
        setLeft_menu(R.mipmap.back, view -> onBackPressed());

    }
}
