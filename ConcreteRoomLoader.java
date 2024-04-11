public class ConcreteRoomLoader extends AbstractRoomLoader {
    CaveData cave = new CaveData();
    public Room start, end;

    public ConcreteRoomLoader() {
        cave = deserialize("aarav.ser");
        start = cave.getStart();
        end = cave.getEnd();
    }


    public void load() {
        start = new Room("start", "first");
        Room r1 = new Room("one", "level one");
        Room r2 = new Room("two", "level two");
        Room r3 = new Room("three", "level two");
        Room r4 = new Room("four", "level three");
        Room r5 = new Room("five", "level three");
        Room r6 = new Room("six", "test");
        Room r7 = new Room("seven", "test");
        Room r8 = new Room("eight", "test");
        end = new Room("end", "final room");
    
        // Add doors to the rooms here
    
        cave.addRoom(start);
        cave.addRoom(r1);
        cave.addRoom(r2);
        cave.addRoom(r3);
        cave.addRoom(r4);
        cave.addRoom(r5);
        cave.addRoom(r6);
        cave.addRoom(r7);
        cave.addRoom(r8);
        cave.addRoom(end);
    
        serialize("aarav.ser");
    }
    @Override
    public Room getStart() {
        // TODO Auto-generated method stub
        return start;
    }

    @Override
    public Room getEnd() {
        // TODO Auto-generated method stub
        return end;

    }

    public static void main(String[] args) {

    }
}