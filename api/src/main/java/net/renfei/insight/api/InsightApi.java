package net.renfei.insight.api;

import net.renfei.insight.api.model.InsightReport;
import net.renfei.sdk.entity.APIResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Insight HTTP 上报接口
 *
 * @author renfei
 */
public interface InsightApi {
    /**
     * Insight HTTP 上报端点
     *
     * @param report
     */
    @PostMapping("/api/insight/report/point")
    void insightReport(@RequestBody APIResult<InsightReport> report);
}
