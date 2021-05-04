package com.example.cloud.cloudservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ConsulController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/loadBalance")
    public String loadBalance() {
        return restTemplate.getForObject("http://service2/services", String.class);
    }

    @GetMapping("/services")
    public String services() {
        return StringUtils.collectionToCommaDelimitedString(discoveryClient.getServices());
    }

    @GetMapping("/instances/{service}")
    public List<String> serviceUrl(@PathVariable String service) {
        List<ServiceInstance> list = discoveryClient.getInstances(service);
        //list.get(0).getMetadata() => aaa:bbb bbb:ccc secure: false
        return list.stream().map(e -> e.getUri().toString()).collect(Collectors.toList());
    }

}
