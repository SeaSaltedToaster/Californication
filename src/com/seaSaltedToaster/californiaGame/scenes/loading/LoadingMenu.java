package com.seaSaltedToaster.californiaGame.scenes.loading;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.seaSaltedToaster.simpleEngine.Engine;
import com.seaSaltedToaster.simpleEngine.uis.UiComponent;

public class LoadingMenu {

	//Loading Icons
	private int[] icons;
	private float[] iconPass, iconY;
	private int iconCnt = 8;
	
	//Loading Bar
	private LoadingBar bar;

	//Backdrop
	private UiComponent backdrop;
	private List<UiComponent> iconItems;
	
	public LoadingMenu(Engine engine) {
		this.iconItems = new ArrayList<UiComponent>();
		addBackdrop(engine);
		addBar(engine);
	}

	public void update() {
		float dist = bar.getDist();
		System.out.println(dist);
		
		if(iconItems.size() >= iconPass.length) return;
		
		if(iconPass[iconItems.size()] <= dist) { 
			UiComponent comp = new UiComponent(2);
			comp.setScale(1, 1);
			comp.setTexture(icons[iconItems.size()]);
			comp.getPosition().setY(iconY[iconItems.size()]);
			backdrop.addComponent(comp);
			iconItems.add(comp);
		}
	}
	
	private void addBar(Engine engine) {
		this.bar = new LoadingBar(engine);
		this.backdrop.addComponent(bar);
	}

	private void addBackdrop(Engine engine) {
		this.backdrop = new UiComponent(0);
		this.backdrop.setScale(1, 1);
		
		int bgIc = engine.getTextureLoader().loadTexture("/ui/LoadingScreen");
		this.backdrop.setTexture(bgIc);
		
		this.icons = new int[iconCnt];
		for(int i = 1; i <= iconCnt; i++) {
			int icon = engine.getTextureLoader().loadTexture("/ui/icon" + i);
			icons[i-1] = icon;
		}
		
		this.iconPass = new float[]{0.1f, 0.215f, 0.325f, 0.445f, 0.548f, 0.665f, 0.77f, 0.89f};
		this.iconY = new float[]{0.06f, 0.015f, 0.05f, 0.01f, 0.05f, 0.045f, 0.05f, 0.034f};
	}

	public UiComponent getBackdrop() {
		return backdrop;
	}

	public LoadingBar getBar() {
		return bar;
	}
	
}
