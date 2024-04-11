import java.util.*;
import java.io.*;

public class ConcreteRoomLoader extends AbstractRoomLoader {
    CaveData cave = new CaveData();
    public Room start, end;
    HashMap<Character, Door> h = new HashMap<Character, Door>();

    public ConcreteRoomLoader() {
        cave = deserialize("aarav.ser");
        start = cave.getStart();
        end = cave.getEnd();
    }

    public void load() {

        h.put('r', Door.RED);

        h.put('g', Door.GREEN);

        h.put('b', Door.BLUE);

        h.put('p', Door.PINK);

        h.put('y', Door.YELLOW);

        String line = "";
        try {
            System.out.print("test");
            File file = new File("labyrinth2.txt");

            BufferedReader br = new BufferedReader(
                    new FileReader(file));

            ArrayList<Room> arr = new ArrayList<Room>();

            int i = 0;

            for (int j = 1; j < 32; j++)

            {

                Room room = new Room(j + "", "");

                cave.addRoom(room);

                arr.add(room);
                if (j == 1)
                    start = room;
                if (j == 31)
                    end = room;

            }

            while ((line = br.readLine()) != null)

            {

                StringTokenizer st = new StringTokenizer(line);
                Room room = arr.get(i++);
                while (st.hasMoreTokens())

                {
                    System.out.print("test");

                    String s = st.nextToken();

                    char[] c = s.toCharArray();
                    if (c.length == 3)
                        room.addDoor(h.get(c[0]),
                                arr.get(Integer.parseInt(Character.toString(c[1]) + Character.toString(c[2]))));
                    else
                        room.addDoor(h.get(c[0]), arr.get(Integer.parseInt(Character.toString(c[1]))));

                    Integer integer = Integer.parseInt(Character.toString(c[1]));
                    System.out.print(integer.toString());
                }

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

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