package com.seaSaltedToaster.simpleEngine.entity;

import com.seaSaltedToaster.simpleEngine.utilities.Vector3f;

public class Camera {

	protected Vector3f position;
	protected float yaw, pitch, roll;
	
	public Camera() {
		this.position = new Vector3f(0,0,0);
		this.yaw = 0;
		this.pitch = 0;
		this.roll = 0;
	}
	
	public void update() {
		
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public float getRoll() {
		return roll;
	}

	public void setRoll(float roll) {
		this.roll = roll;
	}
	
}
