package net.renfei.insight;

import net.renfei.insight.api.InsightApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Insight HTTP 上报接口
 *
 * @author renfei
 */
@FeignClient(name = "Client", url = "https://api.renfei.net")
public interface Client extends InsightApi {
}
