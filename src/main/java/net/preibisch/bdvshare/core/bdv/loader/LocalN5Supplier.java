package net.preibisch.bdvshare.core.bdv.loader;

import net.preibisch.bdvshare.api.BDVShareable;

public class LocalN5Supplier extends AbstractLoadSupplier {
    LocalN5Supplier(String uri) {
        super(uri);
    }

    @Override
    public BDVShareable open() {
        return null;
    }
}
