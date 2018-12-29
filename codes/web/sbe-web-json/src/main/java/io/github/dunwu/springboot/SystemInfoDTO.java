package io.github.dunwu.springboot;

/**
 * @author Zhang Peng
 * @date 2018-12-29
 */
public class SystemInfoDTO {
    private String appName;
    private String version;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
