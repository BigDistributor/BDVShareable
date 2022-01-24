package net.preibisch.bdvshare.core.serialization;

import com.amazonaws.regions.Regions;
import com.bigdistributor.aws.data.CredentialSupplier;
import com.bigdistributor.aws.dataexchange.aws.s3.func.auth.AWSCredentialInstance;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mpicbg.spim.data.sequence.ViewId;
import net.imglib2.Interval;
import net.imglib2.realtransform.AffineTransform3D;
import net.imglib2.type.numeric.ARGBType;
import net.preibisch.bdvshare.api.BDVShareable;
import net.preibisch.bdvshare.core.serialization.serializers.AffineTransform3DJsonSerializer;
import net.preibisch.bdvshare.core.serialization.serializers.IntervalSerializer;
import net.preibisch.bdvshare.core.serialization.serializers.LoaderSupplierDeserializer;
import net.preibisch.bdvshare.core.serialization.serializers.ViewIdJsonSerializer;
import net.preibisch.bdvshare.core.bdv.loader.AWSSpimSupplier;
import net.preibisch.bdvshare.core.bdv.loader.LoaderSupplier;
import net.preibisch.bdvshare.core.serialization.serializers.ARGBTypeSerializer;

import java.io.Serializable;

public class ViewerInfoSupplier implements Serializable {
    private final ViewerStateSupplier viewerStateSupplier;
    private final LoaderSupplier loaderSupplier;

    public ViewerInfoSupplier(LoaderSupplier loaderSupplier, ViewerStateSupplier viewerStateSupplier) {
        this.loaderSupplier = loaderSupplier;
        this.viewerStateSupplier = viewerStateSupplier;
    }

    public LoaderSupplier getLoaderSupplier() {
        return loaderSupplier;
    }

    public ViewerStateSupplier getViewerStateSupplier() {
        return viewerStateSupplier;
    }

    public String toJson() {
        return getGson().toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }

    public static ViewerInfoSupplier fromJson(String json) {
        return getGson().fromJson(json, ViewerInfoSupplier.class);
    }

    private static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls().serializeSpecialFloatingPointValues();
        gsonBuilder.registerTypeAdapter(LoaderSupplier.class, new LoaderSupplierDeserializer());
        gsonBuilder.registerTypeAdapter(AffineTransform3D.class, new AffineTransform3DJsonSerializer());
        gsonBuilder.registerTypeAdapter(ViewId.class, new ViewIdJsonSerializer());
        gsonBuilder.registerTypeAdapter(Interval.class, new IntervalSerializer());
        gsonBuilder.registerTypeAdapter(ARGBType.class, new ARGBTypeSerializer());
        return gsonBuilder.create();
    }

    public static void main(String[] args) {

        String uri = "s3://marwan-test-new/dataset-n5.xml";
        AWSCredentialInstance.init("/Users/Marwan/Desktop/BigDistributer/aws_credentials/bigdistributer.csv");
        CredentialSupplier cred = new CredentialSupplier(AWSCredentialInstance.get().getAWSAccessKeyId(), AWSCredentialInstance.get().getAWSSecretKey(), Regions.EU_CENTRAL_1.getName());

        LoaderSupplier loaderSupplier = LoaderSupplier.fromLoader(new AWSSpimSupplier(cred, uri));
        BDVShareable bdvShareable = BDVShareable.openSpim(new AWSSpimSupplier(cred, uri));
        ViewerStateSupplier infoSupplier = new ViewerStateSupplier(bdvShareable.getBdv());

        ViewerInfoSupplier viewerInfoSupplier = new ViewerInfoSupplier(loaderSupplier, infoSupplier);
        System.out.println("Viewer info supplier created !");
        String json = viewerInfoSupplier.toJson();
        System.out.println(json);

        ViewerInfoSupplier viewerInfoSupplier2 = ViewerInfoSupplier.fromJson(json);
        System.out.println(viewerInfoSupplier2);

    }
}
