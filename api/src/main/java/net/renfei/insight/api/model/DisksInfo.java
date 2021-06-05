package net.renfei.insight.api.model;

import java.io.Serializable;
import java.util.List;

/**
 * 磁盘信息
 *
 * @author renfei
 */
public class DisksInfo implements Serializable {
    private static final long serialVersionUID = 100L;
    private String name;
    private String model;
    private String sn;
    private String size;
    private List<PartitionInfo> partitions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<PartitionInfo> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<PartitionInfo> partitions) {
        this.partitions = partitions;
    }

    @Override
    public String toString() {
        return "DisksInfo{" + "\n" +
                "name='" + name + '\'' + "\n" +
                ", model='" + model + '\'' + "\n" +
                ", sn='" + sn + '\'' + "\n" +
                ", size='" + size + '\'' + "\n" +
                ", partitions=" + partitions + "\n" +
                '}';
    }
}
