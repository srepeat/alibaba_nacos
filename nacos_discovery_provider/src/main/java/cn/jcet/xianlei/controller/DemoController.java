package cn.jcet.xianlei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 鲜磊 on 2019/8/13
 **/
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo(String name){
        return "Hello  "+name;
    }
}
