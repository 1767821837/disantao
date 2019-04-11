package cn.logcode.traffic.ui.fragment;

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

public class MyzuojiaFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myzuojia1fragment2, container, false);


        return view;

    }


}
