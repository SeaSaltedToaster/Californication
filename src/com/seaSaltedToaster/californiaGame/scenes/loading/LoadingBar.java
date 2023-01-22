package com.seaSaltedToaster.californiaGame.scenes.loading;

import org.lwjgl.glfw.GLFW;

import com.seaSaltedToaster.simpleEngine.Engine;
import com.seaSaltedToaster.simpleEngine.uis.UiComponent;

public class LoadingBar extends UiComponent {
	
	private float dist = 0;
	
	public LoadingBar(Engine engine) {
		super(0);
		createBody(engine);
	}
	
	@Override
	public void updateSelf() {
		this.dist = (float) (GLFW.glfwGetTime() / 2.5f) - 0.33f;
		this.setClippingBounds(0, 0, dist, 1000);
	}

	private void createBody(Engine engine) {
		float scale = 1.0f;
		this.setScale(scale, scale);
		
		int bgIc = engine.getTextureLoader().loadTexture("/ui/LoadingBar");
		this.setTexture(bgIc);
	}

	public float getDist() {
		return dist;
	}

}
