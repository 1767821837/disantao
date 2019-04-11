package cn.logcode.traffic.bean;

import java.util.List;

public class GeRenZhongXinBean {

    /**
     * code : 1
     * data : {"name":"小新","sex":"男","phone":"18111111111","idcard":"511111111111111111","createtime":"2017-10-21","car":[{"id":1,"chepai":"川a11111"},{"id":2,"chepai":"川a22222"},{"id":3,"chepai":"川a3333"},{"id":4,"chepai":"川a1444"}]}
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
         * name : 小新
         * sex : 男
         * phone : 18111111111
         * idcard : 511111111111111111
         * createtime : 2017-10-21
         * car : [{"id":1,"chepai":"川a11111"},{"id":2,"chepai":"川a22222"},{"id":3,"chepai":"川a3333"},{"id":4,"chepai":"川a1444"}]
         */

        private String name;
        private String sex;
        private String phone;
        private String idcard;
        private String createtime;
        private List<CarBean> car;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public List<CarBean> getCar() {
            return car;
        }

        public void setCar(List<CarBean> car) {
            this.car = car;
        }

        public static class CarBean {
            /**
             * id : 1
             * chepai : 川a11111
             */

            private int id;
            private String chepai;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getChepai() {
                return chepai;
            }

            public void setChepai(String chepai) {
                this.chepai = chepai;
            }
        }
    }
}
