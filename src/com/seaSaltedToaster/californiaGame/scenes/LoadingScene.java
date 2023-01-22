package com.seaSaltedToaster.californiaGame.scenes;

import com.seaSaltedToaster.californiaGame.scenes.loading.LoadingMenu;
import com.seaSaltedToaster.simpleEngine.Engine;
import com.seaSaltedToaster.simpleEngine.Scene;

public class LoadingScene extends Scene {

	private LoadingMenu menu;
	
	@Override
	public void loadScene(Engine engine) {
		this.menu = new LoadingMenu(engine);
		this.addComponent(menu.getBackdrop());
	}

	@Override
	public void renderScene(Engine engine) {
		
	}

	@Override
	public void updateScene(Engine engine) {
		this.menu.update();
		if(menu.getBar().getDist() > 1.25f) {
			engine.setCurrentScene(new TitleScene());
		}
	}

	@Override
	public void unloadScene(Engine engine) {
		
	}

}
