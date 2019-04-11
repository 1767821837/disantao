package cn.logcode.traffic.bean;

import java.util.List;

public class ZhangHuSheZhiBean {

    /**
     * code : 1
     * data : {"wendu":"17","shidu":"58","pm":"19","lukuang":[{"id":1,"state":4},{"id":2,"state":3},{"id":3,"state":5}]}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * wendu : 17
         * shidu : 58
         * pm : 19
         * lukuang : [{"id":1,"state":4},{"id":2,"state":3},{"id":3,"state":5}]
         */

        private String wendu;
        private String shidu;
        private String pm;
        private List<LukuangBean> lukuang;

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public String getPm() {
            return pm;
        }

        public void setPm(String pm) {
            this.pm = pm;
        }

        public List<LukuangBean> getLukuang() {
            return lukuang;
        }

        public void setLukuang(List<LukuangBean> lukuang) {
            this.lukuang = lukuang;
        }

        public static class LukuangBean {
            /**
             * id : 1
             * state : 4
             */

            private int id;
            private int state;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }
        }
    }
}
