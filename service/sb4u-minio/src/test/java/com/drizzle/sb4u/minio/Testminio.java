package com.drizzle.sb4u.minio;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: drizzle
 * @Date: 2024/10/24/15:12
 * @Description:
 */
public class Testminio {

    static MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://127.0.0.1:9001")
                    .credentials("admin", "admin123")
                    .build();

    //上传文件
    @Test
    public  void upload() throws Exception {

        ContentInfo extensionMatch = ContentInfoUtil.findExtensionMatch(".sol");
        String mineType = MediaType.MULTIPART_FORM_DATA_VALUE;
        if(extensionMatch != null) {
            mineType = extensionMatch.getMimeType();
        }
        System.out.println(mineType);

        minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("testbucket")
                        .filename("D:\\develop\\upload\\1.sol")
                        .object("test/01/1.sol")
                        .contentType(mineType)
                        .build());

    }
}
