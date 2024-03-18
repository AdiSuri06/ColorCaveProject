public class ConcreteRoomLoader extends AbstractRoomLoader {
    private Room start, end;

    @Override
    public void load() {
        // Load room data
        // Example:
        start = new Room("Start Room", "This is the starting room");
        Room room1 = new Room("Room 1", "Description 1");
        Room room2 = new Room("Room 2", "Description 2");

        // Define doors between rooms
        start.addDoor(Door.RED, room1);
        start.addDoor(Door.BLUE, room2);
    }

    @Override
    public Room getStart() {
        return start;
    }

    @Override
    public Room getEnd() {
        return end;
    }
}