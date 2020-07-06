package github.hyblocker.undertaletext.rooms.special;

import java.awt.Toolkit;

import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.GameRenderer;
import github.hyblocker.undertaletext.util.Vector2;

public class GraphicsTest extends Room{
	
	//ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßáàâãäåæçèéêëìíîïðñòóôõõöøùúûüýþÿḀḁḂḃḄḅḆḇḈḉḊḋḌḍḎḏḐḑḒḓḔḕḖḗḘḙḚḛḜḜḝḞḟḠḡḢḣḤƠơƢƣƤƥ ĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵ ΑΒΓΔΕΖΗΘΙ ƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠ
	
	public static String[] TEST = {
		"ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßáàâãäåæçèéêëƦ",
		"ìíîïðñòóôõõöøùúûüýþÿḀḁḂḃḄḅḆḇḈḉḊḋḌḍḎḏḐḑḒḓḔḕḖḗƧ",
		"ḘḙḚḛḜḜḝḞḟḠḡḢḣḤƠơƢƣƤƥ¼ĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĜĝ",
		"ĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵ¼ΑΒΓΔΕΖΗΘΙ¼ƀƁƂƃƄƅƆƇƈƉ",
		"ƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋ",
		"ŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"0123456789[]{}\\:\";\'<>?,./!@#$%^&*()-=_+`~¼¼¼¼",
		"ABCDEFGHIJKLMNOPQRSTUVWXYZ ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"abcdefghijklmnopqrstuvwxyz ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼"
			
	};

	public GraphicsTest(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}
	
	@Override
	public String[] GetGraphics() {
		return TEST.clone();
	}
	
	@Override
	public String[] GetColliders() {
		return TEST.clone();
	}
	
	@Override
	public void BeginRoom(Vector2 inPos){
		Game._inst._windinst.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-32);
	}
	
	@Override
	public void OnTick() {
		if(Game._inst._currRoom==this) {
			GameRenderer.Draw(TEST);
		}
	}
}
