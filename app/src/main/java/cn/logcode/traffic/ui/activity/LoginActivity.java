package cn.logcode.traffic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;
import cn.logcode.traffic.bean.song.user;
import cn.logcode.traffic.utils.okhttp.Myok;
import cn.logcode.traffic.utils.okhttp.song.Myhttp;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private EditText et_name;
    private EditText et_pass;
    private TextView tv_regist;
    private TextView tv_find;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        hideLeftMenu();

    }


    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);
        tv_regist = (TextView) findViewById(R.id.tv_regist);
        tv_find = (TextView) findViewById(R.id.tv_find);
        login = (Button) findViewById(R.id.login);


        tv_regist.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                submit();
                break;
            case R.id.tv_regist:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    private void submit() {
        String name = et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String pass = et_pass.getText().toString().trim();
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        user user = new user();
        user.username = name;
        user.password = pass;
        Myhttp.login(new Gson().toJson(user), new Myok() {
            @Override
            public void Success(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject data = jsonObject.getJSONObject("data");
                    String username = data.getString("username");
                    if ("张三".equals(username)) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else
                        Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void Fial(String e) {

            }
        });

    }
}

