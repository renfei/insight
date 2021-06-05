package net.renfei.insight.scan;

import net.renfei.insight.Client;
import net.renfei.insight.api.model.InsightReport;
import net.renfei.insight.config.Config;
import net.renfei.sdk.entity.APIResult;
import net.renfei.sdk.utils.DateUtils;
import org.springframework.stereotype.Service;

/**
 * @author renfei
 */
@Service
public class ReportScan {
    private final Config config;
    private final Client client;

    public ReportScan(Config config,
                      Client client) {
        this.config = config;
        this.client = client;
    }

    public InsightReport scan() {
        InsightReport insightReport = new InsightReport();
        insightReport.setOperatingSystem(SystemProperty.getOsInfo(null));
        insightReport.setCpuInfo(SystemProperty.getCpuInfo(null));
        insightReport.setJvmInfo(SystemProperty.getJvmInfo(null));
        insightReport.setDisksInfo(SystemProperty.getDisksInfo());
        insightReport.setFileSystemInfo(SystemProperty.getFileSystemInfo());
        insightReport.setNetworkInterfaces(SystemProperty.getNetworkInterfaces());
        insightReport.setProcesses(SystemProperty.getProcessList());
        insightReport.setAgentUuid(config.getUuid());
        return insightReport;
    }

    public void report() {
        InsightReport report = scan();
        if (config.print) {
            System.out.println("");
            System.out.println("===============================");
            System.out.println("== " + DateUtils.getDate("yyyy-MM-dd HH:mm:dd") + " = 开始扫描");
            System.out.println("===============================");
            System.out.println(report);
            System.out.println("===============================");
            System.out.println("== " + DateUtils.getDate("yyyy-MM-dd HH:mm:dd") + " = 扫描完成");
            System.out.println("===============================");
            System.out.println("");
            System.out.println("===============================");
            System.out.println("== " + DateUtils.getDate("yyyy-MM-dd HH:mm:dd") + " = 开始上报");
            System.out.println("===============================");
            client.insightReport(new APIResult<>(report));
            System.out.println("");
            System.out.println("===============================");
            System.out.println("== " + DateUtils.getDate("yyyy-MM-dd HH:mm:dd") + " = 上报完成");
            System.out.println("===============================");
        } else {
            client.insightReport(new APIResult<>(report));
        }
    }
}
