package Lab01_Simsek;

public class MenuItem {
	private String itemName;
	private String itemDescription;
	private int ingredients;
	private int itemCalories;
	private double itemCost;
	
	public MenuItem(String name,String description,  int ing, int calories, double cost) {
		itemName = name;	
		itemDescription = description;
		ingredients = ing;
		setItemCalories(calories);
		setItemCost(cost);
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String description) {
		itemDescription = description;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String name) {
		itemName = name;
	}

	public int getIngredients() {
		return ingredients;
	}

	public void setIngredients(int ing) {
		ingredients = ing;
	}

	public int getItemCalories() {
		return itemCalories;
	}

	public void setItemCalories(int calories) {
		if(calories > 0)
			itemCalories = calories;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double cost) {
		if(cost > 0)
			itemCost = cost;
	}

	public String toString() {
		return "\n\tMenuItem [itemDescription=" + itemDescription + ", itemName=" + itemName + ", calories=" + itemCalories + ", ingredients="
				+ ingredients + ", itemCalories=" + itemCalories + ", itemCost=" + itemCost + "]\n";
	}
	
}
