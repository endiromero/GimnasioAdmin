package com.ice1155.DA;

public class ObjectItem {
	private int itemId;
	private String itemName;
	
	public ObjectItem(int itemId, String itemName) {
		this.itemId = itemId;
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}	
}
