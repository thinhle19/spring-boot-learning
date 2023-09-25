package com.thinhle.springcore.common;

import com.thinhle.springcore.common.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Spring is dynamic => IDE may not be able to determine of a given class/method is used at runtime
// => why there's "no usages" warning.
@Component // mark the class as a Spring Bean => make it available for dependency injection.
//@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("ctor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Wake up and do Cricket Coach";
    }
}
