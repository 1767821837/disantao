package cn.logcode.traffic.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;

/**
 * 车辆违章
 */
public class PeccancyActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peccancy);
        setTitle("车辆违章");
        setLeft_menu(R.mipmap.back,view -> onBackPressed());


    }
}
