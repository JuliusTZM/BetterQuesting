package betterquesting.client.themes;

import java.awt.Color;
import net.minecraft.util.ResourceLocation;
import betterquesting.api.client.themes.IThemeBase;
import betterquesting.api.client.themes.IThemeLoader;
import betterquesting.api.utils.JsonHelper;
import betterquesting.core.BetterQuesting;
import betterquesting.registry.ThemeRegistry;
import com.google.gson.JsonObject;

public class ThemeLoaderStandard implements IThemeLoader
{
	private final ResourceLocation ID = new ResourceLocation(BetterQuesting.MODID + ":standard");
	
	@Override
	public ResourceLocation getLoaderID()
	{
		return ID;
	}
	
	@Override
	public IThemeBase loadTheme(JsonObject json, String domain)
	{
		if(json == null)
		{
			return null;
		}
		
		String name = JsonHelper.GetString(json, "name", "Unnamed Theme");
		String texture = JsonHelper.GetString(json, "texture", "betterquesting:textures/gui/editor_gui.png");
		
		int tColor = JsonHelper.GetNumber(json, "textColor", Color.BLACK.getRGB()).intValue();
		String btnSound = JsonHelper.GetString(json, "buttonSound", "minecraft:gui.button.press");
		
		JsonObject jl = JsonHelper.GetObject(json, "lineColor");
		int lLocked = JsonHelper.GetNumber(jl, "locked", new Color(0.75F, 0F, 0F).getRGB()).intValue();
		int lPending = JsonHelper.GetNumber(jl, "pending", Color.YELLOW.getRGB()).intValue();
		int lComplete = JsonHelper.GetNumber(jl, "complete", Color.GREEN.getRGB()).intValue();
		
		JsonObject ji = JsonHelper.GetObject(json, "iconColor");
		int iLocked = JsonHelper.GetNumber(ji, "locked", Color.GRAY.getRGB()).intValue();
		int iPending = JsonHelper.GetNumber(ji, "pending", new Color(0.75F, 0F, 0F).getRGB()).intValue();
		int iUnclaimed = JsonHelper.GetNumber(ji, "unclaimed", new Color(0F, 1F, 1F).getRGB()).intValue();
		int iComplete = JsonHelper.GetNumber(ji, "complete", Color.GREEN.getRGB()).intValue();
		
    	String id = name.toLowerCase().trim().replaceAll(" ", "_");
    	ResourceLocation regName = new ResourceLocation(domain + ":" + id);
    	
		if(ThemeRegistry.INSTANCE.getTheme(regName) != null)
    	{
    		int i = 2;
        	regName = new ResourceLocation(domain + ":" + id + "_" + i);
    		
        	while(ThemeRegistry.INSTANCE.getTheme(regName) != null)
        	{
        		i++;
            	regName = new ResourceLocation(domain + ":" + id + "_" + i);
        	}
    	}
		
		ThemeStandard theme = new ThemeStandard(name, new ResourceLocation(texture), regName);
		theme.setTextColor(tColor);
		theme.setButtonSound(new ResourceLocation(btnSound));
		theme.setLineColors(lLocked, lPending, lComplete);
		theme.setIconColors(iLocked, iPending, iUnclaimed, iComplete);
		
		return theme;
	}
}
