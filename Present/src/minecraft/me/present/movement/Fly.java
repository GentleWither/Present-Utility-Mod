package me.present.movement;

import org.lwjgl.input.Keyboard;

import me.present.events.Event;
import me.present.listeners.EventUpdate;
import me.present.modules.Module;

public class Fly extends Module {
	
	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT);
	}
	
	public void onDisable() {
		mc.player.capabilities.isFlying = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.player.capabilities.isFlying = true;
				
			}
		}
	}

}
