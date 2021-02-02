package com.tactfactory.designpatternniveau1.factory.tp1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.tactfactory.designpatternniveau1.factory.tp1.factory.BuildingCreator;
import com.tactfactory.designpatternniveau1.factory.tp1.factory.Creator;
import com.tactfactory.designpatternniveau1.factory.tp1.utils.ClassUtils;

/**
*
* @author tactfactory
*
* - Modifier le programme pour permettre de créer des Building au travers d'un design pattern "Factory" :
*   - 1 : Il existe 3 façon de créer des Building
*     - 1 : Créer aléatoirement pour toutes les classes du package courant qui implémente "Building", qui possède un
*         constructeur vide, qui sont publiques et qui ne sont pas abstraites
*     - 2 : Créer depuis une chaine de caractère qui représente le "simpleName" de la classe à utiliser qui implémente
*         "Building", qui possède un constructeur vide, qui est publique et qui n'est pas abstraite
*     - 3 : Depuis une classe qui implémente "Building", qui possède un constructeur vide, qui est publique et qui
*         n'est pas abstraite
*   - 2 : Créer deux listes de building dans le point d'entré de l'application
*     - 1 : La première liste doit contenir 20 Building généré aléatoirement
*     - 2 : La deuxième doit contenir au moins une fois chaque classe qui implémente "Building", qui possède un
*         constructeur vide, qui sont publiques et qui ne sont pas abstraites. En utilisant soit les chaine de
*         caractères ou les classes
*/
public class FactoryTp1 {
	
	public static void main(String[] args)
	throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
			
		List<Building> buildings = new ArrayList<>();
		for (Class<?> klazz : ClassUtils.getClasses("com.tactfactory.designpatternniveau1.factory.tp1")) {
			if (klazz.getInterfaces().length > 0 && klazz.getInterfaces()[0].getName().equals(Building.class.getName())) {
				System.out.println(klazz.getName());
				buildings.add((Building) klazz.getConstructor().newInstance());
			}
		}

		randomTown();
		System.out.println("---------------------------");
		manualTown();
	}

	
  private static void manualTown() {
	  Creator creator = new BuildingCreator();
	  
	  List<Building> buildings = new ArrayList<Building>();
	  buildings.add(creator.createBuilding("CityHall"));
	  buildings.add(creator.createBuilding("FireDepartment"));
	  buildings.add(creator.createBuilding("House"));
	  buildings.add(creator.createBuilding("Market"));
	  buildings.add(creator.createBuilding("PowerPlant"));
	  buildings.add(creator.createBuilding("School"));
	  buildings.add(creator.createBuilding("WaterTower"));

	    for (Building building : buildings) {
	      building.doSmt();
	    }
  }

  private static void randomTown() {
	  Creator creator = new BuildingCreator();
	  
	  List<Building> buildings = new ArrayList<Building>();
	  for (int i = 0; i < 20; i++) {
		  buildings.add(creator.createBuilding());
	  }
	  
	  for (Building building : buildings) {
	      building.doSmt();
	    }
  }

}
