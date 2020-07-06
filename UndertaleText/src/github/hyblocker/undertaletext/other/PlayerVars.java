package github.hyblocker.undertaletext.other;

import github.hyblocker.undertaletext.fights.DefenceItem;
import github.hyblocker.undertaletext.fights.WeaponItem;
import github.hyblocker.undertaletext.objects.Item;

public class PlayerVars {
	public int MaxHP = 20;
	public int CurrentHP=MaxHP;
	public int roomId=0;
	public String charName="";
	public int menuId=0;
	public boolean door1=false,door2=false,door3=false,door4=false;
	
	public int floweyState=0;
	/*
	 * 0=never did anyhting previously
	 * 1=met flowey (its rude etc.)
	 * 2=genocide txt (do wot u must)
	 * 3=noFlowey
	 */
	public int EXP=0;
	public int ATK=1;
	public int DEF=1;
	/*
	 * 0: DEF; 1: ATK; 2-9: ITM;
	 */
	public Item[] inventory = new Item[10];
	//0=DEF
	//1=ATK
	//2=ITM0 ETC.
	public int killCount=0,murderLevel=0;
	public int prevPie=0; //previous pie value cuz dialog
	public int Pie=0; //0=idk //1=bscoth //2=cinnamon
	public float TimePlayed=0;
	public int saveId = 0; //checkpoints and crap
	
	
	public int plot = 0;
	/*
	 * 0=started game
	 * 1=metFlowey flowey
	 * 2=1st puzzle
	 * 3=2nd puzzle (room3)
	 * 4=dummy
	 * 5=torielRanAway
	 * 6=preCandyRoom
	 * 7=atCheeseSave
	 * 8=AtTorHouse
	 * 9=PostTorHouse
	 * 10=Post2ndFloweyEcounter
	 */
	
	public int dummyState=0;
	/*
	 * 0=normal
	 * 1=spared
	 * 2=killed
	 * 3=used (still there)
	 */
	
	public PlayerVars() {
		
	}
}
