package com.tactfactory.designpatternniveau1.factory.tp1.factory;

import com.tactfactory.designpatternniveau1.factory.tp1.Building;

import java.util.Random;

import com.tactfactory.designpatternniveau1.factory.tp1.*;

public class BuildingCreator implements Creator {

	@Override
	public Building createBuilding() {
		Random rand = new Random();
		int nb = rand.nextInt(7);
		
		Building result = null;

		switch (nb) {
	    case 0:
	      result = new CityHall();
	      break;
	      
	    case 1:
	      result = new FireDepartment();
	      break;
	      
	    case 2:
	      result = new House();
	      break;
	      
	    case 3:
	      result = new Market();
	      break;
	      
	    case 4:
	      result = new PowerPlant();
	      break;
		      
	    case 5:
	      result = new School();
	      break;
		      
	    case 6:
	      result = new WaterTower();
	      break;

	    default:
	      result = null;
	      break;
	    }
		
		return result;
	}

	@Override
	public Building createBuilding(String name) {
		Building result = null;

	    switch (name) {
	    case "CityHall":
	      result = new CityHall();
	      break;
	      
	    case "FireDepartment":
	      result = new FireDepartment();
	      break;
	      
	    case "House":
	      result = new House();
	      break;
	      
	    case "Market":
	      result = new Market();
	      break;
	      
	    case "PowerPlant":
	      result = new PowerPlant();
	      break;
		      
	    case "School":
	      result = new School();
	      break;
		      
	    case "WaterTower":
	      result = new WaterTower();
	      break;

	    default:
	      result = null;
	      break;
	    }

	    return result;
	}

}
