package ZorkGame;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static final String[] PossibleVerbs = { "open", "close", "examine", "take", "use", "move", "inventory" };
	// name, description, portatable, openable, usable, unlocked, opened

	static room currentRoom = new room("Bedroom");

	static items west = new items("west", "", false, false, false, false, false);
	static items north = new items("north", "", false, false, false, false, false);
	static items south = new items("south", "", false, false, false, false, false);
	static items east = new items("east", "", false, false, false, false, false);

	static items bed = new items("bed", "A common single bed. There is a pillow on the bed.", false, false, false,
			false, false);
	static items pillow = new items("pillow", "A common soft pillow", false, false, false, false, false);
	static items clock = new items("clock", "A common digital wall clock", false, false, false, false, false);
	static items cd_player = new items("cd_player", "A common cd_player", false, true, false, false, false);
	static items wardrobe = new items("wardrobe", "A common wooden wardrobe", false, true, false, true, false);
	static items red_key = new items("red_key", "A red colored key.", true, false, true, false, false);
	static items blue_key = new items("blue_key", "A blue colored key.", true, false, true, false, false);
	static items safe = new items("safe", "A solid combination safe", false, true, false, false, false);
	static items paper = new items("paper", "Nothing is writing on the paper. But it smells like lemon.", true, false,
			false, false, false);
	static items battery = new items("battery", "A common alkaline battery.", true, false, true, false, false);
	static items BedroomDoor = new items("blue_door", "A blue colored door.", false, true, false, false, false);
	static items table = new items("table", "A common wooden table. There is a cd_player on it.", false, false, false,
			false, false);

	static items KitchenDoor = new items("red_door", "A red colored door.", false, true, false, false, false);
	static items rifle = new items("rifle", "A common old hunting rifle. But it is not loaded.", true, false, false,
			false, false);
	static items carpet = new items("carpet", "A common long carpet", false, false, false, false, false);

	static items HallDoor = new items("wooden_door", "A wooden door.", false, true, false, true, false);
	static items countertop = new items("countertop", "A common marble countertop", false, false, false, false, false);
	static items lighter = new items("lighter", "A common lighter", true, false, true, false, false);
	static items drawer = new items("drawer", "A wooden drawer which is under the countertop", false, true, false, true,
			false);
	static items refrigerator = new items("refrigerator", "A common medium-sized refrigerator.", false, true, false,
			true, false);
	static items steak = new items("steak", "A a big piece of steak which seems delicious.", true, false, true, false,
			false);

	static items OuterDoor = new items("iron_door", "A solid, iron door.", false, true, false, false, false);
	static items table2 = new items("table", "An ornate table which seems expensive. There is a vase on the table.",
			false, false, false, false, false);
	static items vase = new items("vase", "An ornate vase. It seems like a antique.", false, false, false, false,
			false);
	static items chest = new items("chest", "A big chest which seems like a treasure chest.", false, true, false, false,
			false);
	static items bullet = new items("bullet", "A bullet which may suit a hunting rifle.", true, false, true, false,
			false);
	static items painting = new items("painting", "A painting which shows a crying little girl.", false, false, false,
			false, false);
	static items safe2 = new items("safe", "A shot-proof solid safe.", false, true, false, false, false);
	static items dog = new items("dog", "A dog which seems like hungry and wild.", false, false, false, false, false);
	static items sofa = new items("sofa", "A red sofa which seems expensive.", false, false, false, false, false);
	static items golden_key = new items("golden_key", "A gold colored key.", true, false, true, false, false);
	static items silver_key = new items("silver_key", "A silver colored key.", false, false, true, false, false);
	static items glass_sphere = new items("glass_sphere",
			"A very solid glass sphere which cannot be broken by flinging it down\nin the middle of the glass, there is a silver_key.",
			true, false, false, false, false);

	static ArrayList<items> inventory = new ArrayList<>();
	static ArrayList<items> Room = new ArrayList<>();
	static ArrayList<items> ObjectsInBedroom = new ArrayList<>();
	static ArrayList<items> ObjectsInCorridor = new ArrayList<>();
	static ArrayList<items> ObjectsInKitchen = new ArrayList<>();
	static ArrayList<items> ObjectsInHall = new ArrayList<>();

	static boolean game = true;
	static boolean hungryDog = true;

	public static void main(String[] args) {

		ObjectsInBedroom.add(bed);
		ObjectsInBedroom.add(clock);
		ObjectsInBedroom.add(cd_player);
		ObjectsInBedroom.add(wardrobe);
		ObjectsInBedroom.add(pillow);
		ObjectsInBedroom.add(BedroomDoor);
		ObjectsInBedroom.add(west);
		ObjectsInBedroom.add(east);
		ObjectsInBedroom.add(north);
		ObjectsInBedroom.add(south);
		ObjectsInBedroom.add(table);

		ObjectsInCorridor.add(west);
		ObjectsInCorridor.add(east);
		ObjectsInCorridor.add(south);
		ObjectsInCorridor.add(north);
		ObjectsInCorridor.add(BedroomDoor);
		ObjectsInCorridor.add(KitchenDoor);
		ObjectsInCorridor.add(rifle);
		ObjectsInCorridor.add(carpet);

		ObjectsInKitchen.add(west);
		ObjectsInKitchen.add(east);
		ObjectsInKitchen.add(north);
		ObjectsInKitchen.add(south);
		ObjectsInKitchen.add(KitchenDoor);
		ObjectsInKitchen.add(HallDoor);
		ObjectsInKitchen.add(countertop);
		ObjectsInKitchen.add(refrigerator);
		ObjectsInKitchen.add(drawer);

		ObjectsInHall.add(west);
		ObjectsInHall.add(east);
		ObjectsInHall.add(north);
		ObjectsInHall.add(south);
		ObjectsInHall.add(HallDoor);
		ObjectsInHall.add(OuterDoor);
		ObjectsInHall.add(dog);
		ObjectsInHall.add(painting);
		ObjectsInHall.add(vase);
		ObjectsInHall.add(sofa);
		ObjectsInHall.add(chest);
		ObjectsInHall.add(table2);

		Scanner input = new Scanner(System.in);
		boolean running = true;
		boolean valid;
		String[] tokens;
		String answer = "";
		String command, object, object2;
		System.out.println(
				"You get up in a bedroom, you have a headache and you don't know where you are\nand how you did come here. You just know that you have to escape!\nYou are in a small-sized bedroom. There is a blue_door in east of the room.\nThere is a wall clock and a table in north, bed in west and a wardrobe in south of the room.\nAlso, there is a pillow on the bed and there is a cd_player on the table. ");
		while (game == true) {
			do {
				RoomSelect();
				answer = input.nextLine();
				tokens = answer.split("\\s+");
				valid = checkCommand(tokens[0]);
				if (!valid) {
					System.out.println("I don't know how to " + tokens[0]);
				}
			} while (!valid);
			if (tokens.length == 1) {
				command = tokens[0].toLowerCase();
				if (command.equals("inventory")) {
					Inventory();
				} else {
					System.out.println("I cannot understand you.");
				}
			}

			else if (tokens.length == 2) {
				command = tokens[0].toLowerCase();
				object = tokens[1].toLowerCase();
				if (checkObject(object)) {
					if (command.equals("open")) {
						Open(object);
					} else if (command.equals("examine")) {
						Examine(object);
					} else if (command.equals("take")) {
						Take(object);
					} else if (command.equals("move")) {
						Move(object);
					} else if (command.equals("close")) {
						Close(object);
					} else if (command.equals("use")) {
						System.out.println("You cannot do such a thing");
					}

				} else if (checkInventory(object) && command.equals("examine")) {
					Examine(object);
				} else if (checkInventory(object) && command.equals("use")) {
					System.out.println("You should say your target");
				} else if (object.equals("room") && command.equals("examine")) {
					if (currentRoom.nameOfRoom.equals("Bedroom")) {
						System.out.println(
								"It is a small-sized bedroom. There is a blue_door in east of the room.\nThere is a wall clock and a table in north, bed in west and a wardrobe in south of the room.\n Also, there is a pillow on the bed and there is a cd_player on the table. ");
					} else if (currentRoom.nameOfRoom.equals("Corridor")) {
						if (!inventory.contains(rifle)) {
							System.out.println(
									"It is a narrow corridor and there is not something too much. \nThere is a wall-hung rifle in south, a carpet on the floor.\nThere is also a blue_door in west and red_door in east.");
						} else {
							System.out.println(
									"It is a narrow corridor and there is not something too much. \nThere is a carpet on the floor.\nThere is also a blue_door in west and red_door in east.");
						}
					} else if (currentRoom.nameOfRoom.equals("Kitchen")) {
						System.out.println(
								"It is a middle-sized kitchen. There is a countertop at east and there is a drawer\nunder the countertop. There is a refrigerator in north.\nAlso there is a wooden_door in south and a red_door in west.");
					} else if (currentRoom.nameOfRoom.equals("Hall")) {
						if (hungryDog) {
							System.out.println(
									"It is a big hall. There is a table in the middle and a vase on the table.\nThere is a big chest in west, a painting in east.\nBut there is a dog which seems hungry in front of the painting\nAlso, there is a wooden_door in north and a iron_door in south.");
						} else {
							System.out.println(
									"It is a big hall. There is a table in the middle and a vase on the table.\nThere is a big chest in west, a painting in east.\nBut there is a dog which is sleeping in front of the painting\nAlso, there is a wooden_door in north and a iron_door in south.");
						}
					}
				} else {
					System.out.println("There is no such a thing");
				}
			} else if (tokens.length == 3) {
				command = tokens[0].toLowerCase();
				object = tokens[1].toLowerCase();
				object2 = tokens[2].toLowerCase();
				if ((checkObject(object2) || checkInventory(object2)) && checkInventory(object)) {
					if (command.equals("use")) {
						Use(object, object2);
					} else {
						System.out.println("I cannot understand you");
					}
				} else if (checkInventory(object) && !(checkObject(object2) || checkInventory(object2))) {
					System.out.print("There is no " + object2);
				} else if (!checkInventory(object) && (checkObject(object2) || checkInventory(object2))) {
					System.out.print("You have no " + object + " in your inventory");
				} else {
					System.out.println("I cannot understand you");
				}
			}
		}

	}

	public static boolean checkCommand(String verb) {
		verb = verb.toLowerCase();
		for (int i = 0; i < PossibleVerbs.length; i++) {
			if (verb.equals(PossibleVerbs[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkObject(String object) {
		object = object.toLowerCase();
		for (int i = 0; i < Room.size(); i++) {
			if (object.equals(Room.get(i).nameOfItem)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkInventory(String object) {
		object = object.toLowerCase();
		for (int i = 0; i < inventory.size(); i++) {
			if (object.equals(inventory.get(i).nameOfItem)) {
				return true;
			}
		}
		return false;
	}

	public static void Use(String object, String object2) {
		object = object.toLowerCase();
		items theItem = inventory.get(0);
		items theItem2 = Room.get(0);
		for (int i = 0; i < inventory.size(); i++) {
			if (object.equals(inventory.get(i).nameOfItem)) {
				theItem = inventory.get(i);
			}
		}
		for (int i = 0; i < Room.size(); i++) {
			if (object2.equals(Room.get(i).nameOfItem)) {
				theItem2 = Room.get(i);
			}
		}

		for (int i = 0; i < inventory.size(); i++) {
			if (object2.equals(inventory.get(i).nameOfItem)) {
				theItem2 = inventory.get(i);
			}
		}

		if (theItem.equals(battery) && theItem2.equals(cd_player)) {
			System.out.println("The cd_player has powered!");
			cd_player.isUnlocked = true;
			ObjectsInBedroom.add(battery);
			inventory.remove(battery);
		} else if (theItem.equals(blue_key) && theItem2.equals(BedroomDoor)) {
			if (!theItem2.isUnlocked) {
				System.out.print("The " + theItem2.nameOfItem + " is unlocked!");
				theItem2.isUnlocked = true;
			} else {
				System.out.print("You locked the " + theItem2.nameOfItem);
				theItem2.isUnlocked = false;
				theItem2.isOpen = false;
			}
		}

		else if (theItem.equals(red_key) && theItem2.equals(KitchenDoor)) {
			if (!theItem2.isUnlocked) {
				System.out.print("The " + theItem2.nameOfItem + " is unlocked!");
				theItem2.isUnlocked = true;
			} else {
				System.out.print("You locked the " + theItem2.nameOfItem);
				theItem2.isUnlocked = false;
				theItem2.isOpen = false;
			}
		} else if (theItem.equals(lighter) && theItem2.equals(paper)) {
			System.out.println("The letters 'C', 'O', 'M', 'P' appeared on the paper! ");
			paper.descriptionOfItem = "'COMP' is written on the paper.";
		}

		else if (theItem.equals(golden_key) && theItem2.equals(chest)) {
			if (!theItem2.isUnlocked) {
				System.out.print("The " + theItem2.nameOfItem + " is unlocked!");
				theItem2.isUnlocked = true;
			} else {
				System.out.print("You locked the " + theItem2.nameOfItem);
				theItem2.isUnlocked = false;
				theItem2.isOpen = false;
			}
		}

		else if (theItem.equals(silver_key) && theItem2.equals(OuterDoor)) {
			if (!theItem2.isUnlocked) {
				System.out.print("The " + theItem2.nameOfItem + " is unlocked!");
				theItem2.isUnlocked = true;
			} else {
				System.out.print("You locked the " + theItem2.nameOfItem);
				theItem2.isUnlocked = false;
				theItem2.isOpen = false;
			}
		}

		else if (theItem.equals(steak) && theItem2.equals(dog)) {
			System.out.println("The dog has eaten the steak and sinked into a deep sleep.");
			hungryDog = false;
			inventory.remove(steak);
		}

		else if (theItem.equals(rifle) && rifle.canBeUsed) {
			if (theItem2.equals(glass_sphere)) {
				System.out.println("The glass_sphere has broken to pieces. Now you get take the silver_key");
				if (ObjectsInHall.contains(glass_sphere)) {
					ObjectsInHall.remove(glass_sphere);
				} else if (inventory.contains(glass_sphere)) {
					inventory.remove(glass_sphere);
				}
				silver_key.canBeTaken = true;
			} else {
				System.out.print("You cannot shoot the " + theItem2.nameOfItem);
			}
		} else if (theItem.equals(rifle) && !rifle.canBeUsed) {
			System.out.println("The rifle is not loaded. You need a bullet");
		}

		else if (theItem.equals(bullet) && theItem2.equals(rifle)) {
			rifle.canBeUsed = true;
			System.out.println("The rifle is loaded!");
			inventory.remove(bullet);
		}

		else if (theItem.equals(golden_key) && theItem2.equals(chest)) {
			System.out.println("The chest is unlocked");
			chest.isUnlocked = true;
		} else if ((theItem.equals(red_key) || theItem.equals(blue_key) || theItem.equals(silver_key)
				|| theItem.equals(golden_key))
				&& (theItem2.equals(BedroomDoor) || theItem2.equals(KitchenDoor) || theItem2.equals(HallDoor)
						|| theItem2.equals(OuterDoor) || theItem2.equals(chest))) {
			System.out.print("The " + theItem.nameOfItem + " doesn't suit to " + theItem2.nameOfItem);
		} else {
			System.out.println("You cannot do such a thing");
		}
	}

	public static void Close(String object) {
		object = object.toLowerCase();
		items theItem = Room.get(0);
		for (int i = 0; i < Room.size(); i++) {
			if (object.equals(Room.get(i).nameOfItem)) {
				theItem = Room.get(i);
			}
		}
		if (theItem.canBeOpened) {
			if (theItem.isOpen) {
				if(theItem.equals(safe)||theItem.equals(safe2)){
					theItem.isUnlocked=false;
				}
				theItem.isOpen = false;
				System.out.print("You closed the " + theItem.nameOfItem);
			} else {
				System.out.print("The " + theItem.nameOfItem + " is already closed");
			}
		} else {
			System.out.println("You cannot do such a thing");
		}
	}

	public static void Open(String object) {
		Scanner input = new Scanner(System.in);
		object = object.toLowerCase();
		items theItem = Room.get(0);
		for (int i = 0; i < Room.size(); i++) {
			if (object.equals(Room.get(i).nameOfItem)) {
				theItem = Room.get(i);
			}
		}
		if (theItem.canBeOpened && theItem.isUnlocked && !theItem.isOpen) {
			System.out.print("The " + theItem.nameOfItem + " is opened.");
			theItem.isOpen = true;
			if (theItem.nameOfItem.equals("wardrobe")) {
				System.out.println("There is a safe in the wardrobe");
				if (!Room.contains(safe)) {
					Room.add(safe);
				}
			} else if (theItem.equals(cd_player)) {
				System.out.println("You watched 101 Dalmatians cartoon of Disney.");
				cd_player.isOpen = false;
			} else if (theItem.equals(safe)) {
				if (!inventory.contains(blue_key) && !inventory.contains(paper)) {
					System.out.println("There is a paper and blue_key inside the safe");
					Room.add(blue_key);
					Room.add(paper);
				} else if (!inventory.contains(blue_key) && inventory.contains(paper)) {
					System.out.println("There is a blue_key inside the safe");
				} else if (inventory.contains(blue_key) && !inventory.contains(paper)) {
					System.out.println("There is a paper inside the safe");
				} else {
					System.out.println("There is nothing inside the safe");
				}
			}

			else if (theItem.equals(drawer)) {
				if (!Room.contains(lighter) && !inventory.contains(lighter)) {
					ObjectsInKitchen.add(lighter);
					System.out.println("There is a lighter inside the drawer");
				}
			}

			else if (theItem.equals(safe2)) {
				if (!Room.contains(silver_key) && !inventory.contains(silver_key)) {
					ObjectsInHall.add(silver_key);
					ObjectsInHall.add(glass_sphere);
					System.out.println("There is a glass_sphere inside the safe!");
				}
			} else if (theItem.equals(refrigerator)) {
				if (!Room.contains(steak) && !inventory.contains(steak)) {
					ObjectsInKitchen.add(steak);
					System.out.println("There is a steak inside the refrigerator");
				}
			}

			else if (theItem.equals(chest)) {
				if (!Room.contains(bullet) && !inventory.contains(bullet) && !rifle.canBeUsed) {
					ObjectsInHall.add(bullet);
					System.out.println("There is a bullet inside the chest");
				}
			}

		} else if (theItem.canBeOpened && theItem.isOpen) {
			System.out.println("It is already opened");
		}

		else if (theItem.canBeOpened && !theItem.isUnlocked) {
			if (theItem.nameOfItem.equals("cd_player")) {
				System.out.println("A battery is needed to open the cd_player");

			} else if (theItem.equals(safe)) {
				System.out.println("Please enter the three digit password to open the safe.");
				String password = input.next();
				if (password.equals("101")) {
					System.out.println("The safe is unlocked");
					theItem.isUnlocked = true;
				} else {
					System.out.println("Invalid password");
				}
			}

			else if (theItem.equals(safe2)) {
				System.out.println("Please enter the four character password to open the safe.");
				String password = input.next();
				if (password.equals("COMP")) {
					System.out.println("The safe is unlocked");
					theItem.isUnlocked = true;
				} else {
					System.out.println("Invalid password");
				}
			}

			else {
				System.out.printf("The " + theItem.nameOfItem + " is locked.");

			}
		} else {
			System.out.print("You cannot open " + theItem.nameOfItem);
		}
	}

	public static void Examine(String object) {
		object = object.toLowerCase();
		items theItem = Room.get(0);
		for (int i = 0; i < Room.size(); i++) {
			if (object.equals(Room.get(i).nameOfItem)) {
				theItem = Room.get(i);
			}
		}
		for (int i = 0; i < inventory.size(); i++) {
			if (object.equals(inventory.get(i).nameOfItem)) {
				theItem = inventory.get(i);
			}
		}

		if (theItem.equals(wardrobe)) {
			if (wardrobe.isOpen) {
				System.out.println("There is a safe inside the wardrobe");
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		} else if (theItem.equals(clock)) {
			if (!Room.contains(battery) && !inventory.contains(battery)) {
				System.out.println("There is a battery inside the clock");
				Room.add(battery);
			} else if (Room.contains(battery) && !inventory.contains(battery)) {
				System.out.println("There is a battery inside the clock");
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		}

		else if (theItem.equals(pillow)) {
			if (Room.contains(red_key)) {
				System.out.println("There is a red_key under the pillow");
			} else if (!Room.contains(red_key) && !inventory.contains(red_key)) {
				System.out.println("There is a red_key under the pillow");
				Room.add(red_key);
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		}

		else if (theItem.equals(painting)) {
			if (hungryDog == true) {
				System.out.println(
						"You can not examine painting since there is a tethered hungry dog in fron of the painting");
			} else {
				System.out.println("There is a safe behind the painting!");
				if (!Room.contains(safe)) {
					ObjectsInHall.add(safe2);
				}
			}
		} else if (theItem.equals(chest) && chest.isOpen) {
			if (!Room.contains(bullet) && !inventory.contains(bullet)) {
				System.out.println("There is a bullet inside the chest!");
				ObjectsInHall.add(bullet);
			} else if (Room.contains(bullet)) {
				System.out.println("There is a bullet inside the chest.");
			} else if (inventory.contains(bullet) || rifle.canBeUsed) {
				System.out.println("There is nothing inside the chest");
			}
		} else if (theItem.equals(vase)) {
			if (Room.contains(golden_key)) {
				System.out.println("There is a golden_key inside the vase");
			} else if (!Room.contains(golden_key) && !inventory.contains(golden_key)) {
				System.out.println("There is a golden_key inside the vase");
				Room.add(golden_key);
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		} else if (theItem.equals(safe)) {
			if (safe.isOpen) {
				if (!inventory.contains(blue_key) && !inventory.contains(paper)) {
					System.out.println("There is a paper and blue_key inside the safe");
				} else if (!inventory.contains(blue_key) && inventory.contains(paper)) {
					System.out.println("There is a blue_key inside the safe");
				} else if (inventory.contains(blue_key) && !inventory.contains(paper)) {
					System.out.println("There is a paper inside the safe");
				} else {
					System.out.println("There is nothing inside the safe");
				}
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		}

		else if (theItem.equals(drawer)) {
			if (drawer.isOpen) {
				if (!inventory.contains(lighter)) {
					System.out.println("There is a lighter inside the drawer");
				} else {
					System.out.println("There is nothing inside the drawer");
				}
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		}

		else if (theItem.equals(chest)) {
			if (chest.isOpen) {
				if (!inventory.contains(bullet)) {
					System.out.println("There is a bullet inside the chest");
				} else {
					System.out.println("There is nothing inside the chest");
				}
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		}

		else if (theItem.equals(safe2)) {
			if (safe2.isOpen) {
				if (!inventory.contains(glass_sphere)) {
					System.out.println("There is a glass_sphere inside the chest");
				} else {
					System.out.println("There is nothing inside the safe");
				}
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		}

		else if (theItem.equals(refrigerator)) {
			if (refrigerator.isOpen) {
				if (!inventory.contains(steak)) {
					System.out.println("There is a steak inside the refrigerator");
				} else {
					System.out.println("There is nothing inside the refrigerator");
				}
			} else {
				System.out.print(theItem.descriptionOfItem);
			}
		}

		else {
			System.out.print(theItem.descriptionOfItem);
		}
	}

	public static void Take(String object) {
		object = object.toLowerCase();
		items theItem = Room.get(0);
		for (int i = 0; i < Room.size(); i++) {
			if (object.equals(Room.get(i).nameOfItem)) {
				theItem = Room.get(i);
			}
		}
		if (theItem.canBeTaken) {
			System.out.print("You have taken the " + theItem.nameOfItem);
			inventory.add(theItem);
			Room.remove(theItem);
			if (theItem.equals(battery)) {
				cd_player.isUnlocked = false;
			}
		} else {
			System.out.print("You cannot take the " + theItem.nameOfItem);
		}
	}

	public static void Inventory() {
		if (inventory.size() == 0) {
			System.out.println("You are not carrying anything");
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				System.out.print(inventory.get(i).nameOfItem + "\n");
			}
		}
	}

	public static void RoomSelect() {
		if (currentRoom.nameOfRoom.equals("Bedroom")) {
			Room = ObjectsInBedroom;
		} else if (currentRoom.nameOfRoom.equals("Corridor")) {
			Room = ObjectsInCorridor;
		} else if (currentRoom.nameOfRoom.equals("Kitchen")) {
			Room = ObjectsInKitchen;
		} else if (currentRoom.nameOfRoom.equals("Hall")) {
			Room = ObjectsInHall;
		}

	}

	public static void Move(String object) {
		object = object.toLowerCase();
		if (currentRoom.nameOfRoom.equals("Bedroom")) {
			if (object.equals("east")) {
				if (BedroomDoor.isOpen) {
					Room = ObjectsInCorridor;
					if (!inventory.contains(rifle)) {
						System.out.println(
								"You entered a narrow corridor and there is not something too much. \nThere is a wall-hung rifle in south, a carpet on the floor.\nThere is also a blue_door in west and red_door in east.");
					} else {
						System.out.println(
								"You entered a narrow corridor and there is not something too much. \nThere is a carpet on the floor.\nThere is also a blue_door in west and red_door in east.");
					}
					currentRoom.nameOfRoom = "Corridor";
				} else {
					System.out.println("Since the blue_door is closed, you cannot move");
				}
			} else if (object.equals("north") || object.equals("south") || object.equals("west")) {
				System.out.println("Since there is no door in this direction, you cannot move");
			} else {
				System.out.println("There is no such a direction");
			}
		} else if (currentRoom.nameOfRoom.equals("Corridor")) {
			if (object.equals("east")) {
				if (KitchenDoor.isOpen) {
					Room = ObjectsInKitchen;
					System.out.println(
							"You entered a middle-sized kitchen. There is a countertop in east and there is a drawer\nunder the countertop. There is a refrigerator in north.\nAlso there is a wooden_door in south and a red_door in west.");
					currentRoom.nameOfRoom = "Kitchen";
				} else {
					System.out.println("Since the red_door is closed, you cannot move");
				}
			} else if (object.equals("west")) {
				if (BedroomDoor.isOpen) {
					Room = ObjectsInBedroom;
					System.out.println(
							"You entered a small-sized bedroom. There is a blue_door in east of the room.\nThere is a wall clock and a table in north, bed in west and a wardrobe in south of the room.\n Also, there is a pillow on the bed and there is a cd_player on the table. ");
					currentRoom.nameOfRoom = "Bedroom";
				} else {
					System.out.println("Since the blue_door is closed, you cannot move");
				}
			} else if (object.equals("north") || object.equals("south")) {
				System.out.println("Since there is no door in this direction, you cannot move");
			} else {
				System.out.println("There is no such a direction");
			}
		} else if (currentRoom.nameOfRoom.equals("Kitchen")) {
			if (object.equals("south")) {
				if (HallDoor.isOpen) {
					Room = ObjectsInHall;
					if (hungryDog) {
						System.out.println(
								"You entered a big hall. There is a table in the middle and a vase on the table. \nThere is a big chest in west, a painting in east.\nBut there is a dog which seems hungry in front of the painting\nAlso, there is a wooden_door in north and a iron_door in south.");
					} else {
						System.out.println(
								"You entered a big hall. There is a table in the middle and a vase on the table. \nThere is a big chest in west, a painting in east.\nBut there is a dog which is sleeping in front of the painting\nAlso, there is a wooden_door in north and a iron_door in south.");
					}
					currentRoom.nameOfRoom = "Hall";
				} else {
					System.out.println("Since the wooden_door is closed, you cannot move");
				}
			} else if (object.equals("west")) {
				if (KitchenDoor.isOpen) {
					Room = ObjectsInCorridor;
					if (!inventory.contains(rifle)) {
						System.out.println(
								"You entered a narrow corridor and there is not something too much. \nThere is a wall-hung rifle in south, a carpet on the floor.\nThere is also a blue_door in west and red_door in east.");
					} else {
						System.out.println(
								"You entered a narrow corridor and there is not something too much. \nThere is a carpet on the floor.\nThere is also a blue_door in west and red_door in east.");
					}
					currentRoom.nameOfRoom = "Corridor";
				} else {
					System.out.println("Since the red_door is closed, you cannot move");
				}
			} else if (object.equals("north") || object.equals("east")) {
				System.out.println("Since there is no door in this direction, you cannot move");
			} else {
				System.out.println("There is no such a direction");
			}
		} else if (currentRoom.nameOfRoom.equals("Hall")) {
			if (object.equals("south")) {
				if (OuterDoor.isOpen) {
					System.out.println("Congratulations! You have successfully exited from the house!");
					game = false;
				} else {
					System.out.println("Since the iron_door is closed, you cannot move");
				}
			} else if (object.equals("north")) {
				if (HallDoor.isOpen) {
					Room = ObjectsInKitchen;
					System.out.println(
							"You entered a middle-sized kitchen. There is a countertop in east and there is a drawer\nunder the countertop. There is a refrigerator in north.\nAlso there is a wooden_door in south and a red_door in west.");
					currentRoom.nameOfRoom = "Kitchen";
				} else {
					System.out.println("Since the wooden_door is closed, you cannot move");
				}
			} else if (object.equals("west") || object.equals("east")) {
				System.out.println("Since there is no door in this direction, you cannot move");
			} else {
				System.out.println("There is no such a direction");
			}
		}
	}
}
