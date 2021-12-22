package org.mzouink.bdvshare.core.ui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class JTextFieldLimit extends JTextField {
    private int limit = 4;

    public JTextFieldLimit() {
        super();
        setHorizontalAlignment(JTextField.CENTER);
        setPreferredSize(new Dimension(450,150));
        setFont(new Font("Batang", Font.PLAIN, 90));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }

    private class LimitDocument extends PlainDocument {
        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) return;
            if ((getLength() + str.length()) <= limit)
                super.insertString(offset, str.toUpperCase(), attr);
        }


    }

}