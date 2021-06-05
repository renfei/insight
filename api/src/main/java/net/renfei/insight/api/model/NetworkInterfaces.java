package net.renfei.insight.api.model;

import java.io.Serializable;

/**
 * @author renfei
 */
public class NetworkInterfaces implements Serializable {
    private static final long serialVersionUID = 100L;
    private String name;
    private String displayName;
    private String macAddr;
    private int mtu;
    private String speed;
    private String ipv4Addr;
    private String ipv6Addr;
    private long packetsRecv;
    private String bytesRecv;
    private long inErrors;
    private long packetsSent;
    private String bytesSent;
    private long outErrors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public int getMtu() {
        return mtu;
    }

    public void setMtu(int mtu) {
        this.mtu = mtu;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getIpv4Addr() {
        return ipv4Addr;
    }

    public void setIpv4Addr(String ipv4Addr) {
        this.ipv4Addr = ipv4Addr;
    }

    public String getIpv6Addr() {
        return ipv6Addr;
    }

    public void setIpv6Addr(String ipv6Addr) {
        this.ipv6Addr = ipv6Addr;
    }

    public long getPacketsRecv() {
        return packetsRecv;
    }

    public void setPacketsRecv(long packetsRecv) {
        this.packetsRecv = packetsRecv;
    }

    public String getBytesRecv() {
        return bytesRecv;
    }

    public void setBytesRecv(String bytesRecv) {
        this.bytesRecv = bytesRecv;
    }

    public long getInErrors() {
        return inErrors;
    }

    public void setInErrors(long inErrors) {
        this.inErrors = inErrors;
    }

    public long getPacketsSent() {
        return packetsSent;
    }

    public void setPacketsSent(long packetsSent) {
        this.packetsSent = packetsSent;
    }

    public String getBytesSent() {
        return bytesSent;
    }

    public void setBytesSent(String bytesSent) {
        this.bytesSent = bytesSent;
    }

    public long getOutErrors() {
        return outErrors;
    }

    public void setOutErrors(long outErrors) {
        this.outErrors = outErrors;
    }

    @Override
    public String toString() {
        return "NetworkInterfaces{" + "\n" +
                "name='" + name + '\'' + "\n" +
                ", displayName='" + displayName + '\'' + "\n" +
                ", macAddr='" + macAddr + '\'' + "\n" +
                ", mtu='" + mtu + '\'' + "\n" +
                ", speed='" + speed + '\'' + "\n" +
                ", ipv4Addr='" + ipv4Addr + '\'' + "\n" +
                ", ipv6Addr='" + ipv6Addr + '\'' + "\n" +
                ", packetsRecv=" + packetsRecv + "\n" +
                ", bytesRecv='" + bytesRecv + '\'' + "\n" +
                ", inErrors=" + inErrors + "\n" +
                ", packetsSent=" + packetsSent + "\n" +
                ", bytesSent='" + bytesSent + '\'' + "\n" +
                ", outErrors=" + outErrors + "\n" +
                '}';
    }
}
