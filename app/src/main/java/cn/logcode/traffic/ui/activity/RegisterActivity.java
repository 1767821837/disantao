package cn.logcode.traffic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import cn.logcode.traffic.R;
import cn.logcode.traffic.base.BaseActivity;
import cn.logcode.traffic.bean.song.user;
import cn.logcode.traffic.utils.okhttp.Myok;
import cn.logcode.traffic.utils.okhttp.song.Myhttp;


public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private EditText et_name;
    private EditText et_pass;
    private EditText et_email;
    private EditText et_pass1;
    private Button but_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        hideLeftMenu();
        showDesc();
        setTitle("注册", null);


    }


    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_email = (EditText) findViewById(R.id.et_email);
        et_pass1 = (EditText) findViewById(R.id.et_pass1);
        but_submit = (Button) findViewById(R.id.but_submit);

        but_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_submit:

                break;
        }
    }

    private void submit() {
        // validate
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

        String email = et_email.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "请输入邮箱", Toast.LENGTH_SHORT).show();
            return;
        }

        String pass1 = et_pass1.getText().toString().trim();
        if (TextUtils.isEmpty(pass1)) {
            Toast.makeText(this, "请确认密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.equals(pass1)) {
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
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        } else
                            Toast.makeText(RegisterActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(RegisterActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void Fial(String e) {
                    Toast.makeText(RegisterActivity.this, "网络请求失败", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
        }

    }
}
