package betterquesting.core;

import org.apache.logging.log4j.Logger;
import betterquesting.api.IQuestingAPI;
import betterquesting.api.database.ILifeDatabase;
import betterquesting.api.database.IPartyDatabase;
import betterquesting.api.database.IQuestDatabase;
import betterquesting.api.database.IQuestLineDatabase;
import betterquesting.api.database.IQuestProperties;
import betterquesting.api.network.IPacketSender;
import betterquesting.api.registry.IPacketRegistry;
import betterquesting.api.registry.IQuestIORegistry;
import betterquesting.api.registry.IRewardRegistry;
import betterquesting.api.registry.ITaskRegistry;
import betterquesting.api.registry.IThemeRegistry;
import betterquesting.api.registry.IToolRegistry;
import betterquesting.api.utils.IGuiBuilder;
import betterquesting.api.utils.IMakePlaceholder;
import betterquesting.importers.ImporterRegistry;
import betterquesting.network.PacketSender;
import betterquesting.network.PacketTypeRegistry;
import betterquesting.registry.RewardRegistry;
import betterquesting.registry.TaskRegistry;
import betterquesting.registry.ThemeRegistry;
import betterquesting.registry.ToolboxRegistry;
import betterquesting.utils.MakePlaceholder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class ParentAPI implements IQuestingAPI
{
	public static final ParentAPI API = new ParentAPI();
	
	private ParentAPI()
	{
	}
	
	@Override
	public ITaskRegistry getTaskRegistry()
	{
		return TaskRegistry.INSTANCE;
	}
	
	@Override
	public IRewardRegistry getRewardRegistry()
	{
		return RewardRegistry.INSTANCE;
	}
	
	@Override
	public IPacketRegistry getPacketRegistry()
	{
		return PacketTypeRegistry.INSTANCE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IThemeRegistry getThemeRegistry()
	{
		return ThemeRegistry.INSTANCE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IToolRegistry getToolboxRegistry()
	{
		return ToolboxRegistry.INSTANCE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IQuestIORegistry getIORegistry()
	{
		return ImporterRegistry.INSTANCE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IGuiBuilder getGuiBuilder()
	{
		return null;
	}

	@Override
	public IPacketSender getPacketSender()
	{
		return PacketSender.INSTANCE;
	}

	@Override
	public IMakePlaceholder getPlaceholderMaker()
	{
		return MakePlaceholder.INSTANCE;
	}

	@Override
	public IQuestLineDatabase getQuestLineDB()
	{
		return null;
	}

	@Override
	public IQuestDatabase getQuestDB()
	{
		return null;
	}

	@Override
	public IPartyDatabase getPartyDB()
	{
		return null;
	}

	@Override
	public ILifeDatabase getLifeDB()
	{
		return null;
	}
	
	@Override
	public IQuestProperties getProperties()
	{
		return null;
	}

	@Override
	public Logger getLogger()
	{
		return BetterQuesting.logger;
	}
	
}
