package com.sandbox.service;

import com.sandbox.FetchSystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Service
public class SystemPerformanceService {

    @Autowired
    FetchSystemInfo fetchSystemInfo ;

    public String getlsInfo()
    {
        int exitCode =0;
        System.out.println("==============START==================") ;
        StringBuffer sb = new StringBuffer();
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("bash", "-c", "ls -ltr");

        // Windows
        //processBuilder.command("cmd.exe", "/c", "ping -n 3 google.com");

        try {

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("===========>"+line);
                sb.append(line+"<br>");
            }

            exitCode = process.waitFor();
            sb.append(exitCode);
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello ***************exitCode= " + sb);
        sb.append("Hello ***************exitCode= " + exitCode);
        return "Hello ***************exitCode= "+sb;
    }

    public String cpuInfo() {
        if(fetchSystemInfo.queue.size()>0) {
            return fetchSystemInfo.queue.remove().toString();
        }else{
            return "";
        }
    }
}
