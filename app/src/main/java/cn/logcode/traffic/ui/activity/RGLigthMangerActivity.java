package cn.logcode.traffic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;

/**
 * 红绿灯管理
 */
public class RGLigthMangerActivity extends BaseActivity {

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rglmanget);
        setTitle("红绿灯管理");
        setLeft_menu(R.mipmap.back,view -> onBackPressed());

    }
}
