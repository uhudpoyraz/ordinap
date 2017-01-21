package com.ordinap.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
 
public class RegisterApplication extends Application{

     private Set<Object> singletons = new HashSet<Object>();
     
     public RegisterApplication() {
       // singletons.add(new BinaRest());
     }
     
     @Override
     public Set<Object> getSingletons() {
        return singletons;
     }
}