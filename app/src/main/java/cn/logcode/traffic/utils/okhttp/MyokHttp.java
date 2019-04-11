package cn.logcode.traffic.utils.okhttp;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyokHttp {
    static Handler handler = new Handler(Looper.getMainLooper());
    static OkHttpClient client = new OkHttpClient.Builder()
            .writeTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build();
    public static void Post(String url, String json, Myok myok) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json);
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myok.Fial(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if (json == null || json.length() == 0)
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myok.Fial("请求发生错误");
                        }
                    });
                else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myok.Success(json);
                        }
                    });
                }
            }
        });

    }
}
