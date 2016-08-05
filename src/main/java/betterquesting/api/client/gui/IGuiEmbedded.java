package betterquesting.api.client.gui;

/**
 * Used for nested GUI panels
 */
public interface IGuiEmbedded
{
	public void drawBackground(int mx, int my, float partialTick);
	public void drawForeground(int mx, int my, float partialTick);
	
	/**
	 * Called when an edit has been made
	 */
	public void refresh();
	
	public void onMouseClick(int mx, int my, int click);
	public void onMouseScroll(int mx, int my, int scroll);
	public void onKeyTyped(char c, int keyCode);
}