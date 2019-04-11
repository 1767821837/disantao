package cn.logcode.traffic.ui.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;
import cn.logcode.traffic.bean.HoLvDengBean;
import cn.logcode.traffic.bean.ZhangHuSheZhiBean;
import cn.logcode.traffic.utils.okhttp.Myok;
import cn.logcode.traffic.utils.okhttp.MyokHttp;


// 路况查询
public class BusqueryActivity extends BaseActivity {

    private TextView mPm;
    private TextView mWendu;
    private TextView mShidu;
    private TextView mOne;
    private TextView mTwo;
    private TextView mThree;
    private LinearLayout mOneColor;
    private LinearLayout mTwoColor;
    private LinearLayout mThreeColor;
    private String[] daolu = {"通畅", "较通畅", "拥挤", "堵塞", "爆表"};
    private String[] color = {"#0ebd12", "#98ed1f", "#ffff01", "#ff0103", "#4c060e"};
    private Handler mHandler = new Handler();
    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed( this, 3000 );
            OKHttp();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_busquery );
        initViews();
        OKHttp();
    }


    @Override
    protected void onStart() {
        mHandler.postDelayed( mRunnable, 3000 );
        super.onStart();
    }

    @Override
    protected void onStop() {
        mHandler.removeCallbacks( mRunnable );
        super.onStop();
    }

    private void OKHttp() {
        MyokHttp.Post( "https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/lukuangxinxi", "",
                new Myok() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void Success(String json) {
                        AlertDialog dialog = new ProgressDialog.Builder( BusqueryActivity.this )
                                .setTitle( "正在加载中..." )
                                .show();
                        Gson gson = new Gson();
                        try {
                            ZhangHuSheZhiBean bean = gson.fromJson( json, ZhangHuSheZhiBean.class );
                            mPm.setText( "PM2.5：" + bean.getData().getPm() );
                            mWendu.setText( "温度：" + bean.getData().getWendu() + "℃" );
                            mShidu.setText( "湿度：" + bean.getData().getShidu() + "%RH" );

                            int one = bean.getData().getLukuang().get( 0 ).getState();
                            int two = bean.getData().getLukuang().get( 1 ).getState();
                            int three = bean.getData().getLukuang().get( 2 ).getState();
                            for (int i = 0; i < 5; i++) {
                                if (one == i) {
                                    mOne.setText( "1号道路：" + daolu[i] );
                                    mOneColor.setBackgroundColor( Color.parseColor( color[i] ) );
                                }
                                if (two == i) {
                                    mTwo.setText( "2号道路：" + daolu[i] );
                                    mTwoColor.setBackgroundColor( Color.parseColor( color[i] ) );
                                }
                                if (three == i) {
                                    mThree.setText( "3号道路：" + daolu[i] );
                                    mThreeColor.setBackgroundColor( Color.parseColor( color[i] ) );
                                }
                            }
                            dialog.dismiss();
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                            dialog.dismiss();
                            Toast.makeText( BusqueryActivity.this, "加载失败！！！", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    @Override
                    public void Fial(String e) {

                    }
                } );
    }

    private void initViews() {
        mPm = (TextView) findViewById( R.id.pm );
        mWendu = (TextView) findViewById( R.id.wendu );
        mShidu = (TextView) findViewById( R.id.shidu );
        mOne = (TextView) findViewById( R.id.one );
        mTwo = (TextView) findViewById( R.id.two );
        mThree = (TextView) findViewById( R.id.three );
        mOneColor = (LinearLayout) findViewById( R.id.one_color );
        mTwoColor = (LinearLayout) findViewById( R.id.two_color );
        mThreeColor = (LinearLayout) findViewById( R.id.three_color );
    }
}
