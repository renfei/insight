package net.renfei.insight.api.model;

import java.io.Serializable;
import java.util.List;

/**
 * InsightReport
 *
 * @author renfei
 */
public class InsightReport implements Serializable {
    private static final long serialVersionUID = 100L;
    private String agentUuid;
    private JvmInfo jvmInfo;
    private CpuInfo cpuInfo;
    private OperatingSystem operatingSystem;
    private List<DisksInfo> disksInfo;
    private List<FileSystemInfo> fileSystemInfo;
    private List<NetworkInterfaces> networkInterfaces;
    private List<Process> processes;

    public String getAgentUuid() {
        return agentUuid;
    }

    public void setAgentUuid(String agentUuid) {
        this.agentUuid = agentUuid;
    }

    public JvmInfo getJvmInfo() {
        return jvmInfo;
    }

    public void setJvmInfo(JvmInfo jvmInfo) {
        this.jvmInfo = jvmInfo;
    }

    public CpuInfo getCpuInfo() {
        return cpuInfo;
    }

    public void setCpuInfo(CpuInfo cpuInfo) {
        this.cpuInfo = cpuInfo;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public List<DisksInfo> getDisksInfo() {
        return disksInfo;
    }

    public void setDisksInfo(List<DisksInfo> disksInfo) {
        this.disksInfo = disksInfo;
    }

    public List<FileSystemInfo> getFileSystemInfo() {
        return fileSystemInfo;
    }

    public void setFileSystemInfo(List<FileSystemInfo> fileSystemInfo) {
        this.fileSystemInfo = fileSystemInfo;
    }

    public List<NetworkInterfaces> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<NetworkInterfaces> networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return "InsightReport{" + "\n" +
                "agentUuid='" + agentUuid + '\'' + "\n" +
                ", jvmInfo=" + jvmInfo + "\n" +
                ", cpuInfo=" + cpuInfo + "\n" +
                ", operatingSystem=" + operatingSystem + "\n" +
                ", disksInfo=" + disksInfo + "\n" +
                ", fileSystemInfo=" + fileSystemInfo + "\n" +
                ", networkInterfaces=" + networkInterfaces + "\n" +
                ", processes=" + processes + "\n" +
                '}';
    }
}
