package com.alibaba.hym.rt.storageSystem.service.utils;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/2/24 19:56
 **/

import com.google.common.collect.Maps;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

/**
 * 文件工具类
 * Created by charlin on 2017/9/8.
 */

public class FileUtil {
    private final static Map<String, String> FILE_TYPE_MAP = Maps.newHashMap();
    private final static long MAX_SIZE = 10485760;
    private final static String AUTHORIZATION = "Authorization";

    static {
        FILE_TYPE_MAP.put("jpg", "FFD8FF");
        FILE_TYPE_MAP.put("png", "89504E47");
        FILE_TYPE_MAP.put("gif", "47494638");
        FILE_TYPE_MAP.put("jpeg", "33333333");
        /*   FILE_TYPE_MAP.put("tif", "49492A00");
        FILE_TYPE_MAP.put("bmp", "424D");
        FILE_TYPE_MAP.put("dwg", "41433130");
        FILE_TYPE_MAP.put("html", "68746D6C3E");
        FILE_TYPE_MAP.put("rtf", "7B5C727466");
        FILE_TYPE_MAP.put("xml", "3C3F786D6C");
        FILE_TYPE_MAP.put("zip", "504B0304");
        FILE_TYPE_MAP.put("rar", "52617221");
        FILE_TYPE_MAP.put("psd", "38425053"); //PhotoShop
        FILE_TYPE_MAP.put("eml", "44656C69766572792D646174653A"); //Email [thorough only]
        FILE_TYPE_MAP.put("dbx", "CFAD12FEC5FD746F"); //Outlook Express
        FILE_TYPE_MAP.put("pst", "2142444E"); //Outlook
        FILE_TYPE_MAP.put("office", "D0CF11E0"); //office类型，包括doc、xls和ppt
        FILE_TYPE_MAP.put("mdb", "000100005374616E64617264204A"); //MS Access
        FILE_TYPE_MAP.put("wpd", "FF575043"); //WordPerfect
        FILE_TYPE_MAP.put("eps", "252150532D41646F6265");
        FILE_TYPE_MAP.put("ps", "252150532D41646F6265");
        FILE_TYPE_MAP.put("pdf", "255044462D312E"); //Adobe Acrobat
        FILE_TYPE_MAP.put("qdf", "AC9EBD8F"); //Quicken
        FILE_TYPE_MAP.put("pwl", "E3828596"); //Windows Password
        FILE_TYPE_MAP.put("wav", "57415645"); //Wave
        FILE_TYPE_MAP.put("avi", "41564920");
        FILE_TYPE_MAP.put("ram", "2E7261FD"); //Real Audio
        FILE_TYPE_MAP.put("rm", "2E524D46"); //Real Media
        FILE_TYPE_MAP.put("mpg", "000001BA"); //
        FILE_TYPE_MAP.put("mov", "6D6F6F76"); //Quicktime
        FILE_TYPE_MAP.put("asf", "3026B2758E66CF11"); //Windows Media
        FILE_TYPE_MAP.put("mid", "4D546864"); //MIDI (mid)
    */
    }

    /**
     * 判断文件是否是图片
     *
     * @param file
     * @return
     */
    public static boolean isImage(MultipartFile file) {
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image != null) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static Boolean checkFileParam(MultipartFile multipartFile) {

        if (multipartFile.isEmpty() || multipartFile.getSize() > MAX_SIZE) {
            return false;
        }
        return true;
    }


    public static String saveFile(String path, MultipartFile multipartFile) throws IOException {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        StringBuilder fileLocation = new StringBuilder();
        String fileType = multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf("."));

        StringBuilder fileName = new StringBuilder();
        fileName.append(UUID.randomUUID())
                .append(System.currentTimeMillis())
                .append(fileType);

        fileLocation.append(path)
                .append(fileName);

