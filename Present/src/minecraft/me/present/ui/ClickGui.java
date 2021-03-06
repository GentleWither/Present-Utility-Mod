package me.present.ui;

import java.awt.Color;
import java.io.IOException;

import me.present.Present;
import me.present.modules.Module;
import me.present.modules.Module.Category;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen {
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		float hue = (System.currentTimeMillis() % 2000) / 2000f;
		int color = Color.HSBtoRGB(hue, 1, 1);
				
		int primaryColor = color;
		
		drawDefaultBackground();
		drawRect(130, 2, 215, 14, 0x80000000); //0x30ffffff
		drawRect(130, 2, 215, 14, 0x80000000);
		mc.fontRendererObj.drawStringWithShadow("Combat", 156, 4, 0xffffffff); //0xffffffff
		drawRect(230, 2, 315, 14, 0x80000000);
		drawRect(230, 2, 315, 14, 0x80000000);
		mc.fontRendererObj.drawStringWithShadow("Movement", 250, 4, 0xffffffff);
		drawRect(330, 2, 415, 14, 0x80000000);
		drawRect(330, 2, 415, 14, 0x80000000);
		mc.fontRendererObj.drawStringWithShadow("Render", 354, 4, 0xffffffff);
		drawRect(430, 2, 515, 14, 0x80000000);
		drawRect(430, 2, 515, 14, 0x80000000);
		mc.fontRendererObj.drawStringWithShadow("Player", 455, 4, 0xffffffff);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public int placeForHackY(Module m) {
		
		if(m.category.equals(Category.COMBAT)) return Category.placeInListCombat(m) * 14;
		if(m.category.equals(Category.MOVEMENT)) return Category.placeInListMovement(m) * 14;
		if(m.category.equals(Category.RENDER)) return Category.placeInListRender(m) * 14;
		if(m.category.equals(Category.PLAYER)) return Category.placeInListPlayer(m) * 14;
		
		return 0;
	}
	
	public int placeForHackX(Module m) {
		
		if(m.category.equals(Category.COMBAT)) return 130;
		if(m.category.equals(Category.MOVEMENT)) return 230;
		if(m.category.equals(Category.RENDER)) return 330;
		if(m.category.equals(Category.PLAYER)) return 430;
		
		return 0;
	}
	
	@Override
	public void initGui() {
		for(int i = 1; i < Present.modules.size(); i++) {
			Module m = Present.modules.get(i);
			if(!m.name.equals("Sildurs"))
			buttonList.add(new GuiButton(i, placeForHackX(m), placeForHackY(m), 85, 14, m.name));
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		for(int i = 1; i < Present.modules.size(); i++) {
			if(button.id == i) {
				Present.modules.get(i).toggle();
			}
		}
	}
	
}
