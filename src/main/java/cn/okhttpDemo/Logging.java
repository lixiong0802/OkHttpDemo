package cn.okhttpDemo;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: LX
 * Date: 2015/12/16 20:07
 * Desc:
 */
public class Logging {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();

        client.interceptors().add(new LoggingInterceptor()); //添加应用拦截器
        client.networkInterceptors().add(new LoggingInterceptor()); //添加网络拦截器

        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("服务器端错误: " + response);
                }

//                System.out.println(response.body().string());
            }
        });
    }
}
