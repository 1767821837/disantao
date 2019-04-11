package cn.logcode.traffic.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.j256.ormlite.dao.Dao;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.SQLException;
import cn.logcode.traffic.R;
import cn.logcode.traffic.bean.song.CarBean;
import cn.logcode.traffic.bean.song.CarBeans;
import cn.logcode.traffic.dao.DBhtlp;
import cn.logcode.traffic.utils.okhttp.Myok;
import cn.logcode.traffic.utils.okhttp.song.Myhttp;
public class DialogUtils {

    static private DBhtlp dBhtlp;
    static   private Dao<CarBeans, ?> dao;
    public static void chongzhi(Context context, CarBean.DataBean dataBean,chong chong) {
        dBhtlp = new DBhtlp(context);
        try {
            dao = dBhtlp.getDao(CarBeans.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        EditText et_money;
        Button but_ok;
        Button but_client;
        View view = View.inflate(context, R.layout.chongzhidialog, null);
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setView(view)
                .create();
        dialog.show();
        et_money = view.findViewById(R.id.et_money);
        but_ok = view.findViewById(R.id.but_ok);
        but_client = view.findViewById(R.id.but_client);

        but_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        et_money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();
                if ("".equals(str)) {
                    return;
                }
                if (Integer.parseInt(str) == 0) {
                    et_money.setText("");
                }
            }
        });

        but_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_money.getText().toString().length() == 0) {
                    return;
                }
                String json = "{\"num\":" + dataBean.id + ",\"money\":" + Integer.parseInt(et_money.getText().toString()) + "}";
                Myhttp.recharge(json, new Myok() {
                    @Override
                    public void Success(String json) {
                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            JSONObject data = jsonObject.getJSONObject("data");
                            String msg = data.getString("msg");
                            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                            dataBean.money = dataBean.money+Integer.parseInt(et_money.getText().toString());
                            chong.success(dataBean);
                            dialog.dismiss();
                            CarBeans carBeans = new CarBeans();
                            carBeans.date = new java.util.Date();
                            carBeans.money = Integer.parseInt(et_money.getText().toString());
                            carBeans.num = dataBean.id;
                            dao.create(carBeans);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "充值失败", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void Fial(String e) {
                        Toast.makeText(context, "充值失败", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }
    public interface chong {

        void success(CarBean.DataBean dataBean);
    }

}
