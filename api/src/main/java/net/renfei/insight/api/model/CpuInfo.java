package net.renfei.insight.api.model;

import java.io.Serializable;

/**
 * CPU信息
 *
 * @author renfei
 */
public class CpuInfo implements Serializable {
    private static final long serialVersionUID = 100L;
    /**
     * CPU 逻辑核心数
     */
    private int logicalCoreCount;
    /**
     * CPU 物理核心数
     */
    private int physicalCoreCount;
    /**
     * CPU 物理包数
     */
    private int physicalPackageCount;
    /**
     * CPU 标识
     */
    private String identifier;
    /**
     * cpu系统使用率
     */
    private String cSys;
    /**
     * cpu用户使用率
     */
    private String user;
    /**
     * cpu当前等待率
     */
    private String ioWait;
    /**
     * cpu当前空闲率
     */
    private String idle;
    /**
     * cpu总使用率
     */
    private String cTotal;

    public int getLogicalCoreCount() {
        return logicalCoreCount;
    }

    public void setLogicalCoreCount(int logicalCoreCount) {
        this.logicalCoreCount = logicalCoreCount;
    }

    public int getPhysicalCoreCount() {
        return physicalCoreCount;
    }

    public void setPhysicalCoreCount(int physicalCoreCount) {
        this.physicalCoreCount = physicalCoreCount;
    }

    public int getPhysicalPackageCount() {
        return physicalPackageCount;
    }

    public void setPhysicalPackageCount(int physicalPackageCount) {
        this.physicalPackageCount = physicalPackageCount;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getcSys() {
        return cSys;
    }

    public void setcSys(String cSys) {
        this.cSys = cSys;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIoWait() {
        return ioWait;
    }

    public void setIoWait(String ioWait) {
        this.ioWait = ioWait;
    }

    public String getIdle() {
        return idle;
    }

    public void setIdle(String idle) {
        this.idle = idle;
    }

    public String getcTotal() {
        return cTotal;
    }

    public void setcTotal(String cTotal) {
        this.cTotal = cTotal;
    }

    @Override
    public String toString() {
        return "CpuInfo{" +
                "  logicalCoreCount=" + logicalCoreCount + "\n" +
                ", physicalCoreCount=" + physicalCoreCount + "\n" +
                ", physicalPackageCount=" + physicalPackageCount + "\n" +
                ", identifier='" + identifier + '\'' + "\n" +
                ", cSys='" + cSys + '\'' + "\n" +
                ", user='" + user + '\'' + "\n" +
                ", ioWait='" + ioWait + '\'' + "\n" +
                ", idle='" + idle + '\'' + "\n" +
                ", cTotal='" + cTotal + '\'' + "\n" +
                '}';
    }
}
