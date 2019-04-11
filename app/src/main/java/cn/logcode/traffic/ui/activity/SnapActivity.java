package cn.logcode.traffic.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cn.logcode.traffic.R;
import cn.logcode.traffic.adapter.ViewpaterAdapter;
import cn.logcode.traffic.base.BaseActivity;
import cn.logcode.traffic.ui.fragment.MyzuojiaFragment;


public class SnapActivity extends BaseActivity {


    private ViewPager viewpager;
    private LinearLayout bottom;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap);
        initView();
        setTitle("我的座驾");
        setLeft_menu(R.mipmap.back, view -> onBackPressed());
        initdata();
    }

    private void initdata() {
        fragments = new ArrayList<>();
        fragments.add(new MyzuojiaFragment());
        ViewpaterAdapter adapter = new ViewpaterAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        bottom = (LinearLayout) findViewById(R.id.bottom);
    }
}
