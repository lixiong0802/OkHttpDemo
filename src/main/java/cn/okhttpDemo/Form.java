package cn.okhttpDemo;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: LX
 * Date: 2015/12/16 19:33
 * Desc:
 */
public class Form {

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormEncodingBuilder()
                .add("query", "Hello")
                .build();

        Request request = new Request.Builder().url("http://www.baidu.com").post(formBody)
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}