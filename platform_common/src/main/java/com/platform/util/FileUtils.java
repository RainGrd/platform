package com.platform.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片工具类
 *
 * @author gzlx
 */
public class FileUtils {
    /**
     * 上传图片
     *
     * @param request
     * @param file
     * @throws IOException
     */
    public static String upload(HttpServletRequest request,
                                MultipartFile file) throws IOException {
        String path = null;//装配后的图片地址
        //上传图片
        if (file != null && !file.isEmpty()) {
            // 获取文件的扩展名
            String ext = FilenameUtils.getExtension(file
                    .getOriginalFilename());
            // 使用UUID给文件重命名，并去掉四个“-”
            String fileName = UUIDUtils.getUUID();
            // 设置文件上传路径
            String url = CommonUtil.setFileAbsPath(request) + "statics\\uploadfiles\\";
            System.out.println("url = " + url);
            //如何文件名称等于apk则使用原文件名
            if ("apk".equals(ext)) {
                fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));
                System.out.println("fileName = " + fileName);
            }
            // 检验文件夹是否存在
            if (isFolderExists(url)) {
                // 以相对路径保存重名命后的文件
                file.transferTo(new File(url + File.separator + fileName + "." + ext));
                // 装配文件地址
                path = "statics/uploadfiles/" + fileName + "." + ext;
            }

        }
        return path;
    }

    /**
     * 验证文件夹是否存在
     *
     * @param strFolder
     * @return
     */
    public static boolean isFolderExists(String strFolder) {
        File file = new File(strFolder);
        if (!file.exists()) {
            return file.mkdir();
        }
        System.out.println("-----------------文件上传路径：" + strFolder);
        return true;
    }

    /**
     * 获取目录下所有文件(按时间排序)
     *
     * @param path
     * @return
     */
    public static List<File> getFileSort(String path) {
        List<File> list = getFiles(path, new ArrayList<File>());
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator<File>() {
                public int compare(File file, File newFile) {
                    if (file.lastModified() < newFile.lastModified()) {//降序<;升序>
                        return 1;
                    } else if (file.lastModified() == newFile.lastModified()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
        }
        return list;
    }

    /**
     * 获取目录下所有文件
     *
     * @param realpath
     * @param files
     * @return
     */
    public static List<File> getFiles(String realpath, List<File> files) {
        File realFile = new File(realpath);
        if (realFile.isDirectory()) {
            File[] subfiles = realFile.listFiles();
            for (File file : subfiles) {
                if (file.isDirectory()) {
                    getFiles(file.getAbsolutePath(), files);
                } else {
                    files.add(file);
                }
            }
        }
        return files;
    }

}