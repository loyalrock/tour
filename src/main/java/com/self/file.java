package com.self;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class file {
    private static Set<String> apis = new HashSet<>();

    public static void main(String[] args) throws Exception {
        getFile("/Users/zhongyan/IdeaProjects/aikang/", "");
        System.out.println("api个数：" + apis.size());
    }

    public static void getFile (Set<String> set) throws IOException {
        String fileName = System.currentTimeMillis() + ".txt";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

    }

    public static void getContent(File file) throws Exception {
        FileInputStream fileInput = new FileInputStream(file);
        try {
            byte[] temp = new byte[(int) file.length()];
            fileInput.read(temp);
            StringBuffer stringBuffer = new StringBuffer(new String(temp));
            int beginIndex = 0;
            int endIndex = 0;
            int length = stringBuffer.length();
            while ((beginIndex = stringBuffer.indexOf("chronic/")) != -1) {
                // 缓存起始位置，从当前位置寻找下一个引号
                int tempIndex = beginIndex;
                do {
                    tempIndex++;
                } while (tempIndex <= length - 1 && stringBuffer.charAt(tempIndex) != '\'' && stringBuffer.charAt(tempIndex) != '\"');
                endIndex = tempIndex;
                String api = stringBuffer.substring(beginIndex, endIndex);
                if (!apis.contains(api)) {
                    apis.add(api);
                    System.out.println(api);
                }
                // 截取当前字符串，并从结尾处寻找下一个开始位置
                stringBuffer = new StringBuffer(stringBuffer.substring(endIndex));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fileInput.close();
        }

    }

    /**
     * 封装实现文件查找功能的类
     *
     * @param path 传入要遍历的文件目录
     * @param tab  传入空格,区分文件夹及其子文件夹
     */
    public static void getFile(String path, String tab) throws Exception {
        List<String> passUrl = Arrays.asList(
                "node_modules",
                "chronic",
                "akbase",
                "apidocs",
                ".idea",
                ".git"
        );

        File file = new File(path);

        if (file.exists()) {   //文件存在 用File类数组接收目录下所有的文件的抽象路径
            File[] listFile = file.listFiles();

            //遍历目录下所有文件判断是否为文件夹
            for (File file2 : listFile) {
                // 过滤文件夹
                if (passUrl.contains(file2.getName())) {
                    continue;
                }
//                System.out.println(tab + file2.getName());
                // 如果是目录,把当前目录和taB作为参数传入,调用自身,
                if (file2.isDirectory()) {//传入子文件夹路径并换行
                    getFile(file2.getPath(), tab + "\t");
                } else {
                    getContent(file2);
                }
            }
        }
    }
}
