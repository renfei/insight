# 服务器监控采集

基于 oshi、SpringBoot 的服务器监控采集程序，可采集CPU、内存、网卡、硬盘、操作系统等信息。

## insighter

insighter 模块是部署在服务器端的采集程序，编译为 Jar 包运行在各个服务器节点上。

启动参数说明如下：

```bash
-h #显示帮助信息
-i #Agent的UUID编号
-u #上报主机地址
-p #是否打印扫描的结果
-c #定时任务cron表达式，默认为2秒一次
```

### 启动案例

启动时的命令案例：

## api

api 模块是与 insighter 对接的模块，双方约定好接口地址、传递的对象。

接收监控信息，请自行编写```Controller```实现```net.renfei.insight.api.InsightApi```接口，例如：

```java
import net.renfei.insight.api.InsightApi;
import net.renfei.insight.api.model.InsightReport;
import net.renfei.sdk.entity.APIResult;

@Controller
public class InsightController implements InsightApi{
    @Override
    public void insightReport(@RequestBody APIResult<InsightReport> report){
        InsightReport reportData = report.getData();
        // TODO
    }
}
```
