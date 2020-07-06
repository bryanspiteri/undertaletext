package github.hyblocker.undertaletext.util;

import github.hyblocker.undertaletext.items.NoItem;
import github.hyblocker.undertaletext.objects.Item;

public class ItemHandler {

	public static Item[] items = {

	};

	public static NoItem getNullItem(int slot) {
		return new NoItem(slot);
	}

	public static Item getItemFromId(int id, int arrayPos) {
		if (id == 0) {
			return new NoItem(arrayPos);
		}
		for (Item itm : items) {
			if (itm.getID() == id) {
				return itm;
			}
		}
		return new NoItem(arrayPos);
	}

	public static Item getItemFromId(String id, int arrayPos) {
		try {
			return getItemFromId(Integer.parseInt(id), arrayPos);
		} catch (Exception ex) {
			System.err.println("Error: argument \"" + id + "\" isn't a valid integer. Returning NoItem at slot ["
					+ arrayPos + "]");
		}
		return new NoItem(arrayPos);
	}
}
