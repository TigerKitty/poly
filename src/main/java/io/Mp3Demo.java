package io;

import java.io.*;

public class Mp3Demo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("E:\\蓝桥班\\Merge.mp3");
        File file = new File("E:\\蓝桥班\\IOTest");
        //向mp3.list中写入歌曲名称
        f(file);
        //从mp3.list中读取歌曲名称
        FileReader fr = new FileReader("E:\\蓝桥班\\mp3list.txt");
        BufferedReader br = new BufferedReader(fr);
        String a = "";
        while((a = br.readLine()) != null){
            System.out.println(a);
            //将每一个歌曲进行合并
            FileInputStream fis = new FileInputStream("E:\\蓝桥班\\IOTest\\"+a);
            //缓冲区
            byte[] bytes = new byte[1024];
            //记录缓冲区中的位置
            int b = 0;
            //循环进行输出
            while((b=fis.read(bytes)) != -1){
                fos.write(bytes,0,b);
            }
            fis.close();
        }
        //将缓冲区中的输出到文件中
        //fos.flush();
        fos.close();
    }
    public static void f(File file) throws IOException {
        //字符流写
        FileWriter fw = new FileWriter("E:\\蓝桥班\\mp3list.txt");
        //获取歌单列表
        File[] files = file.listFiles();
        int i = 0;
        while(i<files.length){
            if(files[i].isFile()){
                //System.out.println(files[i].getName());
                fw.write(files[i].getName());
                fw.write(13);
                fw.write(10);
            }
            i++;
        }
        fw.flush();
        fw.close();
    }
}
