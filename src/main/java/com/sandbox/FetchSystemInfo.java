package com.sandbox;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.management.ManagementFactory;

import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.LinkedList;
import java.util.Queue;

@Component
public class FetchSystemInfo {

    public static Queue<Integer> queue = new LinkedList<>();

    int max = 16;
    int min = 1;
    int range = max - min + 1;

    @Scheduled(fixedRate = 5000)
    public void fetchSystemInfo(){
        System.out.println("##### fetchSystemInfo #######");
        OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println("Name="+bean.getName());
        System.out.println("Process="+bean.getAvailableProcessors());
        System.out.println("arch="+bean.getArch());
        System.out.println("version="+bean.getVersion());
        System.out.println("System load Avg="+bean.getSystemLoadAverage());

        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        System.out.println((osBean.getSystemCpuLoad() * 100) + "%");

        int rand = (int)(Math.random() * range) + min;
        queue.add(rand);
        System.out.println(queue);
    }
}
