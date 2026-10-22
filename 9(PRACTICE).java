// Add a Clear button that empties every field.

import javax.swing.*;
import java.awt.*;

public class RegisterForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Student Registration");
        f.setLayout(new FlowLayout());

        JTextField name = new JTextField(14);
        JComboBox<String> br = new JComboBox<>(
                new String[]{"CSE", "IT", "ECE"});

        JRadioButton m = new JRadioButton("Male", true);
        JRadioButton fe = new JRadioButton("Female");

        ButtonGroup g = new ButtonGroup();
        g.add(m);
        g.add(fe);

        JButton sub = new JButton("Submit");
        JButton clear = new JButton("Clear");
        JLabel out = new JLabel(" ");

        f.add(new JLabel("Name"));
        f.add(name);
        f.add(new JLabel("Branch"));
        f.add(br);
        f.add(m);
        f.add(fe);
        f.add(sub);
        f.add(clear);
        f.add(out);

        sub.addActionListener(e -> {
            if (name.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        f, "Name cannot be empty");
            } else {
                out.setText(name.getText() + " | "
                        + br.getSelectedItem() + " | "
                        + (m.isSelected() ? "Male" : "Female"));
            }
        });

        clear.addActionListener(e -> {
            name.setText("");
            br.setSelectedIndex(0);
            m.setSelected(true);
            out.setText(" ");
        });

        f.setSize(350, 220);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

/*
OUTPUT:

Student Registration

Name     [______________]
Branch   [CSE v]
(o) Male  ( ) Female

[Submit] [Clear]

After clicking Clear:
Name field becomes empty.
Branch resets to CSE.
Male is selected.
Output message is cleared.
*/
