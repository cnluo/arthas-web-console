## 阿里巴巴开源组件arthas-boot的可视化管理控制台

基于Alibaba Java Diagnostic Tool Arthas/Alibaba Java诊断利器[Arthas](https://alibaba.github.io/arthas/)

### Arthas/Alibaba Java

当你遇到以下类似问题而束手无策时，`Arthas`可以帮助你解决：

1. 这个类从哪个 jar 包加载的？为什么会报各种类相关的 Exception？
2. 我改的代码为什么没有执行到？难道是我没 commit？分支搞错了？
3. 遇到问题无法在线上 debug，难道只能通过加日志再重新发布吗？
4. 线上遇到某个用户的数据处理有问题，但线上同样无法 debug，线下无法重现！
5. 是否有一个全局视角来查看系统的运行状况？
6. 有什么办法可以监控到JVM的实时运行状态？

`Arthas`支持JDK 8+，采用命令行交互模式，同时提供丰富的 `Tab` 自动补全功能，进一步方便进行问题的定位和诊断。



### 快速开始

下载源码：https://github.com/biuteifo/arthas-web-console.git

```markdown
执行命令：mvn clean install
```

进入target目录下

```
执行命令：java -jar arthas-web-console-0.0.1.jar
```

