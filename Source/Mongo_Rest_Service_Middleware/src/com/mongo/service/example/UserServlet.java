package com.mongo.service.example;


import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import org.json.*;
//import com.ibm.json.java.JSON;
//import com.ibm.json.java.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

/**
 * Servlet implementation class UserServlet
 */
@Path("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds049854.mlab.com:49854/my_rest_services");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection user1 = db.getCollection("user1");
		BasicDBObject query = new BasicDBObject();
		query.put("name","user1");// request.getParameter("name"));
		query.put("password","user1"); //request.getParameter("password"));
		DBCursor docs = experiment1collection.find(query);
		response.getWriter().write(docs.toArray().toString());
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		String data = buffer.toString();
		System.out.println(data);

		JSONObject params = new JSONObject(data);
		BasicDBObject user2 = new BasicDBObject();
		
		for(Object key:params.keySet().toArray())
		{
			user2.put(key.toString(),params.get(key.toString()));
		}
		System.out.println(user2.toJson());
		
		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds049854.mlab.com:49854/my_rest_services");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection user1 = db.getCollection("user1");
		WriteResult result = user1.insert(user2);

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");

		response.getWriter().write(result.toString());
	}
	/**
	 * @see HttpServlet#doUpdate(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		String data = buffer.toString();
		System.out.println(data);

		JSONObject params = new JSONObject(data);
		BasicDBObject user2 = new BasicDBObject();

		for(Object key:params.keySet().toArray())
		{
			user2.update(key.toString(),params.get(key.toString()));
		}
		System.out.println(user2.toJson());

		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds049854.mlab.com:49854/my_rest_services");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection user1 = db.getCollection("user1");
		WriteResult result = user1.update(user1);

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "UPDATE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");

		response.getWriter().write(result.toString());
	}
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds049854.mlab.com:49854/my_rest_services");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection user1 = db.getCollection("user1");
		BasicDBObject query = new BasicDBObject();
		query.put("name","firstuser");// request.getParameter("name"));
		query.put("password","firstuser"); //request.getParameter("password"));
		DBCursor docs = user1.find(query);
		response.getWriter().write(docs.toArray().toString());
        ObjectId userId=new ObjectId(request.getParameter("id"));
			voObj.setObjId(userId);
			dataObj.delete(voObj);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}

	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, response);

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, HEAD, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}
}

