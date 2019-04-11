package cn.logcode.traffic.bean;

import java.util.List;

public class HoLvDengBean {

    /**
     * code : 1
     * data : [{"id":1,"red":3,"green":5,"yellow":9},{"id":2,"red":4,"green":8,"yellow":3},{"id":3,"red":2,"green":15,"yellow":20},{"id":4,"red":9,"green":7,"yellow":1},{"id":5,"red":7,"green":19,"yellow":3}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * red : 3
         * green : 5
         * yellow : 9
         */

        private int id;
        private int red;
        private int green;
        private int yellow;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public int getYellow() {
            return yellow;
        }

        public void setYellow(int yellow) {
            this.yellow = yellow;
        }
    }
}
