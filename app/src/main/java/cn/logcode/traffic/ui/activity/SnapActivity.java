package cn.logcode.traffic.ui.activity;

import android.os.Bundle;


import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;


public class SnapActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap);
        setTitle("我的座驾");
        setLeft_menu(R.mipmap.back,view ->onBackPressed());

    }
}
