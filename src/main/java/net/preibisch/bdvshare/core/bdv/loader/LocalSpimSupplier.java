package net.preibisch.bdvshare.core.bdv.loader;

import net.preibisch.bdvshare.api.BDVShareable;

public class LocalSpimSupplier extends AbstractLoadSupplier {

    LocalSpimSupplier(String uri) {
        super(uri);
    }

    @Override
    public BDVShareable open() {
        return null;
    }
}
