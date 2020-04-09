package com.business.management.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */


@Configuration
@PropertySource("classpath:config.properties")
public class PropertiesConfig {

    @Value("${cunho.passwordSalt}")
    private String passwordSalt;

    @Value("${cunho.miniAppId}")
    private String miniAppId;

    @Value("${cunho.miniAppSecret}")
    private String miniAppSecret;

    @Value("${cunho.mpAppId}")
    private String mpAppId;

    @Value("${cunho.mpAppSecret}")
    private String mpAppSecret;

    @Value("${cunho.ftpServerIp}")
    private String ftpServerIp;

    @Value("${cunho.ftpUsername}")
    private String ftpUsername;

    @Value("${cunho.ftpPassword}")
    private String ftpPassword;

    @Value("${cunho.fileServerHttpPrefix}")
    private String fileServerHttpPrefix;

    @Value("${cunho.filePath}")
    private String filePath;

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getMiniAppId() {
        return miniAppId;
    }

    public void setMiniAppId(String miniAppId) {
        this.miniAppId = miniAppId;
    }

    public String getMiniAppSecret() {
        return miniAppSecret;
    }

    public void setMiniAppSecret(String miniAppSecret) {
        this.miniAppSecret = miniAppSecret;
    }

    public String getMpAppId() {
        return mpAppId;
    }

    public void setMpAppId(String mpAppId) {
        this.mpAppId = mpAppId;
    }

    public String getMpAppSecret() {
        return mpAppSecret;
    }

    public void setMpAppSecret(String mpAppSecret) {
        this.mpAppSecret = mpAppSecret;
    }

    public String getFtpServerIp() {
        return ftpServerIp;
    }

    public void setFtpServerIp(String ftpServerIp) {
        this.ftpServerIp = ftpServerIp;
    }

    public String getFtpUsername() {
        return ftpUsername;
    }

    public void setFtpUsername(String ftpUsername) {
        this.ftpUsername = ftpUsername;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public String getFileServerHttpPrefix() {
        return fileServerHttpPrefix;
    }

    public void setFileServerHttpPrefix(String fileServerHttpPrefix) {
        this.fileServerHttpPrefix = fileServerHttpPrefix;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "PropertiesConfig{" +
                "passwordSalt='" + passwordSalt + '\'' +
                ", miniAppId='" + miniAppId + '\'' +
                ", miniAppSecret='" + miniAppSecret + '\'' +
                ", mpAppId='" + mpAppId + '\'' +
                ", mpAppSecret='" + mpAppSecret + '\'' +
                ", ftpServerIp='" + ftpServerIp + '\'' +
                ", ftpUsername='" + ftpUsername + '\'' +
                ", ftpPassword='" + ftpPassword + '\'' +
                ", fileServerHttpPrefix='" + fileServerHttpPrefix + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
