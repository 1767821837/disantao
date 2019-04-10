package cn.logcode.traffic.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import cn.logcode.traffic.R;

import cn.logcode.traffic.base.BaseActivity;

/**
 * 查询结果页面
 */
public class QueryResultActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_result);
        setTitle("查询结果");
        setLeft_menu(R.mipmap.back, view -> onBackPressed());

    }

}
