import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class ColorCaveStarter extends JPanel implements MouseListener {// test
	Rectangle r;
	Room room, end;

	JFrame frame;
	ConcreteRoomLoader loader;

	private long startTime;

	public ColorCaveStarter() {
		frame = new JFrame("Color Cave");
		frame.setSize(1000, 1000);
		frame.add(this);
		frame.addMouseListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		loader = new ConcreteRoomLoader(); // need to extend abstract with concrete class
		loader.load(); // Load your cave data

		room = loader.getStart();
		startTime = System.currentTimeMillis();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());

		if (room != null) { // Check if room is not null
			int doorY = 200;
			for (Door door : room.getDoors()) {
				g2.setColor(enumToColor(door));
				r = new Rectangle(200, doorY, 100, 200);
				g2.fill(r);
				doorY += 220;
			}

			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Arial", Font.BOLD, 44));
			g2.drawString("COLOR CAVE!", 80, 40);
			g2.setFont(new Font("Arial", Font.BOLD, 24));
			g2.drawString(room.getName(), 80, 80);
			g2.drawString(room.getDescription(), 80, 120);

			long elapsedTime = System.currentTimeMillis() - startTime;
			g2.drawString("Time elapsed: " + (elapsedTime / 1000) + " seconds", 80, 160);

			if (room.equals(loader.getEnd())) {
				g2.drawString("Congratulations! You reached the end in " + (elapsedTime / 1000) + " seconds.", 80, 200);
			}
		} else {
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Arial", Font.BOLD, 24));
			g2.drawString("Loading...", 80, 80);
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (r.contains(e.getX(), e.getY())) {
			System.out.println("Inside the Rectangle");

		} else {
			System.out.println("Outside the Rectangle");
		}
		repaint();

		for (Door door : room.getDoors()) {
			int doorY = 200;
			Rectangle doorRect = new Rectangle(200, doorY, 100, 200);
			if (doorRect.contains(e.getX(), e.getY())) {
				Room nextRoom = room.enter(door);
				room = nextRoom;
				repaint();
				break;
			}
			doorY += 220;
		}
	}

	// Other mouse listener methods we don't need to use
	public void mouseExited(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
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

}
