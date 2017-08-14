package com.alacriti.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.buyit.util.PostingToDB;

@Path("example")

public class Checkingpath {
	String[] data;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String checkingExample(){
		return "Example is executed";
	}
	
	
	@POST
	@Path("InsertingData")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public void postingDataToDB(String data){
		boolean isError=false;
		System.out.println("Checkingpath postingDataToDB:");
		try{
		PostingToDB.putdata(data);
		}catch(Exception e){
			isError=true;
			System.out.println("exception occured"+e);}
		finally{
			if(isError)
		System.out.println("error");
		}
	}

}
