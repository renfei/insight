package net.renfei.insight.api.model;

import java.io.Serializable;

/**
 * @author renfei
 */
public class FileSystemInfo implements Serializable {
    private static final long serialVersionUID = 100L;
    private String name;
    private String description;
    private String type;
    private String usable;
    private String totalSpace;
    private String usablePer;
    private String volume;
    private String logicalVolume;
    private String mount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable;
    }

    public String getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(String totalSpace) {
        this.totalSpace = totalSpace;
    }

    public String getUsablePer() {
        return usablePer;
    }

    public void setUsablePer(String usablePer) {
        this.usablePer = usablePer;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLogicalVolume() {
        return logicalVolume;
    }

    public void setLogicalVolume(String logicalVolume) {
        this.logicalVolume = logicalVolume;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    @Override
    public String toString() {
        return "FileSystemInfo{" + "\n" +
                "name='" + name + '\'' + "\n" +
                ", description='" + description + '\'' + "\n" +
                ", type='" + type + '\'' + "\n" +
                ", usable='" + usable + '\'' + "\n" +
                ", totalSpace='" + totalSpace + '\'' + "\n" +
                ", usablePer='" + usablePer + '\'' + "\n" +
                ", volume='" + volume + '\'' + "\n" +
                ", logicalVolume='" + logicalVolume + '\'' + "\n" +
                ", mount='" + mount + '\'' + "\n" +
                '}';
    }
}