        File file = new File(fileLocation.toString());

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        file.createNewFile();
        multipartFile.transferTo(file);
        return "/img/" + fileName.toString();
    }

    /**
     * 读取文件内容
     *
     * @param is
     * @return
     */
    public static String readFile(InputStream is) {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                sb.append(readLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 判断指定的文件是否存在。
     *
     * @param fileName
     * @return
     */
    public static boolean isFileExist(String fileName) {
        return new File(fileName).isFile();
    }

    /**
     * 创建指定的目录。 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。
     * 注意：可能会在返回false的时候创建部分父目录。
     *
     * @param file
     * @return
     */
    public static boolean makeDirectory(File file) {
        File parent = file.getParentFile();
        if (parent != null) {
            return parent.mkdirs();
        }
        return false;
    }

    /**
     * 返回文件的URL地址。
     *
     * @param file
     * @return
     * @throws MalformedURLException
     */
    public static URL getURL(File file) throws MalformedURLException {
        String fileURL = "file:/" + file.getAbsolutePath();
        URL url = new URL(fileURL);
        return url;
    }

    /**
     * 从文件路径得到文件名。
     *
     * @param filePath
     * @return
     */
    public static String getFileName(String filePath) {
        File file = new File(filePath);
        return file.getName();
    }

    /**
     * 从文件名得到文件绝对路径。
     *
     * @param fileName
     * @return
     */
    public static String getFilePath(String fileName) {
        File file = new File(fileName);
        return file.getAbsolutePath();
    }

    /**
     * 将DOS/Windows格式的路径转换为UNIX/Linux格式的路径。
     *
     * @param filePath
     * @return
     */
    public static String toUNIXpath(String filePath) {
        return filePath.replace("", "/");
    }

    /**
     * 从文件名得到UNIX风格的文件绝对路径。
     *
     * @param fileName
     * @return
     */
    public static String getUNIXfilePath(String fileName) {
        File file = new File(fileName);
        return toUNIXpath(file.getAbsolutePath());
    }

    /**
     * 得到文件后缀名
     *
     * @param fileName
     * @return
     */
    public static String getFileExt(String fileName) {
        int point = fileName.lastIndexOf('.');
        int length = fileName.length();
        if (point == -1 || point == length - 1) {
            return "";
        } else {
            return fileName.substring(point + 1, length);
        }
    }

    /**
     * 得到文件的名字部分。 实际上就是路径中的最后一个路径分隔符后的部分。
     *
     * @param fileName
     * @return
     */
    public static String getNamePart(String fileName) {
        int point = getPathLastIndex(fileName);
        int length = fileName.length();
        if (point == -1) {
            return fileName;
        } else if (point == length - 1) {
            int secondPoint = getPathLastIndex(fileName, point - 1);
            if (secondPoint == -1) {
                if (length == 1) {
                    return fileName;
                } else {
                    return fileName.substring(0, point);
                }
            } else {
                return fileName.substring(secondPoint + 1, point);
            }
        } else {
            return fileName.substring(point + 1);
        }
    }

    /**
     * 得到文件名中的父路径部分。 对两种路径分隔符都有效。 不存在时返回""。
     * 如果文件名是以路径分隔符结尾的则不考虑该分隔符，例如"/path/"返回""。
     *
     * @param fileName
     * @return
     */
    public static String getPathPart(String fileName) {
        int point = getPathLastIndex(fileName);
        int length = fileName.length();
        if (point == -1) {
            return "";
        } else if (point == length - 1) {
            int secondPoint = getPathLastIndex(fileName, point - 1);
            if (secondPoint == -1) {
                return "";
            } else {
                return fileName.substring(0, secondPoint);
            }
        } else {
            return fileName.substring(0, point);
        }
    }

    /**
     * 得到路径分隔符在文件路径中最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     * @return
     */
    public static int getPathLastIndex(String fileName) {
        int point = fileName.lastIndexOf("/");
        if (point == -1) {
            point = fileName.lastIndexOf("");
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中指定位置前最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     * @param fromIndex
     * @return
     */
    public static int getPathLastIndex(String fileName, int fromIndex) {
        int point = fileName.lastIndexOf("/", fromIndex);
        if (point == -1) {
            point = fileName.lastIndexOf("", fromIndex);
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中首次出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     * @return
     */
    public static int getPathIndex(String fileName) {
        int point = fileName.indexOf("/");
        if (point == -1) {
            point = fileName.indexOf("");
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中指定位置后首次出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     * @param fromIndex
     * @return
     */
    public static int getPathIndex(String fileName, int fromIndex) {
        int point = fileName.indexOf("/", fromIndex);
        if (point == -1) {
            point = fileName.indexOf("", fromIndex);
        }
        return point;
    }

    /**
     * 将文件名中的类型部分去掉。
     *
     * @param filename
     * @return
     */
    public static String removeFileExt(String filename) {
        int index = filename.lastIndexOf(".");
        if (index != -1) {
            return filename.substring(0, index);
        } else {
            return filename;
        }
    }

    /**
     * 得到相对路径。 文件名不是目录名的子节点时返回文件名。
     *
     * @param pathName
     * @param fileName
     * @return
     */
    public static String getSubpath(String pathName, String fileName) {
        int index = fileName.indexOf(pathName);
        if (index != -1) {
            return fileName.substring(index + pathName.length() + 1);
        } else {
            return fileName;
        }
    }

    /**
     * 删除一个文件。
     *
     * @param filename
     * @throws IOException
     */
    public static void deleteFile(String filename) throws IOException {
        File file = new File(filename);
        if (file.isDirectory()) {
            throw new IOException("IOException -> BadInputException: not a file.");
        }
        if (!file.exists()) {
            throw new IOException("IOException -> BadInputException: file is not exist.");
        }
        if (!file.delete()) {
            throw new IOException("Cannot delete file. filename = " + filename);
        }
    }

    /**
     * 复制文件
     *
     * @param src
     * @param dst
     * @throws Exception
     */
    public static void copy(File src, File dst) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }
}