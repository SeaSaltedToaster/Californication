package com.seaSaltedToaster.californiaGame.scenes;

import com.seaSaltedToaster.californiaGame.scenes.title.LogoEntity;
import com.seaSaltedToaster.californiaGame.scenes.title.TitleCamera;
import com.seaSaltedToaster.californiaGame.scenes.title.TitleEntity;
import com.seaSaltedToaster.simpleEngine.Engine;
import com.seaSaltedToaster.simpleEngine.Scene;

public class TitleScene extends Scene {

	private LogoEntity logo;
	private TitleEntity title;
	
	@Override
	public void loadScene(Engine engine) {
		this.logo = new LogoEntity(engine);
		engine.addEntity(logo);
		
		this.title = new TitleEntity(engine);
		engine.addEntity(title);
		
		engine.setCamera(new TitleCamera());
	}

	@Override
	public void renderScene(Engine engine) {
		
	}

	@Override
	public void updateScene(Engine engine) {
		this.logo.update();
		this.title.update();
	}

	@Override
	public void unloadScene(Engine engine) {
		
	}

}
