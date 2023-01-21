package com.seaSaltedToaster.simpleEngine;

import com.seaSaltedToaster.simpleEngine.audio.management.AudioMaster;
import com.seaSaltedToaster.simpleEngine.entity.Camera;
import com.seaSaltedToaster.simpleEngine.utilities.ScreenshotUtils;

public class Application {
	
	public static boolean quitApp = false;

	public static void main(String[] args) {
		Engine engine = new Engine("Restaurant Game", 1920, 1080);
		engine.setCamera(new Camera());
		engine.getKeyboard().addKeyListener(new ScreenshotUtils());
		
		//Set the new scene
		engine.setCurrentScene(menu);
		
		//Update per frame
		while(!engine.getWindow().shouldClose()) {	
			//Prepare new frame
			engine.prepareFrame();
			
			//Shadow map pass
			engine.startPostProcess();
			
			//Render Normal Pass
			engine.renderScene();
			engine.render();
			
			//Post processing
			engine.postProcess();
			
			//Render Uis on top
			engine.updateScene();
			engine.renderUis();
			engine.update();
			//Check if we closed
			
			engine.getShadowRenderer().clear();
			
			if(quitApp)
				break;
		}
		
		AudioMaster.cleanUp();
		
		engine.getCurrentScene().unloadScene(engine);
		
		engine.getWindow().closeWindow();
	}

}
