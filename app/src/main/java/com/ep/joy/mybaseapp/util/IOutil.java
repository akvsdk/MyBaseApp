package com.ep.joy.mybaseapp.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * author   Joy
 * Date:  2016/3/31.
 * version:  V1.0
 * Description:仅支持文本操作
 */
public class IOutil {
    /**
     * 文本的写入操作
     *
     * @param filePath 文件路径。一定要加上文件名字 <br>
     *                 例如：../a/a.txt
     * @param content  写入内容
     * @param append   是否追加
     */
    public static void write(String filePath, String content, boolean append) {
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filePath, append)));
            bufw.write(content);

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (bufw != null) {
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
