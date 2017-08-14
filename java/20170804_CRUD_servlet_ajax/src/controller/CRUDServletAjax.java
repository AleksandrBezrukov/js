package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import DAO.PersonDAO;
import DAOImplementation.PersonDAO_Mock;
import Model.Person;

public class CRUDServletAjax extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){};
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		BufferedReader in=request.getReader();
		PrintWriter out=response.getWriter();
		String inBuffer;
		//String result="";
		Resp resp=null;
		
		if((inBuffer=in.readLine())!=null)
		{
			String jsonBuffer=inBuffer.substring(inBuffer.indexOf("=")+1);
			Gson gson=new Gson();
			Act act=gson.fromJson(jsonBuffer, Act.class);
			PersonDAO personDAO = new PersonDAO_Mock();
			switch(act.action)
			{
			case "create":break;
			case "update":break;
			case "delete":break;
			case "read": 
				resp= new Resp("read","success",personDAO.read(),"");
				//personDAO.read();
				break;
			}
			out.write(gson.toJson(resp));
			out.flush();
		}

		
		//{action:'create',id:person['id'],firstname:person['firstname'],lastname:person['lastname'],age:person['age']}
	}

}

class Act
{
	String action;
	String id;
	String firstname;
	String lastname;
	String age;
	Act(String action,String id,String firstname,String lastname,String age)
	{
		this.action=action;
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
	}
}

class Resp
{
	String action;
	String result;
	ArrayList<Person> persons;//=new ArrayList<Person>();
	String show;
	Resp(String action, String result,ArrayList<Person> persons,String show)
	{
		this.action=action;
		this.result=result;
		this.persons=persons;
		this.show=show;
	}
}
