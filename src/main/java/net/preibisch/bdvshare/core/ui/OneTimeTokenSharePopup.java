package net.preibisch.bdvshare.core.ui;

import javax.swing.*;
import java.awt.*;

public class OntTimeTokenSharePopup extends JFrame {
    public OntTimeTokenSharePopup(String shareCode) {
        super("Share : "+format(shareCode));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("One time sharing code :", SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(400,50));
        add(title);
        JLabel codeLabel = new JLabel(format(shareCode), SwingConstants.CENTER);
        codeLabel.setPreferredSize(new Dimension(450,150));
        codeLabel.setFont(new Font("Batang", Font.PLAIN, 90));
        codeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JButton button = new JButton();
        button.setText("Done");
        button.addActionListener(e -> dispose());
        add(codeLabel);
        JPanel panel = new JPanel();
        panel.add(button);
        add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private static String format(String str) {
        return str.replace("", " ").trim();
    }

    public static void main(String[] args) {
        System.out.println(format("XLMH"));
        new OntTimeTokenSharePopup("XLMH");
    }
}
