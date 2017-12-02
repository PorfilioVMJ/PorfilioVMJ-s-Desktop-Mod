package net.vmjforums.computer;

public class Reference {
	public static final String modid = "vmjcm";
	public static final String name = "VMJ's ComputerMod";
	public static final String version = "1.0 ALPHA";
	public static final String accepted_versions = "[1.11.2]";
	
	public static final String CLIENT_PROXY = "net.vmjforums.computer.proxy.ClientProxy";
	public static final String SERVER_PROXY = "net.vmjforums.computer.proxy.ServerProxy";
	
	public static enum ComputerItems{
		RAM("ram", "itemram"), 
		CPU("cpu", "itemcpu"),
		BOARD("board", "itemboard");
		
		private String unlocalizedName;
		private String registryName;
		
		 ComputerItems(String unlocalizedName, String registryName){
			 this.unlocalizedName = unlocalizedName;
			 this.registryName = registryName;
		 }
		 public String getUnlocalizedName() {
			return unlocalizedName;
		}
		 public String getRegistryName() {
			return registryName;
		}
	}
	public static enum ComputerBlocks{
		case1("case1", "blockcase1"),
		router("router", "blockrouter"),
		peripherals("peripherals", "peripherals");
		
		private String unlocalizedName;
		private String registryName;
		
		 ComputerBlocks(String unlocalizedName, String registryName){
			 this.unlocalizedName = unlocalizedName;
			 this.registryName = registryName;
		 }
		 public String getUnlocalizedName() {
			return unlocalizedName;
		}
		 public String getRegistryName() {
			return registryName;
		}
	}
}
