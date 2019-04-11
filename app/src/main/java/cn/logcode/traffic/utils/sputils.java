package cn.logcode.traffic.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class sputils {
    public static SharedPreferences getdefalue(Context context) {
        SharedPreferences sp = context.getSharedPreferences("song", Context.MODE_PRIVATE);

        return sp;
    }
}
