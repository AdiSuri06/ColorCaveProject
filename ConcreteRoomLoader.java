import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ConcreteRoomLoader extends AbstractRoomLoader {
    private Room start;

    @Override
    public void load() {
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

    // Serialize your cave's data
    public void serializeCave(String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
            System.out.println("Cave data serialized successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred during serialization: " + e.getMessage());
        }
    }

    @Override
    public Room getEnd() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEnd'");
    }
}
