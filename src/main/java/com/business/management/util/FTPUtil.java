package com.business.management.util;

import com.business.management.common.PropertiesConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */
@Slf4j
@EnableConfigurationProperties(PropertiesConfig.class)
public class FTPUtil {

    @Autowired
    PropertiesConfig propertiesConfig;

    private static String FTP_IP = PropertiesUtil.getProperty("cunho.ftpServerIp");//"114.55.169.130";//propertiesConfig.getFtpServerIp();
    private static String FTP_USER = PropertiesUtil.getProperty("cunho.ftpUsername");//"cunhoftp";//propertiesConfig.getFtpUsername();
    private static String FTP_PASSWORD = PropertiesUtil.getProperty("cunho.ftpPassword");//"cnsgh910kk@";//propertiesConfig.getFtpPassword();

    private String ip;
    private int port;
    private String user;
    private String password;
    private FTPClient ftpClient;

    public FTPUtil(String ip, int port, String user, String password) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    /**
     * 上传文件
     *
     * @param remotePath
     * @param fileList
     * @return
     * @throws Exception
     */
    public static boolean uploadFile(String remotePath, List<File> fileList) throws Exception {
        FTPUtil ftpUtil = new FTPUtil(FTP_IP, 20, FTP_USER, FTP_PASSWORD);
        log.info("开始连接ftp服务器");
        boolean result = ftpUtil.FtpUploadFile(remotePath, fileList);

        log.info("开始连接ftp服务器,结束上传,上传结果:{}", result);
        return result;
    }

    private boolean FtpUploadFile(String remotePath, List<File> fileList) throws Exception {
        boolean isUpload = true;
        FileInputStream fileInputStream = null;
        //连接FTP服务器
        if (connectFtpServer(this.ip, this.port, this.user, this.password)) {
            System.out.println("3333333");
            try {
                if (!ftpClient.changeWorkingDirectory(remotePath)) {
                    if (!ftpClient.makeDirectory(remotePath)) {
                        isUpload = false;
                    } else {
                        ftpClient.changeWorkingDirectory(remotePath);
                        log.info("remotePath:{}", remotePath);
                    }
                }
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                for (File fileItem : fileList) {
                    fileInputStream = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(), fileInputStream);
                }
            } catch (IOException e) {
                log.error("上传文件异常, e");
                isUpload = false;
                e.printStackTrace();
            } finally {
                fileInputStream.close();
                ftpClient.disconnect();
            }
        } else {
            isUpload = false;
        }

        return isUpload;
    }

    private boolean connectFtpServer(String ip, int port, String user, String password) {
        log.info("connet ftp start");
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            log.info("ip:{},user:{},password:{}" , ip,user,password);
            ftpClient.connect(ip,port);
            isSuccess = ftpClient.login(user, password);
            System.out.println("connet ftp result:" + isSuccess);
        } catch (IOException e) {
            log.error("连接FTP服务器异常", e);
        }
        System.out.println("connet ftp end");
        return isSuccess;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

}
