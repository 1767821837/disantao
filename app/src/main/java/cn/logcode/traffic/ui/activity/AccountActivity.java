package cn.logcode.traffic.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;


public class AccountActivity extends BaseActivity {

    private TextView mYueMoney;
    private EditText mEdMoney;
    private Button mSetting;
    private SharedPreferences sharedPreferences;


    @SuppressLint({"WrongConstant", "SetTextI18n"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        setTitle("账户设置");
        setLeft_menu(R.mipmap.back, view -> onBackPressed());
        initViews();
        sharedPreferences = getSharedPreferences( "Yu_Zhi",Activity.MODE_APPEND );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String yuzhi = sharedPreferences.getString( "yuzhi",null );
        if (!TextUtils.isEmpty( yuzhi )){
            mYueMoney.setText( yuzhi+"元" );
        }else {
            editor.putString( "yuzhi","50" );
            mYueMoney.setText( "50元" );
            editor.commit();
        }

        mSetting.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String money = mEdMoney.getText().toString();
                if(!TextUtils.isEmpty( money )){
                    editor.putString( "yuzhi",money);
                    mYueMoney.setText( money+"元" );
                    editor.commit();
                    Toast.makeText( AccountActivity.this,"设置成功",Toast.LENGTH_SHORT ).show();
                }else {
                    Toast.makeText( AccountActivity.this,"请输入设置金额！",Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }

    private void initViews() {
        mYueMoney = (TextView) findViewById(R.id.yue_money);
        mEdMoney = (EditText) findViewById(R.id.ed_money);
        mSetting = (Button) findViewById(R.id.setting);
    }
}
