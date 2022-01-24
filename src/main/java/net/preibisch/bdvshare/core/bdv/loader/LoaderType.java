package net.preibisch.bdvshare.core.bdv.loader;

public enum LoaderType {
    AWSSpimLoader("aws-spim", AWSSpimSupplier.class),
    AWSN5Loader("aws-n5", AWSN5Supplier.class),
    LocalSpimLoader("local-spim", LocalSpimSupplier.class),
    LocalN5Loader("local-n5", LocalN5Supplier.class);

    private final String name;
    private final Class<? extends AbstractLoadSupplier> loaderClass;

    LoaderType(String name, Class<? extends AbstractLoadSupplier> loaderClass) {
        this.name = name;
        this.loaderClass = loaderClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends AbstractLoadSupplier> getLoaderClass() {
        return loaderClass;
    }

    public static LoaderType forName(String name) {
        for (LoaderType d : LoaderType.values()) {
            if (d.getName().equals(name))
                return d;
        }
        return null;
    }

    public static LoaderType forClass(Class<? extends AbstractLoadSupplier> loaderClass) {
        for (LoaderType d : LoaderType.values()) {
            if (d.getLoaderClass().equals(loaderClass))
                return d;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(LoaderType.forName("n5").getLoaderClass());

    }
}
