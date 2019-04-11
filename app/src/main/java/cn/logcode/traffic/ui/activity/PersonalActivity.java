package cn.logcode.traffic.ui.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;
import cn.logcode.traffic.bean.GeRenZhongXinBean;
import cn.logcode.traffic.utils.okhttp.Myok;
import cn.logcode.traffic.utils.okhttp.MyokHttp;

public class PersonalActivity extends BaseActivity {

    private TextView mGenrenName;
    private TextView mXingbie;
    private TextView mPhone;
    private TextView mSfz;
    private TextView mZusj;
    private TextView mTvPlate1;
    private TextView mTvPlate2;
    private TextView mTvPlate3;
    private TextView mTvPlate4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_personal );
        setTitle( "个人中心" );
        setLeft_menu( R.mipmap.back, view -> onBackPressed() );
        initViews();
        OKHttp();
    }

    private void OKHttp() {
        MyokHttp.Post( "https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/geren", "",
                new Myok() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void Success(String json) {
                        AlertDialog dialog = new ProgressDialog.Builder( PersonalActivity.this )
                                .setTitle( "正在加载中..." )
                                .show();
                        Gson gson = new Gson();
                        try {
                            GeRenZhongXinBean bean = gson.fromJson( json, GeRenZhongXinBean.class );
                            mGenrenName.setText( "姓名：" + bean.getData().getName() );
                            mXingbie.setText( "性别：" + bean.getData().getSex() );
                            mPhone.setText( "电话号码：" + bean.getData().getPhone() );
                            mSfz.setText( "身份证号：" + bean.getData().getIdcard() );
                            mZusj.setText( "注册时间：" + bean.getData().getCreatetime() );
                            mTvPlate1.setText( bean.getData().getCar().get( 0 ).getChepai() + "      余额：100" );
                            mTvPlate2.setText( bean.getData().getCar().get( 1 ).getChepai() + "      余额：100" );
                            mTvPlate3.setText( bean.getData().getCar().get( 2 ).getChepai() + "      余额：100" );
                            mTvPlate4.setText( bean.getData().getCar().get( 3 ).getChepai() + "      余额：100" );
                            dialog.dismiss();
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                            dialog.dismiss();
                        }
                    }

                    @Override
                    public void Fial(String e) {

                    }
                } );
    }

    private void initViews() {
        mGenrenName = (TextView) findViewById( R.id.genren_name );
        mXingbie = (TextView) findViewById( R.id.xingbie );
        mPhone = (TextView) findViewById( R.id.phone );
        mSfz = (TextView) findViewById( R.id.sfz );
        mZusj = (TextView) findViewById( R.id.zusj );
        mTvPlate1 = (TextView) findViewById( R.id.tv_plate1 );
        mTvPlate2 = (TextView) findViewById( R.id.tv_plate2 );
        mTvPlate3 = (TextView) findViewById( R.id.tv_plate3 );
        mTvPlate4 = (TextView) findViewById( R.id.tv_plate4 );
    }
}
