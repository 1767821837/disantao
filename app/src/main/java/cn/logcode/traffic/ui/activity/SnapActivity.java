package cn.logcode.traffic.ui.activity;

import android.os.Bundle;


import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;


public class SnapActivity extends BaseActivity {

    //这里Fragment必须给初始值，否则下面做返回判断时会报空
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap);
        setTitle("我的座驾");
        setLeft_menu(R.mipmap.back,view ->onBackPressed());

    }
}
