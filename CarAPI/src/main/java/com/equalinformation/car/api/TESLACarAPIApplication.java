package com.equalinformation.car.api;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bpupadhyaya on 3/27/17.
 */


public class TESLACarAPIApplication extends Application {
    public Set<Class<?>> getClasses() {
        Set<Class<?>> serviceSet = new HashSet<Class<?>>();
        serviceSet.add(CarServices.class);
        return serviceSet;
    }
}