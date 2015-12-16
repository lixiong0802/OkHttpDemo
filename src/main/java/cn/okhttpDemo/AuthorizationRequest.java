package cn.okhttpDemo;

import com.squareup.okhttp.*;

import java.io.IOException;
import java.net.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: LX
 * Date: 2015/12/16 19:50
 * Desc:
 */
public class AuthorizationRequest {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();
        client.setAuthenticator(new Authenticator() {
            public Request authenticate(Proxy proxy, Response response) throws IOException {
                String credential = Credentials.basic("user", "password");
                return response.request().newBuilder()
                        .header("Authorization", credential)
                        .build();
            }

            public Request authenticateProxy(Proxy proxy, Response response)
                    throws IOException {
                return null;
            }
        });

    }
}
