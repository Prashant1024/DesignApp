package com.org.demo.controllers.projectsController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectsController {

	@RequestMapping(method = RequestMethod.GET, value = "/viewProjects")
	public String showProjectsPage(@RequestParam("value") String value, Model model) {
		String path = "";
		String htmlRef = "/img/projects/";
		String heading = "";
		if(value.equalsIgnoreCase("wardrobe")) {
			path = "src/main/resources/static/img/projects/wardrobe";
			htmlRef += "wardrobe";
			heading = "WARDROBE";
		}
		else if(value.equalsIgnoreCase("tv_unit")) {
			path = "src/main/resources/static/img/projects/tv_unit";
			htmlRef += "tv_unit";
			heading = "TV UNIT";
		}
		else if(value.equalsIgnoreCase("kitchen")) {
			path = "src/main/resources/static/img/projects/kitchen";
			htmlRef += "kitchen";
			heading = "KITCHEN";
		}
		else if(value.equalsIgnoreCase("living_room")) {
			path = "src/main/resources/static/img/projects/living_room";
			htmlRef += "living_room";
			heading = "LIVING ROOM";
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
