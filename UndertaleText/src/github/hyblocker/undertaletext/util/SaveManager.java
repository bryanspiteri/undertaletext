//###################################################################################
/* 
*                             SAVE STRUCTURE
*                                FILE [0]
*  charName     - Frisk
*  maxHP        - 20
*  currHP       - 20
*  EXP          - 0
*  ATK          - 1
*  DEF          - 0
*  menuId       - 0
*  killCount    - 3
*  murderLevel  - 0
*  plot         - 4
*  saveId       - 0
*  pie          - 0
*  prevPie      - 0
*  
*/
//###################################################################################
/*
*                             SAVE STRUCTURE
*                                FILE [1]
*                            (INVENTORY DATA)
*  defenceId    - 0
*  weaponId     - 0
*  inv0         - 1
*  inv1         - 0
*  inv2         - 0
*  inv3         - 0
*  inv4         - 0
*  inv5         - 0
*  inv6         - 0
*  inv7         - 0
*  
*/
//###################################################################################

package github.hyblocker.undertaletext.util;

import java.io.File;

import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.PlayerVars;

public class SaveManager {
	
	public static PlayerVars SAVE = new PlayerVars();
	
	public static String appdata = System.getenv("APPDATA");
	public static String rootDir = appdata + "\\UNDERTALE";
	
	public static File save0 = new File(rootDir+"\\0");
	public static File save1 = new File(rootDir+"\\1");
	public static File ini = new File(rootDir+"\\undertale.ini");
	
	public static void save() {
		SAVE = new PlayerVars();
		if(!FileUtils.Exists(rootDir)) {
			FileUtils.MakeDir(rootDir);
		}
		String[] saveContents0 = {
				Game.plrData.charName,
				Integer.toString(Game.plrData.MaxHP),
				Integer.toString(Game.plrData.CurrentHP),
				Integer.toString(Game.plrData.EXP),
				Integer.toString(Game.plrData.ATK),
				Integer.toString(Game.plrData.DEF),
				Integer.toString(Game.plrData.menuId),
				Integer.toString(Game.plrData.killCount),
				Integer.toString(Game.plrData.murderLevel),
		};
		String[] saveContents1 = {
				Game.plrData.charName,
				Integer.toString(Game.plrData.MaxHP),
				Integer.toString(Game.plrData.CurrentHP),
				Integer.toString(Game.plrData.EXP),
				Integer.toString(Game.plrData.ATK),
				Integer.toString(Game.plrData.DEF),
				Integer.toString(Game.plrData.menuId),
				Integer.toString(Game.plrData.killCount),
				Integer.toString(Game.plrData.murderLevel),
		};
		
		FileUtils.WriteToFile(save0, saveContents0);
	}
	
	public static void loadSave() {
		SAVE = new PlayerVars();
		if(!FileUtils.Exists(rootDir)) {
			FileUtils.MakeDir(rootDir);
		}
		PlayerVars plrdt = new PlayerVars();
		if(FileUtils.Exists(save0) && FileUtils.Exists(save1)) {
			String[] saveData0 = FileUtils.ReadFromFile(save0);
			String[] saveData1 = FileUtils.ReadFromFile(save1);
			try {
				plrdt.charName=saveData0[0];
				plrdt.MaxHP=Integer.parseInt(saveData0[1]);
				plrdt.CurrentHP=Integer.parseInt(saveData0[2]);
				plrdt.EXP=Integer.parseInt(saveData0[3]);
				plrdt.ATK=Integer.parseInt(saveData0[4]);
				plrdt.DEF=Integer.parseInt(saveData0[5]);
				plrdt.menuId=Integer.parseInt(saveData0[6]);
				plrdt.killCount=Integer.parseInt(saveData0[7]);
				plrdt.murderLevel=Integer.parseInt(saveData0[8]);
				plrdt.plot=Integer.parseInt(saveData0[9]);
				plrdt.saveId=Integer.parseInt(saveData0[10]);
				plrdt.Pie=Integer.parseInt(saveData0[11]);
				plrdt.prevPie=Integer.parseInt(saveData0[12]);
				plrdt.inventory[0]=ItemHandler.getItemFromId(saveData1[0],0); //DEF ITEM
				plrdt.inventory[1]=ItemHandler.getItemFromId(saveData1[1],1); //WPN ITEM
				plrdt.inventory[2]=ItemHandler.getItemFromId(saveData1[2],2);
				plrdt.inventory[3]=ItemHandler.getItemFromId(saveData1[3],3);
				plrdt.inventory[4]=ItemHandler.getItemFromId(saveData1[4],4);
				plrdt.inventory[5]=ItemHandler.getItemFromId(saveData1[5],5);
				plrdt.inventory[6]=ItemHandler.getItemFromId(saveData1[6],6);
				plrdt.inventory[7]=ItemHandler.getItemFromId(saveData1[7],7);
				plrdt.inventory[8]=ItemHandler.getItemFromId(saveData1[8],8);
				plrdt.inventory[9]=ItemHandler.getItemFromId(saveData1[9],9);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else {
			Game.plrData=plrdt;
			save();
		}
		Game.plrData=plrdt;
	}
	
	public static void reset() {
		//remember crap
		
		save();
	}
	
	public static void trueReset() {
		Game.plrData = new PlayerVars();
		save();
	}
	
}
