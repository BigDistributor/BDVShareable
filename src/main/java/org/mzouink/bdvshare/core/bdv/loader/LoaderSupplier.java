package org.mzouink.bdvshare.core.bdv.loader;

import java.io.Serializable;

public class LoaderSupplier implements Serializable {
final private String loaderType;
final private AbstractLoadSupplier loader;

    private LoaderSupplier(String loaderType, AbstractLoadSupplier loader) {
        this.loaderType = loaderType;
        this.loader = loader;
    }

    public static LoaderSupplier fromLoader(AbstractLoadSupplier loader){
        LoaderType loaderType = LoaderType.forClass(loader.getClass());
        return new LoaderSupplier(loaderType.getName(),loader);
    }

    public LoaderType getLoaderType(){
        return LoaderType.forName(loaderType);
    }
}
