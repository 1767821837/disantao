package cn.logcode.traffic.bean.song;

import java.util.List;

public class CarBean {

    public int code;
    public List<DataBean> data;
    public static class DataBean {


        public int id;
        public String chepai;
        public String chezhu;
        public int money;
    }
}
