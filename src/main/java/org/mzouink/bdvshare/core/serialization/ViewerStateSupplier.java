package org.mzouink.bdvshare.core.serialization;

import bdv.BigDataViewer;

import java.io.Serializable;

public class ViewerStateSupplier implements Serializable {
    public ViewerStateSupplier(BigDataViewer bdv) {
//        List
//        // Get all transformations
//        tmpTransform  = new AffineTransform3D();
//        bdv.getSources().get(currentSource).getSpimSource().getSourceTransform(0, 0, tmpTransform);
    }

    public static ViewerStateSupplier fromBDV(BigDataViewer bdv) {
        return new ViewerStateSupplier(bdv);
    }

    public void setTo(BigDataViewer bdv) {
    }
}
