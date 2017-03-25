package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
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

	/**
	 * api/demo/param?val=122344abc
	 * 
	 * @param parameter
	 * @param value
	 * @return
	 */
	@GET
	@Path("/{param}")
	public Response respondMessage(@PathParam("param") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("val") String value) {
		String out = "Hello from [" + parameter + "]:value:[" + value + "]";
		return Response.status(200).entity(out).build();
	}

	@GET
	@Path("/map")
	@Produces({ MediaType.APPLICATION_JSON })
	public HashMap<String, String> getMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("abc", "def");
		return map;
	}

	@GET
	@Path("/list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Map<String, String>> getListMap() {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("a3", "aaa");
		map.put("b3", "bbb");

		Hashtable<String, String> map1 = new Hashtable<String, String>();
		map1.put("c3", "ccc");
		map1.put("d3", "ddd");

		list.add(map1);
		list.add(map);

		return list;
	}

	/**
	 * need submit from form page.
	 * 
	 * @param a1
	 * @param a2
	 * @return
	 */
	@POST
	@Path("/update")
	@Produces("application/json")
	public Map<String, String> update(@FormParam(value = "a1") String a1, @FormParam(value = "a2") String a2) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a1", a1);
		map.put("a2", a2);
		return map;
	}
	
	/**
	 * can be use for ajax ,pass json.
	 * @param a1
	 * @param a2
	 * @return
	 */
	@GET
	@Path("/testGet")
	@Produces("application/json")
	public Map<String, String> testGet(@QueryParam(value = "a1") String a1, @QueryParam(value = "a2") String a2) {
		System.out.println(a1);
		Map<String, String> map = new HashMap<String, String>();
		map.put("a1", a1);
		map.put("a2", a2);
		System.out.println(map);
		return map;
	}
	
	// @GET
	// @Path("/requestTest")
	// @Produces("application/json")
	// public Map<String, String> update(@Context HttpServletRequest request) {
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("a1", request.getParameter("a1"));
	// map.put("a2", request.getParameter("a2"));
	// map.put("a3", request.getQueryString());
	// return map;
	// }
}
