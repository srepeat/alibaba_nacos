package cn.jcet.xianlei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author 鲜磊 on 2019/8/13
 **/
@RestController
public class DemoController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @GetMapping("/test")
    public String test(String name){

        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos_discovery_provider");

        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/demo?name="+name,String.class);
    }
}
