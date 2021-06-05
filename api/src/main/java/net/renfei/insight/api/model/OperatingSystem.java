package net.renfei.insight.api.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author renfei
 */
public class OperatingSystem implements Serializable {
    private static final long serialVersionUID = 100L;
    private String name;
    private String arch;
    private String version;
    private String fileSeparator;
    private String pathSeparator;
    private String lineSeparator;
    private String userName;
    private String userHome;
    private String userDir;
    private String totalMemorySize;
    private String freePhysicalMemorySize;
    private String usedMemory;
    private Date systemDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFileSeparator() {
        return fileSeparator;
    }

    public void setFileSeparator(String fileSeparator) {
        this.fileSeparator = fileSeparator;
    }

    public String getPathSeparator() {
        return pathSeparator;
    }

    public void setPathSeparator(String pathSeparator) {
        this.pathSeparator = pathSeparator;
    }

    public String getLineSeparator() {
        return lineSeparator;
    }

    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    public String getUserDir() {
        return userDir;
    }

    public void setUserDir(String userDir) {
        this.userDir = userDir;
    }

    public String getTotalMemorySize() {
        return totalMemorySize;
    }

    public void setTotalMemorySize(String totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
    }

    public String getFreePhysicalMemorySize() {
        return freePhysicalMemorySize;
    }

    public void setFreePhysicalMemorySize(String freePhysicalMemorySize) {
        this.freePhysicalMemorySize = freePhysicalMemorySize;
    }

    public String getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(String usedMemory) {
        this.usedMemory = usedMemory;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    @Override
    public String toString() {
        return "OperatingSystem{" + "\n" +
                "name='" + name + '\'' + "\n" +
                ", arch='" + arch + '\'' + "\n" +
                ", version='" + version + '\'' + "\n" +
                ", fileSeparator='" + fileSeparator + '\'' + "\n" +
                ", pathSeparator='" + pathSeparator + '\'' + "\n" +
                ", lineSeparator='" + lineSeparator + '\'' + "\n" +
                ", userName='" + userName + '\'' + "\n" +
                ", userHome='" + userHome + '\'' + "\n" +
                ", userDir='" + userDir + '\'' + "\n" +
                ", totalMemorySize='" + totalMemorySize + '\'' + "\n" +
                ", freePhysicalMemorySize='" + freePhysicalMemorySize + '\'' + "\n" +
                ", usedMemory='" + usedMemory + '\'' + "\n" +
                ", systemDate='" + systemDate + '\'' + "\n" +
                '}';
    }
}
