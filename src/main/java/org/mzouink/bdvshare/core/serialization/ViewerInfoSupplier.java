package org.mzouink.bdvshare.core.serialization;

import com.amazonaws.regions.Regions;
import com.bigdistributor.aws.data.CredentialSupplier;
import com.bigdistributor.aws.dataexchange.aws.s3.func.auth.AWSCredentialInstance;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mzouink.bdvshare.core.bdv.loader.AWSSpimSupplier;
import org.mzouink.bdvshare.core.bdv.loader.LoaderSupplier;

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

    public String toJson(){
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }

    public static ViewerInfoSupplier fromJson(String json){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LoaderSupplier.class,new LoaderSupplierDeserializer());
        return gsonBuilder.create().fromJson(json,ViewerInfoSupplier.class);
    }

    public static void main(String[] args) {

        String uri = "s3://marwan-test-new/dataset-n5.xml";
        AWSCredentialInstance.init("/Users/Marwan/Desktop/BigDistributer/aws_credentials/bigdistributer.csv");
        CredentialSupplier cred = new CredentialSupplier(AWSCredentialInstance.get().getAWSAccessKeyId(), AWSCredentialInstance.get().getAWSSecretKey(), Regions.EU_CENTRAL_1.getName());

        LoaderSupplier loaderSupplier = LoaderSupplier.fromLoader(new AWSSpimSupplier(cred, uri));
        ViewerStateSupplier infoSupplier = new ViewerStateSupplier();

        ViewerInfoSupplier viewerInfoSupplier = new ViewerInfoSupplier(loaderSupplier,infoSupplier);

        String json = viewerInfoSupplier.toJson();
        System.out.println(json);

        ViewerInfoSupplier viewerInfoSupplier2 = ViewerInfoSupplier.fromJson(json);
        System.out.println(viewerInfoSupplier2);

    }
}
