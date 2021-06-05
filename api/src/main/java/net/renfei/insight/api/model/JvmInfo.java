package net.renfei.insight.api.model;

import java.io.Serializable;

/**
 * @author renfei
 */
public class JvmInfo implements Serializable {
    private static final long serialVersionUID = 100L;
    private String version;
    private String vendor;
    private String name;
    private String home;
    private String compiler;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getCompiler() {
        return compiler;
    }

    public void setCompiler(String compiler) {
        this.compiler = compiler;
    }

    @Override
    public String toString() {
        return "JvmInfo{" +
                "version='" + version + '\'' + "\n" +
                ", vendor='" + vendor + '\'' + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", home='" + home + '\'' + "\n" +
                ", compiler='" + compiler + '\'' + "\n" +
                '}';
    }
}
