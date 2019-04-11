package cn.logcode.traffic.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.logcode.traffic.R;
import cn.logcode.traffic.bean.HoLvDengBean;

public class HoLvDengAdapter extends BaseAdapter {

    private Context mContext;
    private List<HoLvDengBean.DataBean> mList;
    private LayoutInflater inflater;

    public HoLvDengAdapter(Context context, List list) {
        this.mContext = context;
        this.mList = list;
        inflater = LayoutInflater.from( context );
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        HoLvDengBean.DataBean bean = mList.get( position );
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from( mContext ).inflate( R.layout.ho_lv_deng_listview_item, viewGroup, false );
            viewHolder = new ViewHolder();
            viewHolder.id = view.findViewById( R.id.id );
            viewHolder.red = view.findViewById( R.id.red );
            viewHolder.green = view.findViewById( R.id.green );
            viewHolder.yellow = view.findViewById( R.id.yellow );
            view.setTag( viewHolder );
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.id.setText( bean.getId() + "" );
        viewHolder.red.setText( bean.getRed() + "" );
        viewHolder.green.setText( bean.getGreen() + "" );
        viewHolder.yellow.setText( bean.getYellow() + "" );
        return view;
    }

    class ViewHolder {
        private TextView id;
        private TextView red;
        private TextView green;
        private TextView yellow;
    }
}
