package net.renfei.insight.scan;

import com.sun.management.OperatingSystemMXBean;
import net.renfei.insight.api.model.Process;
import net.renfei.insight.api.model.*;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.util.FormatUtil;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author renfei
 */
public class SystemProperty {
    public static OperatingSystem getOsInfo(OperatingSystem operatingSystem) {
        if (operatingSystem == null) {
            operatingSystem = new OperatingSystem();
        }
        operatingSystem.setName(get("os.name"));
        operatingSystem.setArch(get("os.arch"));
        operatingSystem.setVersion(get("os.version"));
        operatingSystem.setFileSeparator(get("file.separator"));
        operatingSystem.setPathSeparator(get("path.separator"));
        operatingSystem.setLineSeparator(get("line.separator"));
        operatingSystem.setUserName(get("user.name"));
        operatingSystem.setUserHome(get("user.home"));
        operatingSystem.setUserDir(get("user.dir"));
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        operatingSystem.setTotalMemorySize(new DecimalFormat("#.##")
                .format(osmxb.getTotalPhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G");
        operatingSystem.setFreePhysicalMemorySize(new DecimalFormat("#.##")
                .format(osmxb.getFreePhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G");
        operatingSystem.setUsedMemory(new DecimalFormat("#.##").format(
                (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / 1024.0 / 1024 / 1024)
                + "G");
        operatingSystem.setSystemDate(new Date());
        return operatingSystem;
    }

    public static CpuInfo getCpuInfo(CpuInfo cpuInfo) {
        if (cpuInfo == null) {
            cpuInfo = new CpuInfo();
        }
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()]
                - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()]
                - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()]
                - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()]
                - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()]
                - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()]
                - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        cpuInfo.setPhysicalPackageCount(processor.getPhysicalPackageCount());
        cpuInfo.setPhysicalCoreCount(processor.getPhysicalProcessorCount());
        cpuInfo.setLogicalCoreCount(processor.getLogicalProcessorCount());
        cpuInfo.setIdentifier(processor.getProcessorIdentifier().getIdentifier());
        cpuInfo.setcSys(new DecimalFormat("#.##").format(cSys * 1.0 / totalCpu));
        cpuInfo.setUser(new DecimalFormat("#.##").format(user * 1.0 / totalCpu));
        cpuInfo.setIoWait(new DecimalFormat("#.##").format(iowait * 1.0 / totalCpu));
        cpuInfo.setIdle(new DecimalFormat("#.##").format(idle * 1.0 / totalCpu));
        cpuInfo.setcTotal(new DecimalFormat("#.##").format(1.0 - (idle * 1.0 / totalCpu)));
        return cpuInfo;
    }

    public static JvmInfo getJvmInfo(JvmInfo jvmInfo) {
        if (jvmInfo == null) {
            jvmInfo = new JvmInfo();
        }
        jvmInfo.setVersion(get("java.vm.version"));
        jvmInfo.setVendor(get("java.vm.vendor"));
        jvmInfo.setName(get("java.vm.name"));
        jvmInfo.setHome(get("java.home"));
        jvmInfo.setCompiler(get("java.vm.compiler"));
        return jvmInfo;
    }

    public static List<DisksInfo> getDisksInfo() {
        List<DisksInfo> disksInfo = new ArrayList<>();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        for (HWDiskStore disk : hal.getDiskStores()
        ) {
            DisksInfo diskInfo = new DisksInfo();
            diskInfo.setName(disk.getName());
            diskInfo.setModel(disk.getModel());
            diskInfo.setSn(disk.getSerial());
            diskInfo.setSize(disk.getSize() > 0 ? FormatUtil.formatBytesDecimal(disk.getSize()) : "0");
            List<HWPartition> partitions = disk.getPartitions();
            if (partitions == null) {
                disksInfo.add(diskInfo);
                continue;
            }
            List<PartitionInfo> partitionList = new ArrayList<>();
            for (HWPartition part : partitions) {
                PartitionInfo partitionInfo = new PartitionInfo();
                partitionInfo.setIdentification(part.getIdentification());
                partitionInfo.setName(part.getName());
                partitionInfo.setType(part.getType());
                partitionInfo.setSize(FormatUtil.formatBytesDecimal(part.getSize()));
                partitionInfo.setMountPoint(part.getMountPoint().isEmpty() ? "" : "" + part.getMountPoint());
                partitionList.add(partitionInfo);
            }
            diskInfo.setPartitions(partitionList);
            disksInfo.add(diskInfo);
        }
        return disksInfo;
    }

    public static List<FileSystemInfo> getFileSystemInfo() {
        List<FileSystemInfo> fileSystemInfos = new ArrayList<>();
        SystemInfo si = new SystemInfo();
        oshi.software.os.OperatingSystem os = si.getOperatingSystem();
        FileSystem fileSystem = os.getFileSystem();
        List<OSFileStore> fsArray = fileSystem.getFileStores();
        for (OSFileStore fs : fsArray) {
            long usable = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            FileSystemInfo fileSystemInfo = new FileSystemInfo();
            fileSystemInfo.setName(fs.getName());
            fileSystemInfo.setDescription(fs.getDescription().isEmpty() ? "" : fs.getDescription());
            fileSystemInfo.setType(fs.getType());
            fileSystemInfo.setUsable(FormatUtil.formatBytes(usable));
            fileSystemInfo.setTotalSpace(FormatUtil.formatBytes(fs.getTotalSpace()));
            fileSystemInfo.setUsablePer(new DecimalFormat("#.##").format(100d * usable / total));
            fileSystemInfo.setVolume(fs.getVolume());
            fileSystemInfo.setLogicalVolume(fs.getLogicalVolume());
            fileSystemInfo.setMount(fs.getMount());
            fileSystemInfos.add(fileSystemInfo);
        }
        return fileSystemInfos;
    }

    public static List<NetworkInterfaces> getNetworkInterfaces() {
        List<NetworkInterfaces> networkInterfaces = new ArrayList<>();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        for (NetworkIF net : hal.getNetworkIFs()) {
            NetworkInterfaces networkInterface = new NetworkInterfaces();
            boolean hasData = net.getBytesRecv() > 0 || net.getBytesSent() > 0 || net.getPacketsRecv() > 0
                    || net.getPacketsSent() > 0;
            networkInterface.setName(net.getName());
            networkInterface.setDisplayName(net.getDisplayName());
            networkInterface.setMacAddr(net.getMacaddr());
            networkInterface.setMtu(net.getMTU());
            networkInterface.setSpeed(FormatUtil.formatValue(net.getSpeed(), "bps"));
            networkInterface.setIpv4Addr(Arrays.toString(net.getIPv4addr()));
            networkInterface.setIpv6Addr(Arrays.toString(net.getIPv6addr()));
            networkInterface.setPacketsRecv(hasData ? net.getPacketsRecv() : 0L);
            networkInterface.setInErrors(net.getInErrors());
            networkInterface.setBytesRecv(hasData ? FormatUtil.formatBytes(net.getBytesRecv()) : "");
            networkInterface.setPacketsSent(hasData ? net.getPacketsSent() : 0L);
            networkInterface.setBytesSent(hasData ? FormatUtil.formatBytes(net.getBytesSent()) : "");
            networkInterface.setOutErrors(net.getOutErrors());
            networkInterfaces.add(networkInterface);
        }
        return networkInterfaces;
    }

    public static List<Process> getProcessList() {
        SystemInfo si = new SystemInfo();
        List<Process> processes = new ArrayList<>();
        for (OSProcess process : si.getOperatingSystem().getProcesses()
        ) {
            Process pro = new Process();
            pro.setProcessId(process.getProcessID());
            pro.setName(process.getName());
            pro.setPath(process.getPath());
            pro.setCommandLine(process.getCommandLine());
            pro.setUser(process.getUser());
            pro.setParentProcessId(process.getParentProcessID());
            pro.setUpTime(process.getUpTime());
            pro.setStartTime(process.getStartTime());
            processes.add(pro);
        }
        return processes;
    }

    private static String get(String key) {
        return System.getProperty(key);
    }
}
