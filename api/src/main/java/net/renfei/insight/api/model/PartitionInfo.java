package net.renfei.insight.api.model;

import java.io.Serializable;

/**
 * 磁盘分区信息
 *
 * @author renfei
 */
public class PartitionInfo implements Serializable {
    private static final long serialVersionUID = 100L;
    private String identification;
    private String name;
    private String type;
    private String size;
    private String mountPoint;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(String mountPoint) {
        this.mountPoint = mountPoint;
    }

    @Override
    public String toString() {
        return "PartitionInfo{" +
                "identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", mountPoint='" + mountPoint + '\'' +
                '}';
    }
}
