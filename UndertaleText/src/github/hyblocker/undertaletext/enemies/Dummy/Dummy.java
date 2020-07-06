package github.hyblocker.undertaletext.enemies.Dummy;

import github.hyblocker.undertaletext.fights.Fight;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.other.GameRenderer;
import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Dialog;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class Dummy extends Fight {
	
	public String BLACK = "¼";
	public String BLACK_LINE = new Fight().BLACK_LINE;
	public Player thisPlayer;
	
	public Vector2 plrROOMpos;
	public int Room = 0;

	public String[] border = {
		"υ", //TopLeft
		"φ", //TopCenter
		"χ", //TopRight
		"ψ", //MiddleLeft
		"ω", //MiddleRight
		"ʹ", //BottomLeft
		"͵", //BottomCenter
		"ͺ", //BottomRight
	};
	
	//are we in the menu (fight, act, item, mercy)?
	public boolean isInMenu = true;
	public boolean isInSubmenu = false;
	
	public int currOption = 0;
	/*
	 * 0 = none
	 * 1 = fight
	 * 2 = act
	 * 3 = item
	 * 4 = mercy
	 */
	
	public String dlg="* hoiVs!&  O.O&  ???";
	
	public String[] soulLocations = {
		"Α",
		"Β",
		"Γ",
		"Δ",
		"Ε",
		"Ζ",
		"Η",
		"Θ",
		"Ι"
	};
	
	public String[] ButtonsTop = {
		"ΝΟΠΡ", //FIGHT
		"αηθι", //ACT
		"ΦΨΩβ", //ITEM
		"νοπρ", //MERCY
		"ΛΟΠΡ", //FIGHT SELECTED
		"Ληθι", //ACT   SELECTED
		"ΛΨΩβ", //ITEM  SELECTED
		"Λοπρ", //MERCY SELECTED
	};
	public String[] ButtonsBottom = {
		"ΞΣΤΥ", //FIGHT
		"ζκλμ", //ACT
		"Χγδε", //ITEM
		"ξςστ", //MERCY
		"ΜΣΤΥ", //FIGHT SELECTED
		"Μκλμ", //ACT   SELECTED
		"Μγδε", //ITEM  SELECTED
		"Μςστ", //MERCY SELECTED
	};
	
	public Vector2 pos = Vector2.zero;
	public FineTunedPosition loc = FineTunedPosition.CenterMiddle;
	
	public Dummy(Player thisPlayer){
		super();
		this.thisPlayer=thisPlayer;
	}
	
	public void Draw(){
		String[] BLACKSCREEN = {
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
		};
		String CURROPTIONUP = BLACK_LINE;
		String CURROPTIONDOWN = BLACK_LINE;
		String[] fight,act,item,mercy;
		fight=getFIGHT().clone();
		act=getACT().clone();
		item=getITEM().clone();
		mercy=getMERCY().clone();
		CURROPTIONUP=fight[0]+act[0]+item[0]+mercy[0];
		CURROPTIONDOWN=fight[1]+act[1]+item[1]+mercy[1];
		BLACKSCREEN[BLACKSCREEN.length-2]=CURROPTIONUP;
		BLACKSCREEN[BLACKSCREEN.length-1]=CURROPTIONDOWN;
		if(isInMenu) {
			String[] dialog = getDialog(dlg);
			BLACKSCREEN[BLACKSCREEN.length-7]=dialog[0];
			BLACKSCREEN[BLACKSCREEN.length-6]=dialog[1];
			BLACKSCREEN[BLACKSCREEN.length-5]=dialog[2];
			BLACKSCREEN[BLACKSCREEN.length-4]=dialog[3];
			BLACKSCREEN[BLACKSCREEN.length-3]=dialog[4];
		}
		for(int y=0;y<BLACKSCREEN.length;y++) {
			//System.out.println(BLACKSCREEN[y]);
		}
		GameRenderer.Draw(BLACKSCREEN);
	}
	
	@Override
	public void OnTick() {
		//System.out.println("");
		if(isInMenu) {
			if(isInSubmenu==false) {
				//ONLY IF WE AREN'T IN A SUBMENU
				if(Input.GetKey(KeyCode.Left)) {
					currOption--;
					Audio.PlayOneShot("snd_select");
				}
				if(Input.GetKey(KeyCode.Right)) {
					currOption++;
					Audio.PlayOneShot("snd_select");
				}
			}
			if(currOption<=0) {
				currOption=4;
			}
			if(currOption>4) {
				currOption=1;
			}
			//if we select
			if(Input.GetKey(KeyCode.Z)||Input.GetKey(KeyCode.Enter)) {
				if(isInSubmenu==false) {
					isInSubmenu=true;
				}
			}
			if(Input.GetKey(KeyCode.X)||Input.GetKey(KeyCode.LeftShift)||Input.GetKey(KeyCode.RightShift)) {
				if(isInSubmenu==true) {
					isInSubmenu=false;
				}
			}
		}else {
			currOption=0;
		}
		Draw();
	}
	
	public String[] getDialog(String dialog) {
		String sampleLine = border[3]+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+border[4];
		String[] dialogOUT = {
			//¼¼¼¼¼¼¼¼¼¼¼¼¼¼
			border[0]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[1]+border[2],
			sampleLine,
			sampleLine,
			sampleLine,
			border[5]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[6]+border[7],
		};
		char[] ltrs = dialog.toCharArray();
		int y=0,pIndx=0;
		String tmp="";
		for(int indx=0;indx<dialog.length();indx++) {
			if(ltrs[indx]==' ') {
				ltrs[indx]=BLACK.toCharArray()[0];
			}
			if((indx-1)>=0) {
				if(ltrs[indx]=='&' && ltrs[indx-1]!='\\') {
					y++;
					String BLACKTMP="¼¼¼¼¼¼¼¼¼¼¼¼¼¼";
					int l = tmp.toCharArray().length;
					if(l<0) {
						tmp=tmp.substring(0, l)+BLACKTMP.substring(l);
					}else {
						tmp+=BLACK;
					}
					System.out.println(tmp);
					pIndx=indx;
					dialogOUT[y+1]=border[3]+tmp;
					continue;
				}
			}

			tmp+=ltrs[indx];
		}
		if(dialogOUT[1].length()<15) {
			dialogOUT[1]=(dialogOUT[1]+sampleLine.substring(dialogOUT[1].length())).substring(0,15)+border[4];
		}
		if(dialogOUT[1].length()>16) {
			dialogOUT[1]=dialogOUT[1].substring(0, 15)+border[4];
		}
		if(dialogOUT[2].length()<15) {
			dialogOUT[2]=(dialogOUT[2]+sampleLine.substring(dialogOUT[2].length())).substring(0,15)+border[4];
		}
		if(dialogOUT[2].length()>16) {
			dialogOUT[2]=dialogOUT[2].substring(0, 15)+border[4];
		}
		if(dialogOUT[3].length()<15) {
			dialogOUT[3]=(dialogOUT[3]+sampleLine.substring(dialogOUT[3].length())).substring(0,15)+border[4];
		}
		if(dialogOUT[3].length()>16) {
			dialogOUT[3]=dialogOUT[3].substring(0, 15)+border[4];
		}
		return dialogOUT;
	}
	
	public String[] getFIGHT() {
		//ͻͼ
		String[] fight = {
			BLACK+BLACK+BLACK+BLACK+BLACK,
			BLACK+BLACK+BLACK+BLACK+BLACK,
		};
		
		if(currOption == 1) {
			fight[0]=ButtonsTop[4];
			fight[1]=ButtonsBottom[4];
			if(isInSubmenu) {
				fight[0]="ͻ"+ButtonsTop[4].substring(1);
				fight[1]="ͼ"+ButtonsBottom[4].substring(1);
			}
		}else {
			fight[0]=ButtonsTop[0];
			fight[1]=ButtonsBottom[0];
		}
		return fight;
	}
	public String[] getACT() {
		String[] act = {
			BLACK+BLACK+BLACK+BLACK+BLACK,
			BLACK+BLACK+BLACK+BLACK+BLACK,
		};
		
		if(currOption == 2) {
			act[0]=ButtonsTop[5];
			act[1]=ButtonsBottom[5];
			if(isInSubmenu) {
				act[0]="ͻ"+ButtonsTop[5].substring(1);
				act[1]="ͼ"+ButtonsBottom[5].substring(1);
			}
		}else {
			act[0]=ButtonsTop[1];
			act[1]=ButtonsBottom[1];
		}
		return act;
	}
	public String[] getITEM() {
		String[] item = {
			BLACK+BLACK+BLACK+BLACK+BLACK,
			BLACK+BLACK+BLACK+BLACK+BLACK,
		};
		
		if(currOption == 3) {
			item[0]=ButtonsTop[6];
			item[1]=ButtonsBottom[6];
			if(isInSubmenu) {
				item[0]="ͻ"+ButtonsTop[6].substring(1);
				item[1]="ͼ"+ButtonsBottom[6].substring(1);
			}
		}else {
			item[0]=ButtonsTop[2];
			item[1]=ButtonsBottom[2];
		}
		return item;
	}
	public String[] getMERCY() {
		String[] mercy = {
			BLACK+BLACK+BLACK+BLACK+BLACK,
			BLACK+BLACK+BLACK+BLACK+BLACK,
		};
		
		if(currOption == 4) {
			mercy[0]=ButtonsTop[7];
			mercy[1]=ButtonsBottom[7];
			if(isInSubmenu) {
				mercy[0]="ͻ"+ButtonsTop[7].substring(1);
				mercy[1]="ͼ"+ButtonsBottom[7].substring(1);
			}
		}else {
			mercy[0]=ButtonsTop[3];
			mercy[1]=ButtonsBottom[3];
		}
		return mercy;
	}
}
