package com.example;

import java.util.HashMap;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "demo" path)
 */
@Path("demo")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
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

	@GET
	@Path("/getJson")
	@Produces({ MediaType.APPLICATION_JSON })
	public HashMap getClientedMessage() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("abc", "def");
		return map;
	}
}
