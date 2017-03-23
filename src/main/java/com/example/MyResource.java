package com.example;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET  
    @Path("/getInfo")  
    @Produces(MediaType.TEXT_PLAIN)  
    public String getWebServiceInfo() {  
        return "Hello,RESTful web service!";  
    }  
      
  
    @GET  
    @Path("/{parameter}")  
    public Response respondMessage(@PathParam("parameter") String parameter,  
            @DefaultValue("Nothing to say") @QueryParam("value") String value) {  
        String out = "Hello from " + parameter + ":" + value;  
        return Response.status(200).entity(out).build();  
    }  
}
