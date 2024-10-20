package com.jaden.dream.jvmconfig;

public class JvmConfig {
    //常见命令 定位进程 分析进程 解决问题
    //jps -l （获取 java 进程信息）
    //jstat -gc java-pid 1000 10（查看 jvm 统计信息）

    /*表头	含义（字节）
    S0C	幸存者 0 区的大小
    S1C	幸存者 1 区的大小
    S0U	幸存者 0 区已使用的大小
    S1U	幸存者 1 区已使用的大小
    EC	Eden 区的大小
    EU	Eden 区已使用的大小
    OC	老年代的大小
    OU	老年代已使用的大小
    MC	元空间的大小
    MU	元空间已使用的大小
    CCSC	压缩类空间的大小
    CCSU	压缩类空间已使用的大小
    YGC	从应用程序启动到采样时 Young GC 的次数
    YGCT	从应用程序启动到采样时 Young GC 消耗时间（秒）
    FGC	从应用程序启动到采样时 Full GC 的次数
    FGCT	从应用程序启动到采样时的 Full GC 的消耗时间（秒）
    GCT	从应用程序启动到采样时 GC 的总时间
    后面的参数代表 1000 毫秒打印一次，一个打印 10 次。*/

}
