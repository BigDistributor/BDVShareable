package org.mzouink.bdvshare.core.serialization;

import bdv.BigDataViewer;

import java.io.Serializable;

public class ViewerStateSupplier implements Serializable {
    public static ViewerStateSupplier fromBDV(BigDataViewer bdv) {
        return new ViewerStateSupplier();
    }
}
