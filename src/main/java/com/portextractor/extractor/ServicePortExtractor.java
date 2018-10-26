package com.portextractor.extractor;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : VipinK
 * @since : 26/10/18
 * modification :
 * description :
 */

@RestController
@RequestMapping("/services")
public class ServicePortExtractor {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/instances")
    public Object getAllServicesPortAndInstances(){

        List<String> applications = discoveryClient.getServices();

        Map<Integer, String> servicesToPort = new TreeMap<>();

        for (String application : applications) {
            List<ServiceInstance> applicationsInstances = discoveryClient.getInstances(application);
            int port = 0;
            for (ServiceInstance applicationsInstance : applicationsInstances) {
                port = applicationsInstance.getPort();
            }

            servicesToPort.put(port, application);
        }


        return servicesToPort;
    }
}
