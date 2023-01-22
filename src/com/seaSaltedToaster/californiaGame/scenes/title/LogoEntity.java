package com.seaSaltedToaster.californiaGame.scenes.title;

import com.seaSaltedToaster.simpleEngine.Engine;
import com.seaSaltedToaster.simpleEngine.entity.Entity;
import com.seaSaltedToaster.simpleEngine.entity.componentArchitecture.ModelComponent;
import com.seaSaltedToaster.simpleEngine.models.Vao;
import com.seaSaltedToaster.simpleEngine.utilities.Vector3f;

public class LogoEntity extends Entity {

	public LogoEntity(Engine engine) {
		Vao vao = engine.getObjLoader().loadObjModel("rhcpLogo");
		this.addComponent(new ModelComponent(vao));
		
		this.setPosition(new Vector3f(0.0f, 0.0f, 0.0f));
		this.getTransform().getRotation().setZ(90);
	}
	
	public void update() {
		this.getTransform().getRotation().y += 100.0f;
	}
	
}
