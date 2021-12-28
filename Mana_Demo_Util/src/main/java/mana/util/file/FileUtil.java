package mana.util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

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
    public static void writeFile(String filePath, String fileName, String str) {

        try {
            File file = new File(filePath + "\\" + fileName);
            FileOutputStream fos = null;

            if (!file.exists()) {
                //如果文件不存在，就创建该文件
                file.createNewFile();
                //首次写入获取
                fos = new FileOutputStream(file);
            } else {
                //如果文件已存在，那么就在文件末尾追加写入
                //这里构造方法多了一个参数true,表示在文件末尾追加写入
                fos = new FileOutputStream(file, true);
            }
            //指定以UTF-8格式写入文件
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

            osw.write(str);
            osw.close();

        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    /**
     * 遍历删除目录下所有的文件和目录
     *
     * @param filePath
     */
    public static void delPathAllFile(String filePath) {
        try {
            Files.walkFileTree(Paths.get(filePath), new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return super.postVisitDirectory(dir, exc);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyPathAllFile(String sourcePath, String targetPath) {
        try {
            Files.walk(Paths.get(sourcePath)).forEach(path -> {
                String targetName = path.toString().replace(sourcePath, targetPath);
                try {
                    if (Files.isDirectory(path)) {
                        Files.createDirectory(Paths.get(targetName));
                    } else if (Files.isRegularFile(path)) {
                        Files.copy(path, Paths.get(targetName));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String filePath = "E:\\data";
        String fileName = "Chloe.txt";
        FileUtil.writeFile(filePath, fileName, "test!!!");
    }
}
