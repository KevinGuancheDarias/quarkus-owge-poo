package com.kevinguanchedarias.owge.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @GET
    public Map<String, String> hello() {
        Map<String, String> retVal = new HashMap<>();
        retVal.put("ola", "1234");
        return retVal;
    }
}