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
    CarDataDao carDao;

    @Autowired
    CarDataUsingCmdDao carDataUsingCmdDao;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/yurcar")
    public String getYurCar(Map<String, Object> model) {
        System.out.println("------ ctrl-yurcar");
        model.put("time", new Date());
        model.put("message", carDao.getCarData() );
        return "index";
    }

    @GetMapping("/yurcar-slow")
    public String getYurCarSlowt(Map<String, Object> model) {
        System.out.println("------ ctrl-yurcarslow");
        model.put("time", new Date());
        model.put("message", carDao.getCarDataDirect() );
        return "index";
    }

    @GetMapping("/hellocmd")
    public String hello(Map<String, Object> model) {
        System.out.println("------ ctrl-hello");
        model.put("time", new Date());
        model.put("message", new HelloCommand("Mikey").execute() );
        return "index";
    }

    @GetMapping("/yurcar-cmd")
    public String getYurCarCmd(Map<String, Object> model) {
        System.out.println("------ ctrl-yurcar-cmd");
        model.put("time", new Date());
        model.put("message", carDataUsingCmdDao.getCarData2() );
        return "index";
    }

    @RequestMapping("/serviceUnavailable")
    public String ServiceUnavailable() {
        throw new ServiceUnavailableException();
    }

    @RequestMapping("/bang")
    public String bang() {
        throw new RuntimeException("Boom");
    }

    @RequestMapping("/insufficientStorage")
    public String insufficientStorage() {
        throw new InsufficientStorageException();
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    private static class ServiceUnavailableException extends RuntimeException {

    }

    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    private static class InsufficientStorageException extends RuntimeException {

    }
}
