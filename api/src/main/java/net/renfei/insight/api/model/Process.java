package net.renfei.insight.api.model;

import java.io.Serializable;

/**
 * @author renfei
 */
public class Process implements Serializable {
    private static final long serialVersionUID = 100L;
    private int processId;
    private String name;
    private String path;
    private String commandLine;
    private String user;
    private int parentProcessId;
    private long upTime;
    private long startTime;

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getParentProcessId() {
        return parentProcessId;
    }

    public void setParentProcessId(int parentProcessId) {
        this.parentProcessId = parentProcessId;
    }

    public long getUpTime() {
        return upTime;
    }

    public void setUpTime(long upTime) {
        this.upTime = upTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId=" + processId + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", path='" + path + '\'' + "\n" +
                ", commandLine='" + commandLine + '\'' + "\n" +
                ", user='" + user + '\'' + "\n" +
                ", parentProcessId=" + parentProcessId + "\n" +
                ", upTime=" + upTime + "\n" +
                ", startTime=" + startTime + "\n" +
                '}';
    }
}
