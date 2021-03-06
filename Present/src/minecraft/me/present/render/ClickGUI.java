package me.present.render;

import javax.vecmath.Color4b;

import org.lwjgl.input.Keyboard;

import me.present.modules.Module;
import me.present.modules.Module.Category;
import me.present.settings.BooleanSetting;
import me.present.settings.ModeSetting;
import me.present.ui.ClickGui;
import me.present.ui.ClickGuiRainbow;

public class ClickGUI extends Module {
	
	public BooleanSetting Rainbow = new BooleanSetting("Rainbow", false);
	
	public ClickGUI() {
		super("ClickGui", Keyboard.KEY_RSHIFT, Category.RENDER);
		this.addSettings(Rainbow);
	}
	
	public void onEnable() {

		if(Rainbow.isEnabled()) {
			mc.displayGuiScreen(new ClickGuiRainbow());
			toggle();
		}else {
			mc.displayGuiScreen(new ClickGui());
			toggle();
		}
	}
	
}
