Before play my game please read following instructions;

0) You should run "main.java" file which in "ZorkJavaProject> src > ZorkGame"

1) In this game you can only use following verbs;
-take
-open
-close
-examine
-use
-move
-inventory

2) When you are using "use" verb, you should specify "which object do you want to use" and on which object do you want to use". 
<use><first object which will be used><second object which is the target of first object>
For example;
use lighter paper    ////     use red_key red_door

3) Some object names includes "_". So, when you say these objects in your commands, you are supposed to write them by including "_". For example;
red_key     ///     cd_player       ///   iron_door

4) In this game, unlocking an object doesn't mean that you opened that object. First you should unlock the object if it is locked, and then, you should open it with "open" command. For example;
use red_key red_door
The red_door is unlocked!
open red_door
The red_door is opened.

5) You should use "move" verb with directions "east, west, south, north". If there is a opened door in that direction, the game will allow you to move to the next room. For example;
move east      ///    move south

6) "take" verb doesn't mean that you handle an object. It means that you added that object to your inventory. You don't need to say "take key" before use it on door if you already have "key" in your inventory. "take" verb is only for taking something from the room and adding it to your inventory.

7) You can examine following things;
-room     ///     examine room
-objects in room    ///   examine table
-objects in your inventory    ///     examine paper

8) If you use a suitable key on a door which is already locked, it will be opened. Similarly, if you use suitable key on a door which is already unlocked, it will be locked.

9) If you use "open" verb for a openable thing which is also unlocked it will be opened. Similarly, if you use "close" verb on a opened thing, it will be closed.

10) If you want to see what do you have in your inventory, you only supposed to write "inventory"

11) There are some passowrds of safes in game. You are supposed to figure out them by examining something and doing inference