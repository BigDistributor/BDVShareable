package org.mzouink.bdvshare.core.serialization;

import bdv.BigDataViewer;
import bdv.tools.brightness.ConverterSetup;
import net.imglib2.realtransform.AffineTransform3D;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewerStateSupplier implements Serializable {
    private final AffineTransform3D currentTransformation;
    private final Map<Integer, ViewState> viewStates;

    public ViewerStateSupplier(BigDataViewer bdv) {
        viewStates = new HashMap<>();
        this.currentTransformation = bdv.getViewer().state().getViewerTransform();
        List<ConverterSetup> converters = bdv.getConverterSetups().getConverterSetups(bdv.getViewer().state().getSources());
        for (ConverterSetup converter : converters) {
            viewStates.put(converter.getSetupId(), new ViewState(converter));
        }
    }

    public static ViewerStateSupplier fromBDV(BigDataViewer bdv) {
        return new ViewerStateSupplier(bdv);
    }

    public void setTo(BigDataViewer bdv) {
        bdv.getViewer().setCurrentViewerTransform(currentTransformation);

        List<ConverterSetup> converters = bdv.getConverterSetups().getConverterSetups(bdv.getViewer().state().getSources());
        for (ConverterSetup converter : converters) {
            viewStates.get(converter.getSetupId()).update(converter);
        }

    }
}
