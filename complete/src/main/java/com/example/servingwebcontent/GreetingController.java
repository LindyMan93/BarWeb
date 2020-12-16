package com.example.servingwebcontent;

import hibernate.BeerMethods;
import hibernate.DrinkerMethods;
import hibernate.PoolGameMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false) String name,
						   @RequestParam(name= "lName", required=false) String lname,
						   @RequestParam(name= "id", required=false) int id, Model model) {
		DrinkerMethods drinker = new DrinkerMethods();
		BeerMethods beer = new BeerMethods();
		PoolGameMethods game = new PoolGameMethods();
		if (id == 1) {
			drinker.addDrinker("Test","Last");
			beer.addBeer(1);
			game.addPoolGame(1,2, 1);
		} else {
			game.removeGameById(id);
			beer.removeBeerById(id);
			drinker.removeDrinkerByID(id);
		}
		model.addAttribute("name", "adding");
		return "greeting";
	}

}
