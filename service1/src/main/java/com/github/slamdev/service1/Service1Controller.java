package com.github.slamdev.service1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/service1")
public class Service1Controller {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public Greeting sayHello() {
        return new Greeting(counter.incrementAndGet(), "Hello from Service1");
    }

    public static class Greeting {
        public final long id;
        public final String content;

        public Greeting(long id, String content) {
            this.id = id;
            this.content = content;
        }
    }
}
