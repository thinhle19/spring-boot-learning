package com.thinhle.springcore.rest;

import com.thinhle.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define private field for the dependency
    private Coach myCoach;

   /* // constructor for dpdc injection
    @Autowired // tell Spring to inject dependency
    // optional if there's just 1 constructor
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }
*/

    @Autowired // can be any method name
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }

    // Not sure why 2 @Autowired is allowed ?
    @Autowired
    public void aaa(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}