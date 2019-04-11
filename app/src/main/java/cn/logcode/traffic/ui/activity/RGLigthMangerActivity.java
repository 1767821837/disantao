package cn.logcode.traffic.ui.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.logcode.traffic.R;
import cn.logcode.traffic.adapter.HoLvDengAdapter;
import cn.logcode.traffic.base.BaseActivity;
import cn.logcode.traffic.bean.HoLvDengBean;
import cn.logcode.traffic.utils.okhttp.Myok;
import cn.logcode.traffic.utils.okhttp.MyokHttp;

/**
 * 红绿灯管理
 */
public class RGLigthMangerActivity extends BaseActivity {

    private int i = 0;
    private Spinner mSpinner;
    private Button mQuery;
    private ListView mListview;
    private HoLvDengAdapter adapter;
    private List<HoLvDengBean.DataBean> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_rglmanget );
        setTitle( "红绿灯管理" );
        setLeft_menu( R.mipmap.back, view -> onBackPressed() );
        initViews();
        OKHttp();

        mSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                i = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

        mQuery.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (i) {
                    case 1:
                        Collections.sort( mList, new Comparator<HoLvDengBean.DataBean>() {
                            @Override
                            public int compare(HoLvDengBean.DataBean t1, HoLvDengBean.DataBean t2) {
                                return t1.getId() - t2.getId();
                            }
                        } );
                        break;
                    case 2:
                        Collections.sort( mList, new Comparator<HoLvDengBean.DataBean>() {
                            @Override
                            public int compare(HoLvDengBean.DataBean t1, HoLvDengBean.DataBean t2) {
                                return t2.getId() - t1.getId();
                            }
                        } );
                        break;
                    case 3:
                        Collections.sort( mList, new Comparator<HoLvDengBean.DataBean>() {
                            @Override
                            public int compare(HoLvDengBean.DataBean t1, HoLvDengBean.DataBean t2) {
                                return t1.getRed() - t2.getRed();
                            }
                        } );
                        break;
                    case 4:
                        Collections.sort( mList, new Comparator<HoLvDengBean.DataBean>() {
                            @Override
                            public int compare(HoLvDengBean.DataBean t1, HoLvDengBean.DataBean t2) {
                                return t2.getRed() - t1.getRed();
                            }
                        } );
                        break;
                    case 5:
                        Collections.sort( mList, new Comparator<HoLvDengBean.DataBean>() {
                            @Override
                            public int compare(HoLvDengBean.DataBean t1, HoLvDengBean.DataBean t2) {
                                return t1.getGreen() - t2.getGreen();
                            }
                        } );
                        break;
                    case 6:
                        Collections.sort( mList, new Comparator<HoLvDengBean.DataBean>() {
                            @Override
                            public int compare(HoLvDengBean.DataBean t1, HoLvDengBean.DataBean t2) {
                                return t2.getGreen() - t1.getGreen();
                            }
                        } );
                        break;
                    case 7:
                        Collections.sort( mList, new Comparator<HoLvDengBean.DataBean>() {
                            @Override
                            public int compare(HoLvDengBean.DataBean t1, HoLvDengBean.DataBean t2) {
                                return t1.getYellow() - t2.getYellow();
                            }
                        } );
                        break;
                    case 8:
                        Collections.sort( mList, new Comparator<HoLvDengBean.DataBean>() {
                            @Override
                            public int compare(HoLvDengBean.DataBean t1, HoLvDengBean.DataBean t2) {
                                return t2.getYellow() - t1.getYellow();
                            }
                        } );
                        break;
                }
                adapter = new HoLvDengAdapter( RGLigthMangerActivity.this, mList );
                mListview.setAdapter( adapter );
            }
        } );
    }

    private void OKHttp() {
        MyokHttp.Post( "https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/lamplist", "",
                new Myok() {
                    @Override
                    public void Success(String json) {
                        AlertDialog dialog = new ProgressDialog.Builder( RGLigthMangerActivity.this )
                                .setTitle( "正在加载中..." )
                                .show();
                        Gson gson = new Gson();
                        try {
                            HoLvDengBean bean = gson.fromJson( json, HoLvDengBean.class );
                            if (mList.size() == 0){
                                mList.addAll( bean.getData() );
                            }else {
                                mList.clear();
                                mList.addAll( bean.getData() );
                            }
                            if(adapter == null){
                                adapter = new HoLvDengAdapter( RGLigthMangerActivity.this, mList );
                                mListview.setAdapter( adapter );
                            }else {
                                adapter.notifyDataSetChanged();
                            }
                            dialog.dismiss();
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                            dialog.dismiss();
                            Toast.makeText( RGLigthMangerActivity.this, "加载失败！", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    @Override
                    public void Fial(String e) {

                    }
                } );
    }

    private void initViews() {
        mSpinner = (Spinner) findViewById( R.id.spinner );
        mQuery = (Button) findViewById( R.id.query );
        mListview = (ListView) findViewById( R.id.listview );
    }
}
