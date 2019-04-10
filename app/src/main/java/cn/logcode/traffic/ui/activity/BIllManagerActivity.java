package cn.logcode.traffic.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import cn.logcode.traffic.R;

import cn.logcode.traffic.base.BaseActivity;


public class BIllManagerActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_manager);
        setTitle("我的交通");
        setLeft_menu(R.mipmap.back, v -> onBackPressed());

    }
}
