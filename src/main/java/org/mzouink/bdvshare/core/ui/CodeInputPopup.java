package org.mzouink.bdvshare.core.ui;

import javax.swing.*;
import java.awt.*;

public class CodeInputPopup {
    public static String show() {
        JPanel corePanel = new JPanel(new GridLayout());
        corePanel.setPreferredSize(new Dimension(500, 225));
        JPanel mainPanel = new JPanel(new FlowLayout());
        JLabel title = new JLabel("One time sharing code :", SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(450, 40));
        mainPanel.add(title);
        JTextFieldLimit inputLabel = new JTextFieldLimit();
        mainPanel.add(inputLabel);
        corePanel.add(mainPanel);
        int result = JOptionPane.showConfirmDialog(null, corePanel, "Enter one time share code", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION)
            return inputLabel.getText();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(CodeInputPopup.show());
    }
}

