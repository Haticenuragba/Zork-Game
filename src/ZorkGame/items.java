package ZorkGame;

public class items {
	public String nameOfItem;
	public String descriptionOfItem;
	public boolean canBeTaken;
	public boolean canBeOpened;
	public boolean canBeUsed;
	public boolean isOpen;
	public boolean isUnlocked;
	

	public items(String n, String d, boolean portable, boolean openable, boolean usable, boolean unlocked, boolean opened) {
		nameOfItem = n;
		descriptionOfItem = d;
		canBeTaken = portable;
		canBeOpened = openable;
		canBeUsed = usable;
		isUnlocked = unlocked;
		isOpen = opened;
	}
	

}
