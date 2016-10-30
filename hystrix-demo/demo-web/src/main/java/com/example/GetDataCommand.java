package com.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import static com.netflix.hystrix.HystrixCommandGroupKey.*;


public class GetDataCommand extends HystrixCommand<String> {

    private String name = null;

    public GetDataCommand(String name) {
        super(
            Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(
                    HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(500)
                )
        );
        this.name = name;
    }

    @Override
    protected String run() {
        return "Hello " + name + "!";
    }

    @Override
    protected String getFallback() {
        return "Hello Failure " + name + "!";
    }
}
