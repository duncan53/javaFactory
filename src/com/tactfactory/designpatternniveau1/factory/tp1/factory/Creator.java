package com.tactfactory.designpatternniveau1.factory.tp1.factory;

import com.tactfactory.designpatternniveau1.factory.tp1.Building;

public interface Creator {
	
	Building createBuilding();
	
	Building createBuilding(String name);
	
}
