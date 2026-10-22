// Bar chart with marks displayed on top of each bar
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class BarChart extends Applet {
    int[] marks = {78, 91, 45, 66, 88};
    String msg = "Click a bar";

    public void init() {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = (e.getX() - 20) / 50;
                if (i >= 0 && i < 5)
                    msg = "Subject " + (i + 1) + " = " + marks[i];
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 20);

        for (int i = 0; i < marks.length; i++) {
            g.setColor(marks[i] >= 50 ? Color.GREEN : Color.RED);
            g.fillRect(20 + i * 50, 150 - marks[i], 40, marks[i]);

            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(marks[i]),
                         25 + i * 50, 145 - marks[i]);
        }
    }
}

/*
OUTPUT:

A bar chart with five bars:

78     91     45     66     88
|      |      |      |      |
|      |      |      |      |
|      |      |      |      |
|      |      |      |      |

Bars for marks >= 50 are GREEN.
Bars for marks < 50 are RED.

Clicking a bar displays its subject and mark.
Example: Subject 2 = 91
*/
