package osdesign.util;

import sun.rmi.runtime.Log;

import java.io.*;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * Created by pokerface_lx
 */
public class FileHelper {

    public static final String FILETYPE_FOLDER = "folder";

    /***
     * 获取文件类型
     * 文件夹-返回“folder”
     * 其他-返回扩展名
     *
     * @param path
     * @return
     */
    public String getType(String path) {
        if (path == null) {
            return "null";
        }
        String flagPath = path;
        String type = "";
        while (flagPath.contains(".")) {
            type = path.substring(path.indexOf(".") + 1, path.length());
            flagPath = type;
        }
        if (type.equals("")) {
            return "folder";
        } else {
            return type;
        }
    }

    /***
     * 删除文件的函数
     * 正常删除返回true 异常返回false
     *
     * @param file
     * @return
     */
    public boolean deleteFile(File file) {
        boolean result = false;
        try {
            if (file.isDirectory()) {
                if (file.listFiles().length > 0) {
                    for (File i : file.listFiles()) {
                        deleteFile(i);
                    }
                    result = true;
                } else {
                    file.delete();
                    result = true;
                }
            } else {
                file.delete();
                result = true;
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    /***
     * 新建文件
     * 返回true 文件创建成功
     * 返回false 文件创建失败（文件存在/权限不够/未知原因）
     *
     * @param path
     * @param fileName
     * @return
     */
    public boolean createFile(String path, String fileName) {
        boolean result = false;
        File file = new File(path + File.separator + fileName);
        if (!file.exists()) {
            try {
                if (getType(fileName).equals(FILETYPE_FOLDER)) {
                    file.mkdir();
                } else {
                    file.createNewFile();
                }
                result = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /***
     * 文件重命名
     * 返回true-成功
     * 返回false-失败 未知原因
     *
     * @param file
     * @param newName
     * @return
     */
    public boolean rename(File file, String newName) {
        String path = file.getParent() + File.separator + newName;
        return file.renameTo(new File(path));
    }

    /***
     * 文件复制
     * true-成功 false-失败
     *
     * @param oldFile
     * @param newPath
     * @return
     */
    public boolean copyFile(File oldFile, String newPath){
        String path = newPath + File.separator + oldFile.getName();
        File temp = new File(path);
        if (temp.exists()) {
            return false;
        }
        // 判断是否为文件夹
        if (oldFile.isDirectory()) {
            temp.mkdir();
            for (File i: oldFile.listFiles()) {
                copyFile(i, temp.getPath());
            }
        }else {
            // 是文件，进行管道复制
            try {
                FileInputStream fis = new FileInputStream(oldFile);
                FileChannel createChannel = fis.getChannel();
                FileOutputStream fos = new FileOutputStream(path);
                FileChannel getChannel = fos.getChannel();
                getChannel.transferFrom(createChannel, 0, createChannel.size());
                getChannel.close();
                createChannel.close();
                fos.flush();
                fos.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /***
     * 文件剪切
     * true-成功 false-失败
     *
     * @param oldFile
     * @param newPath
     * @return
     */
    public boolean cutFile(File oldFile, String newPath) {
        if (copyFile(oldFile, newPath)) {
            oldFile.delete();
            return true;
        } else {
            return false;
        }
    }

    /***
     * 返回文件最后操作的时间
     * 格式为yyyy-MM-dd HH:mm
     *
     * @param file
     * @return
     */
    public String getCreateTime(File file) {
        long time = file.lastModified();
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String createTime = formatter.format(date);
        return createTime;
    }

}
