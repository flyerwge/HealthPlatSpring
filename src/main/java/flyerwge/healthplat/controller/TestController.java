package flyerwge.healthplat.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//跨域问题：注解@CrossOrigin
@CrossOrigin("http://localhost:8080")
@RestController
public class TestController {
//    对应路径下显示数据
    @RequestMapping("/test")
    public String test(){
        return "Test";
    }
}
