package org.mzouink.bdvshare.api;

import org.mzouink.bdvshare.core.ui.CodeInputPopup;

public class OpenBdvUsingID {
    public static void main(String[] args) {
        String id = CodeInputPopup.show();

        if (id != null && id.length() == 4)
            BDVShareable.fromID(id);
        else {
            System.out.println("Invalid ID ! " + id);
            return;
        }
    }
}
