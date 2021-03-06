package io;

import java.io.*;

public class PictureMerge {
    public static void main(String[] args) {
        File file = new File("E:\\蓝桥班\\测试文件\\MergePic");
        String path = "e:\\picList.txt";
        try {
            f(file, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void f(File file, String path) throws IOException {
        File files[] = file.listFiles();
        //创建图片路径Txt文件
        FileWriter fw = new FileWriter(path);
        int i = 0;
        while(i<files.length){
            //判断是否为图片文件
            System.out.println(files[i].getName());
            if(files[i].getName().endsWith("png")){
                //获取图片的绝对路径
                fw.write(files[i].getAbsolutePath());
                fw.write(13);//回车
                fw.write(10);//换行
            }
            i++;
        }
        fw.close();
        //从List中读取图片路径信息
        FileReader fr = new FileReader(path);
        //用BufferedReader对进行FileReader包装
        BufferedReader br = new BufferedReader(fr);
        //创建FileOutputStream字节流输出
        FileOutputStream fos = new FileOutputStream("e:\\mergePic.bat");
        //按行读取
        String str = "";
        while ((str = br.readLine()) != null){
            FileInputStream fis = new FileInputStream(str);
            //缓冲区
            byte bytes[] = new byte[1024];//1KB
            //循环进行读取
            int a = 0;
            while((a = fis.read(bytes)) != -1){
                //到输出流中
                fos.write(bytes,0,a);
            }
            fis.close();
        }
        fos.close();
    }
}
