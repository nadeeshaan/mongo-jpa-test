package main.java.manager.reset.services;

import main.java.manager.controllers.TestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/testservice")
public class GetUsersService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String storeInDb() {
        TestController testController = new TestController();
        try {
            testController.saveContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "True";
    }

}