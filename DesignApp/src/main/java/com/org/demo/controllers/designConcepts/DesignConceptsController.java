package com.org.demo.controllers.designConcepts;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DesignConceptsController {
	
	@RequestMapping(method = RequestMethod.GET, value = "designConcepts")
	public String getDesignConceptsView(Model model) {
		return "designConcepts";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/viewDesignConcept")
	public String showProjectsPage(@RequestParam("value") String value, Model model) {
		String path = "";
		String htmlRef = "/img/designConcepts/";
		String heading = "";
		if(value.equalsIgnoreCase("wardrobe")) {
			path = "src/main/resources/static/img/designConcepts/wardrobe";
			htmlRef += "wardrobe";
			heading = "WARDROBE";
		}
		else if(value.equalsIgnoreCase("tv_unit")) {
			path = "src/main/resources/static/img/designConcepts/tv_unit";
			htmlRef += "tv_unit";
			heading = "TV UNIT";
		}
		else if(value.equalsIgnoreCase("kitchen")) {
			path = "src/main/resources/static/img/designConcepts/kitchen";
			htmlRef += "kitchen";
			heading = "KITCHEN";
		}
		else if(value.equalsIgnoreCase("partition_design")) {
			path = "src/main/resources/static/img/designConcepts/partition_design";
			htmlRef += "partition_design";
			heading = "PARTITION DESIGN";
		}
		else if(value.equalsIgnoreCase("dressing_unit")) {
			path = "src/main/resources/static/img/designConcepts/dressing_unit";
			htmlRef += "dressing_unit";
			heading = "DRESSING UNIT";
		}
		else if(value.equalsIgnoreCase("signature_wall")) {
			path = "src/main/resources/static/img/designConcepts/signature_wall";
			htmlRef += "signature_wall";
			heading = "SIGNATURE WALL";
		}
				
		int totalImages = new File(path).listFiles().length;
		List<String> allImagesHrefs = new ArrayList<String>();	

		for(int i = 0; i < totalImages; i++) {
			String href = htmlRef + "/" + (i+1) + ".jpg";
			allImagesHrefs.add(href);
		}
		
		model.addAttribute("images", allImagesHrefs);
		model.addAttribute("heading", heading);
		return "viewProjects";
	}

}
