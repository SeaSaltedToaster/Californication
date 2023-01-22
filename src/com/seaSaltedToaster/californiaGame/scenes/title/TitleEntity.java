package com.seaSaltedToaster.californiaGame.scenes.title;

import com.seaSaltedToaster.simpleEngine.Engine;
import com.seaSaltedToaster.simpleEngine.entity.Entity;
import com.seaSaltedToaster.simpleEngine.entity.componentArchitecture.ModelComponent;
import com.seaSaltedToaster.simpleEngine.models.Vao;
import com.seaSaltedToaster.simpleEngine.utilities.Vector3f;

public class TitleEntity extends Entity {

	public TitleEntity(Engine engine) {
		Vao vao = engine.getObjLoader().loadObjModel("rhcpText");
		this.addComponent(new ModelComponent(vao));
		this.getTransform().setScale(1.05f);
		
		this.setPosition(new Vector3f(0.0f, 0.0f, 1.0f));
		this.getTransform().getRotation().setZ(90);
	}
	
	public void update() {
		this.getTransform().getRotation().z += -10.0f;
	}
	
}
