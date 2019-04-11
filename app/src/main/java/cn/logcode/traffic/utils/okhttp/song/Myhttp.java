package cn.logcode.traffic.utils.okhttp.song;

import cn.logcode.traffic.utils.okhttp.Myok;
import cn.logcode.traffic.utils.okhttp.MyokHttp;

public class Myhttp {
    public  static  void login(String json, Myok myok){
        MyokHttp.Post("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/login",json,myok);
    }

    public  static  void carlist( Myok myok){
        MyokHttp.Post("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/carlist","",myok);
    }

    public  static  void recharge(String json, Myok myok){
        MyokHttp.Post("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/recharge",json,myok);
    }
}
