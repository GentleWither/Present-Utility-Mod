package me.present.render;

import org.lwjgl.input.Keyboard;

import me.present.events.Event;
import me.present.listeners.EventKey;
import me.present.listeners.EventRenderGUI;
import me.present.listeners.EventUpdate;
import me.present.modules.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class TabGUI extends Module {
	
	public int currentTab;
	
	public TabGUI() {
		super("TabGUI", Keyboard.KEY_NONE, Category.RENDER);
		toggled = true;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
			FontRenderer fr = mc.fontRendererObj;
		
			Gui.drawRect(2, 11, 53, 72, 0x98700000);
			Gui.drawRect(3, 14 + currentTab * 15 - 1, 52, 14 + currentTab * 15 + 11, -0x8B0000);
			
			int count = 0;
			for(Category c : Module.Category.values()) {
				fr.drawStringWithShadow(c.name, 5, 15 + count*15, -1);
			
				count++;
				
			}
		}
		if(e instanceof EventKey) {
			int code = ((EventKey)e).code;
			
			if(code == Keyboard.KEY_UP) {
				if(currentTab <= 0) {
					currentTab = Module.Category.values().length - 1;
			}else
				currentTab--;
			}
			
			if(code == Keyboard.KEY_DOWN) {
				if(currentTab >= Module.Category.values().length - 1) {
					currentTab = 0;
				}else
					currentTab++;
			}
		}
	}
}





