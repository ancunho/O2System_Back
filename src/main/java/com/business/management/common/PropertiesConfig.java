package com.business.management.common;

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

    @Value("${cunho.ftpServerHttpPrefix}")
    private String ftpServerHttpPrefix;

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

    public String getFtpServerHttpPrefix() {
        return ftpServerHttpPrefix;
    }

    public void setFtpServerHttpPrefix(String ftpServerHttpPrefix) {
        this.ftpServerHttpPrefix = ftpServerHttpPrefix;
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
                ", ftpServerHttpPrefix='" + ftpServerHttpPrefix + '\'' +
                '}';
    }

}
