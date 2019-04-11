package cn.logcode.traffic.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.List;

import cn.logcode.traffic.R;
import cn.logcode.traffic.bean.song.CarBean;
import cn.logcode.traffic.utils.DialogUtils;
import cn.logcode.traffic.utils.okhttp.Myok;
import cn.logcode.traffic.utils.okhttp.song.Myhttp;

public class MyzuojiaFragment extends Fragment implements View.OnClickListener {
    private LinearLayout ll_first;
    private LinearLayout ll_second;
    private LinearLayout ll_disan;
    private LinearLayout ll_disi;
    private List<CarBean.DataBean> data;
    int fazhi = 50;
    private int postion;
    String[] fazhiStr = {"警告", "正常"};
    int colors[] = {Color.parseColor("#FFEF2B20"), Color.parseColor("#00ff0d")};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myzuojia1fragment, container, false);
        fazhi = Integer.parseInt(getContext().getSharedPreferences("Yu_Zhi", Context.MODE_PRIVATE).getString("yuzhi", "50"));
        initView(view);
        initdata();

        return view;

    }

    private void initdata() {
        Myhttp.carlist(new Myok() {
            @Override
            public void Success(String json) {
                try {
                    CarBean bean = new Gson().fromJson(json, CarBean.class);
                    data = bean.data;
                    getdata();

                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "网路请求失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void Fial(String e) {
                Toast.makeText(getContext(), "网路请求失败", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView(View view) {
        ll_first = (LinearLayout) view.findViewById(R.id.ll_first);
        ll_second = (LinearLayout) view.findViewById(R.id.ll_second);
        ll_disan = (LinearLayout) view.findViewById(R.id.ll_disan);
        ll_disi = (LinearLayout) view.findViewById(R.id.ll_disi);
        ll_first.setOnClickListener(this);
        ll_second.setOnClickListener(this);
        ll_disan.setOnClickListener(this);
        ll_disi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int postion = 0;
        switch (view.getId()) {
            case R.id.ll_first:
                postion = 0;
                int finalPostion1 = postion;
                DialogUtils.chongzhi(getContext(), data.get(postion), new DialogUtils.chong() {
                    @Override
                    public void success(CarBean.DataBean dataBean) {
                        data.remove(finalPostion1);
                        data.add(finalPostion1, dataBean);
                        getdata();
                    }
                });
                break;
            case R.id.ll_second:
                postion = 1;
                int finalPostion2 = postion;
                DialogUtils.chongzhi(getContext(), data.get(postion), new DialogUtils.chong() {
                    @Override
                    public void success(CarBean.DataBean dataBean) {
                        data.remove(finalPostion2);
                        data.add(finalPostion2, dataBean);
                        getdata();
                    }
                });
                break;
            case R.id.ll_disan:
                postion = 2;
                int finalPostion3 = postion;
                DialogUtils.chongzhi(getContext(), data.get(postion), new DialogUtils.chong() {
                    @Override
                    public void success(CarBean.DataBean dataBean) {
                        data.remove(finalPostion3);
                        data.add(finalPostion3, dataBean);
                        getdata();
                    }
                });
                break;
            case R.id.ll_disi:
                postion = 3;

                int finalPostion = postion;
                DialogUtils.chongzhi(getContext(), data.get(postion), new DialogUtils.chong() {
                    @Override
                    public void success(CarBean.DataBean dataBean) {
                        data.remove(finalPostion);
                        data.add(finalPostion, dataBean);
                        getdata();

                    }
                });
                break;


        }
    }

    public void getdata() {

        if (fazhi > data.get(0).money)
            postion = 0;
        else
            postion = 1;
        ((TextView) ll_first.getChildAt(0)).setText("1号小车\n\n" + fazhiStr[postion]);
        ((TextView) ll_first.getChildAt(1)).setText(data.get(0).money + "");
        ll_first.setBackgroundColor(colors[postion]);
        if (fazhi > data.get(1).money)
            postion = 0;
        else
            postion = 1;

        ((TextView) ll_second.getChildAt(0)).setText("2号小车\n\n" + fazhiStr[postion]);
        ((TextView) ll_second.getChildAt(1)).setText(data.get(1).money + "");
        ll_second.setBackgroundColor(colors[postion]);
        if (fazhi > data.get(2).money)
            postion = 0;
        else
            postion = 1;
        ((TextView) ll_disan.getChildAt(0)).setText("3号小车\n\n" + fazhiStr[postion]);
        ((TextView) ll_disan.getChildAt(1)).setText(data.get(2).money + "");
        ll_disan.setBackgroundColor(colors[postion]);
        if (fazhi > data.get(3).money)
            postion = 0;
        else
            postion = 1;
        ((TextView) ll_disi.getChildAt(0)).setText("4号小车\n\n" + fazhiStr[postion]);
        ((TextView) ll_disi.getChildAt(1)).setText(data.get(3).money + "");
        ll_disi.setBackgroundColor(colors[postion]);

    }
}
