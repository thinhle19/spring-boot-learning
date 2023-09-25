package com.thinhle.springcore.rest;

import com.thinhle.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Lazy
public class DemoController {
    // define private field for the dependency
    private Coach myCoach;
//    private Coach anotherCoach;

    // constructor for dpdc injection
    @Autowired // tell Spring to inject dependency
    // optional if there's just 1 constructor
    public DemoController(@Qualifier("cricketCoach") Coach theCoach
                         /* @Qualifier("cricketCoach") Coach theAnotherCoach*/) {
        System.out.println("ctor: " + getClass().getSimpleName());
        myCoach = theCoach;
//        anotherCoach = theAnotherCoach;
    }

/*    @Autowired // can be any method name
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }

    // Not sure why 2 @Autowired is allowed ?
    @Autowired
    public void aaa(Coach theCoach) {
        myCoach = theCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
