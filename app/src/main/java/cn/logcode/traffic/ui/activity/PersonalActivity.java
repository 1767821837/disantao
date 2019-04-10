package cn.logcode.traffic.ui.activity;
import android.os.Bundle;
import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;

public class PersonalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        setTitle("个人中心");
        setLeft_menu(R.mipmap.back,view ->onBackPressed());
     }
}
