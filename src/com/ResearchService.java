package com;

import model.Research;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Researchs")
public class ResearchService {

	Research researchObj = new Research();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readResearchs()
	{
		return researchObj.readResearchs();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertResearch(@FormParam("researchCode") String researchCode,
			@FormParam("researchName") String researchName,
			@FormParam("researchPrice") String researchPrice,
			@FormParam("researchDesc") String researchDesc)
	{
		String output = researchObj.insertResearch(researchCode, researchName, researchPrice, researchDesc);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateResearch(String researchData)
	{
		//Convert the input string to a JSON object
		JsonObject researchObject = new JsonParser().parse(researchData).getAsJsonObject();
		//Read the values from the JSON object
		String researchID = researchObject.get("researchID").getAsString();
		String researchCode = researchObject.get("researchCode").getAsString();
		String researchName = researchObject.get("researchName").getAsString();
		String researchPrice = researchObject.get("researchPrice").getAsString();
		String researchDesc = researchObject.get("researchDesc").getAsString();
		String output = researchObj.updateResearch(researchID, researchCode, researchName, researchPrice, researchDesc);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteResearch(String researchData)
	{
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(researchData, "", Parser.xmlParser());

		//Read the value from the element <researchID>
		String researchID = doc.select("researchID").text();
		String output = researchObj.deleteResearch(researchID);
		return output;
	}




}
