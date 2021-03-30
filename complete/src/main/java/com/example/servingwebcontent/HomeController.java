package com.example.servingwebcontent;

import hibernate.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

	// Main controller for the methods
	@GetMapping("/getAllDrinkersNamesAndID.json")
	public @ResponseBody Map<String, Integer> getAllDrinkersAndID(){
		DrinkerMethods drinkerMethods = new DrinkerMethods();
		return drinkerMethods.getAllDrinkersAndID();
	}

	@GetMapping("/getAllDrinkersNames.json")
	public @ResponseBody List<Drinkers> getAllDrinkers(){
		DrinkerMethods drinkerMethods = new DrinkerMethods();
		return drinkerMethods.getDrinkers();
	}

	@GetMapping("/getBeersOfDrinkers.json")
	public @ResponseBody Map<String, Integer> getBeersOfDrinkers(){
		BeerMethods beerMethods = new BeerMethods();
		return beerMethods.getNumberOfBeersEachDrinker();
	}

	@GetMapping("/getAllPoolGames.json")
	public @ResponseBody List<PoolGames> getAllPoolGames(){
		PoolGameMethods poolGameMethods = new PoolGameMethods();
		return poolGameMethods.getPoolGames();
	}

	@PostMapping("/addDrinker.json")
	public @ResponseBody boolean addDrinker(@RequestParam(name = "firstName") String firstName,
											@RequestParam(name = "lastName") String lastName) {
		DrinkerMethods drinkerMethods = new DrinkerMethods();
		return drinkerMethods.addDrinker(firstName, lastName);
	}

	@PostMapping("/addBeer.json")
	public @ResponseBody boolean addBeer(@RequestParam(name = "userId") int userId) {
		BeerMethods beerMethods = new BeerMethods();
		return beerMethods.addBeer(userId);
	}

	@PostMapping("/addPoolGame.json")
	public @ResponseBody boolean addPoolGame(@RequestParam(name = "shooterOne") int shooterOne,
											 @RequestParam(name = "shooterTwo") int shooterTwo,
											 @RequestParam(name = "winner") int winner) {
		PoolGameMethods poolGameMethods = new PoolGameMethods();
		return poolGameMethods.addPoolGame(shooterOne, shooterTwo, winner);
	}

}
