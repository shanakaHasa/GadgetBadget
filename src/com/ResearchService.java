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
}
