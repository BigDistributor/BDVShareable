package net.preibisch.bdvshare.core.ui;

import javax.swing.*;
import java.awt.*;

public class FileInputPopup {
    public static String get(String title) {
        JPanel mainPanel = new JPanel(new FlowLayout());
        JTextField inputLabel = new JTextField();
        inputLabel.setPreferredSize(new Dimension(350, 40));
        JButton selectFileButton = new JButton("Select");
        selectFileButton.addActionListener(e -> {
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION)
                inputLabel.setText(fc.getSelectedFile().getAbsolutePath());
        });
        mainPanel.add(inputLabel);
        mainPanel.add(selectFileButton);
        int result = JOptionPane.showConfirmDialog(null, mainPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION)
            return inputLabel.getText();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(FileInputPopup.get("Select file : "));
    }
}


