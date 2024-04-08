public class ConcreteRoomLoader extends AbstractRoomLoader{
        CaveData cave = new CaveData();
    public Room start, end;
   public void load()
   {
   start = new Room("start", "first");
   Room r1 = new Room("one", "level one");
   Room  r2 = new Room("two", "level two");
   Room r3 = new Room("three", "level two");
   Room r4 = new Room("four", "level three");
   Room r5 = new Room("five", "level three");
   Room r6 = new Room("six", "test");
   Room r7= new Room("seven", "test");
   Room r8 = new Room("eight", "test");
   
   
   start.addDoor(Door.RED,  r1); 
   r1.addDoor(Door.BLUE, r2);
   r1.addDoor(Door.RED, r3);
   r2.addDoor(Door.GREEN, r1);
   r2.addDoor(Door.YELLOW, r4);
   r2.addDoor(Door.BLUE, r5);
   r5.addDoor(Door.GREEN, r6);
   r3.addDoor(Door.RED, r7);
   r3.addDoor(Door.BLUE, r8);
   
   cave.addRoom(r1);
   cave.addRoom(r2);
   cave.addRoom(r3);
   cave.addRoom(r4);
   cave.addRoom(r5);
   cave.addRoom(r6);
   cave.addRoom(r7);
   cave.addRoom(r8);
   serialize("aarav.ser");
   
   }
@Override
public Room getStart() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Room getEnd() {
	// TODO Auto-generated method stub
	return null;
    
}
   
public static void main(String[] args)
{
   
}
}
