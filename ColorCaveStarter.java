// ColorCaveStarter.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Set;

public class ColorCaveStarter extends JPanel implements MouseListener {
    Rectangle2D[] doorRectangles;
    Room currentRoom;
    JFrame frame;
    AbstractRoomLoader loader;

    public ColorCaveStarter() {
        frame = new JFrame("Color Cave");
        frame.setSize(1000, 1000);
        frame.add(this);
        frame.addMouseListener(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Load room data and get the starting room
        loader = new ConcreteRoomLoader(); // Replace with your concrete subclass
        currentRoom = loader.getStart();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Display doors for the current room
        Set<Door> doors = currentRoom.getDoors();
        doorRectangles = new Rectangle2D[doors.size()];
        int x = 200; // Initial x-coordinate for door display
        int y = 200; // Initial y-coordinate for door display
        int doorWidth = 100; // Width of the door display
        int doorHeight = 200; // Height of the door display
        int index = 0;
        for (Door door : doors) {
            g2.setColor(enumToColor(door));
            doorRectangles[index] = new Rectangle2D.Double(x, y, doorWidth, doorHeight);
            g2.fill(doorRectangles[index]);
            x += doorWidth + 20; // Add some spacing between doors
            index++;
        }
    }

    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < doorRectangles.length; i++) {
            if (doorRectangles[i].contains(e.getPoint())) {
                // Transition to the next room if a door is clicked
                currentRoom = currentRoom.enter(Door.values()[i]);
                repaint();
                break; // Exit loop once a door is clicked
            }
        }
    }

    private Color enumToColor(Door d) {
        switch (d) {
            case RED:
                return Color.RED;
            case BLUE:
                return Color.BLUE;
            case GREEN:
                return Color.GREEN;
            case PINK:
                return Color.PINK;
            case YELLOW:
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        ColorCaveStarter app = new ColorCaveStarter();
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
	}
}