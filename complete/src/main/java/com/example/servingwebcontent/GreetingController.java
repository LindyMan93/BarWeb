package com.example.servingwebcontent;

import hibernate.BeerMethods;
import hibernate.DrinkerMethods;
import hibernate.PoolGameMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GreetingController {

	@GetMapping("/greeting.json")
	public @ResponseBody
	Map<String, Integer> greeting(@RequestParam(name="name", required=false) String name,
			 @RequestParam(name= "lName", required=false) String lname,
			 @RequestParam(name= "id", required=false) int id, Model model) {
		DrinkerMethods drinker = new DrinkerMethods();
		BeerMethods beer = new BeerMethods();
		PoolGameMethods game = new PoolGameMethods();

		return beer.getNumberOfBeersPerDrinker();
	}

}
