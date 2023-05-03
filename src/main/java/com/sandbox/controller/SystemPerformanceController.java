package com.sandbox.controller;
import com.sandbox.FetchSystemInfo;
import com.sandbox.service.SystemPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SystemPerformanceController
{
    @Autowired
    SystemPerformanceService systemPerformanceService;

    @Autowired
    FetchSystemInfo fetchSystemInfo;

@RequestMapping("/")
public String hello() 
{
return "Hello ***************";
}



@GetMapping("/cmd")
public String getlsInfo()
{
    return systemPerformanceService.getlsInfo();
}


@GetMapping("/cpuInfo")
    public String cpuInfo()
    {
        return "{success:"+systemPerformanceService.cpuInfo()+"}";
    }
}

