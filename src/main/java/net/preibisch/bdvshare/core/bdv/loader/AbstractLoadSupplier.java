package net.preibisch.bdvshare.core.bdv.loader;

import net.preibisch.bdvshare.api.BDVShareable;
import net.preibisch.bdvshare.core.ui.FileInputPopup;

import java.io.File;
import java.io.Serializable;

public abstract class AbstractLoadSupplier implements Serializable {
    protected final String uri;

    public abstract BDVShareable open();
    AbstractLoadSupplier(String uri){
         this.uri = uri;
     }

     public String checkOrGet(){
         File file = new File(uri);
         if (file.exists())
             return uri;
         return FileInputPopup.get("File not found, Please Select: ");
     }
}
