package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.Map;

@Controller
class CarController {

    @Autowired
    HelloService helloService;

    @Autowired
    CarDataDao carDao;

    @Autowired
    CarDataUsingCmdDao carDataUsingCmdDao;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";


    @GetMapping("/hello")
    public String hello(Map<String, Object> model) {
        System.out.println("------ ctrl-hello");
        model.put("time", new Date());
        model.put("message", helloService.sayHello() );
        return "index";
    }

    @GetMapping("/hello/cmd")
    public String helloCmd(Map<String, Object> model) {
        System.out.println("------ ctrl-hellocmd");
        model.put("time", new Date());
        model.put("message", new HelloCommand("Mikey").execute() );
        return "index";
    }

    @GetMapping("/yurcar")
    public String getYurCar(Map<String, Object> model) {
        System.out.println("------ ctrl-yurcar");
        model.put("time", new Date());
        model.put("message", carDao.getCarData() );
        return "index";
    }

    @GetMapping("/yurcar/cmd")
    public String getYurCarCmd(Map<String, Object> model) {
        System.out.println("------ ctrl-yurcar-cmd");
        model.put("time", new Date());
        model.put("message", carDataUsingCmdDao.getCarData2() );
        return "index";
    }

    @GetMapping("/yurcar/slow")
    public String getYurCarSlowtf(Map<String, Object> model) {
        System.out.println("------ ctrl-yurcarslow");
        model.put("time", new Date());
        model.put("message", carDao.getCarDataDirect() );
        return "index";
    }
}
