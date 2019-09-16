package com.manager.util;

import com.manager.entry.common.CommonException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/09/16
 */
@Component
public class Upload {

    public static String saveFile(MultipartFile file) throws Exception {

        FileOutputStream out = null;
        InputStream in = null;
        String filePath;
        String savePath;
        // 检测文件大小
        if (file.isEmpty()) {
            throw new CommonException(Message.FILE_IS_EMPTY);
        }

        try {
            // 检测文件目录是否存在
            String systemPath = System.getProperty("user.dir");

            // 获取后缀
            String Suffix;
            String fileName = file.getOriginalFilename();
            Suffix = fileName.substring(fileName.indexOf("."));
            // 文件路径
            savePath = "/files/" + UUID.randomUUID().toString() + Suffix;
            filePath = systemPath + savePath;
            out = new FileOutputStream(filePath);
            in = file.getInputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
                out.flush();
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException(Message.FILE_SAVE_FAILED);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        return savePath;
    }
}
