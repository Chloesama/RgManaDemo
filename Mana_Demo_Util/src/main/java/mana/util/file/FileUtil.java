package mana.util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileUtil {
    /**
     * 新建文件
     */
    public static void newFile(String filePath, String fileName) {

        try {
            File file = new File(filePath + fileName);
            File fileParent = file.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();// 能创建多级目录
            }
            if (!file.exists()) {
                file.createNewFile();//有路径才能创建文件
            }
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    /**
     * 写文件
     */
    public static void writeFile(String filePath, String fileName,String str) {

        try {
            File file = new File(filePath + "\\" + fileName);
            FileOutputStream fos = null;

            if (!file.exists()) {
                file.createNewFile();//如果文件不存在，就创建该文件
                fos = new FileOutputStream(file);//首次写入获取
            } else {
                //如果文件已存在，那么就在文件末尾追加写入
                fos = new FileOutputStream(file, true);//这里构造方法多了一个参数true,表示在文件末尾追加写入
            }
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//指定以UTF-8格式写入文件

            osw.write(str);
            osw.close();

        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "E:\\data";
        String fileName = "Chloe.txt";
        FileUtil.writeFile(filePath,fileName,"test!!!");
    }
}
