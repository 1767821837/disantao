package cn.logcode.traffic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.logcode.traffic.R;

import cn.logcode.traffic.base.BaseActivity;


public class MainActivity extends BaseActivity {

    //侧滑我的账户
    public LinearLayout my_account;
    //红绿灯管理
    public LinearLayout rgl_manger;
    //公交查询
    public LinearLayout bus_query;

    //车辆违章
    private LinearLayout peccancy_manger;
    //监控抓拍
    private LinearLayout snap_manger;
    //个人中心
    private LinearLayout personal_center;

    //注销按钮
    private TextView zhuxiao;
    //账户管理
    private LinearLayout bill_manager;


    private GridView gv_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setYesDrawer();
        initView();
        init();
        initListener();
    }

    private void initView() {
        my_account = findViewById(R.id.my_account);
        rgl_manger = findViewById(R.id.rgl_manger);
        bus_query = findViewById(R.id.bus_query);
        peccancy_manger=findViewById(R.id.peccancy_manger);
        snap_manger=findViewById(R.id.snap_manger);
        personal_center=findViewById(R.id.personal_center);

        zhuxiao = findViewById(R.id.tv_zhuxiao);
        gv_main = findViewById(R.id.gv_main);
        bill_manager=findViewById(R.id.bill_manager);
    }

    private void init() {
        setTitle("首页-环境指标",null);
        zhuxiao.setVisibility(View.VISIBLE);
    }
    public void initListener(){
        //账户设置
        my_account.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AccountActivity.class));
            drawerLayout.closeDrawers();
        });
        //红绿灯管理
        rgl_manger.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, RGLigthMangerActivity.class));
            drawerLayout.closeDrawers();
        });
        //路况查询
        bus_query.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, BusqueryActivity.class));
            drawerLayout.closeDrawers();
        });             

        //车辆违章
        peccancy_manger.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this,PeccancyActivity.class));
            drawerLayout.closeDrawers();
        });

        //我的座驾
        snap_manger.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this,SnapActivity.class));
            drawerLayout.closeDrawers();
        });
        //个人中心
        personal_center.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this,PersonalActivity.class));
            drawerLayout.closeDrawers();
        });

        //注销登录
        zhuxiao.setOnClickListener(v -> {
            Intent intent =new Intent(MainActivity.this,LoginActivity.class);
            intent.putExtra("autologin",false);
            startActivity(intent);
            finish();
        });
        //我的交通
        bill_manager.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,BIllManagerActivity.class));
            drawerLayout.closeDrawers();
        });
    }

    /**
     * 双击退出
     */
    private long isExitTime=0;
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawers();
        }else {
            if(System.currentTimeMillis() -isExitTime > 2000){
                Toast.makeText(MainActivity.this,"再次点击退出",Toast.LENGTH_SHORT).show();
                isExitTime=System.currentTimeMillis();
            }else {
                finish();
                System.exit(0);
            }
        }
        
    }
}
