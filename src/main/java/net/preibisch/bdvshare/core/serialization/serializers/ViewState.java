package net.preibisch.bdvshare.core.serialization.serializers;

import bdv.tools.brightness.ConverterSetup;
import net.imglib2.type.numeric.ARGBType;

import java.io.Serializable;

public class ViewState implements Serializable {
    final private int setupid;
    final private ARGBType color;
    final private double min;
    final private double max;


    public ViewState(int setupId, ARGBType color, double min, double max) {
        this.setupid = setupId;
        this.color = color;
        this.min = min;
        this.max = max;
    }

    public ViewState(ConverterSetup setup){
        this(setup.getSetupId(),setup.getColor(),setup.getDisplayRangeMin(),setup.getDisplayRangeMax());
    }

    public void update(ConverterSetup setup){
        if(setup.getSetupId()!= setupid){
            System.out.println("Wrong setupID "+setup.getSetupId()+" vs "+setup);
            return;
        }
        setup.setColor(color);
        setup.setDisplayRange(min,max);
        return;
    }
}
