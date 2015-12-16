package cn.okhttpDemo;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: LX
 * Date: 2015/12/16 19:46
 * Desc:
 */
public class Multipart {

    public static void main(String[] args) {

        MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain");
        RequestBody requestBody = new MultipartBuilder()
                .type(MultipartBuilder.FORM)
                .addPart(
                        com.squareup.okhttp.Headers.of("Content-Disposition", "form-data; name=\"title\""),
                        RequestBody.create(null, "测试文档"))
                .addPart(
                        com.squareup.okhttp.Headers.of("Content-Disposition", "form-data; name=\"file\""),
                        RequestBody.create(MEDIA_TYPE_TEXT, new File("input.txt")))
                .build();

    }
}
