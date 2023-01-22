package com.seaSaltedToaster.californiaGame.scenes.title;

import com.seaSaltedToaster.simpleEngine.entity.Camera;
import com.seaSaltedToaster.simpleEngine.renderer.Window;
import com.seaSaltedToaster.simpleEngine.utilities.SmoothFloat;
import com.seaSaltedToaster.simpleEngine.utilities.Vector3f;

public class TitleCamera extends Camera {
	
	private SmoothFloat panUp;
	
	public TitleCamera() {
		this.setPosition(new Vector3f(0,0,17.5f));
		this.setPitch(90.0f);
		
		this.panUp = new SmoothFloat(getPitch());
		this.panUp.setTarget(0.0f);
		this.panUp.setValue(360.0f);
		this.panUp.setAmountPer(0.05f);
	}
	
	@Override
	public void update() {
		this.panUp.update(Window.DeltaTime);
		
		if(panUp.getValue() < 90.0f)
			this.setPitch(panUp.getValue());
	}

}
