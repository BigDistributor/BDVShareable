package org.mzouink.bdvshare.core.bdv.loader;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3URI;
import com.bigdistributor.aws.data.CredentialConfig;
import com.bigdistributor.aws.data.CredentialSupplier;
import com.bigdistributor.aws.dataexchange.aws.s3.func.auth.AWSCredentialInstance;
import org.janelia.saalfeldlab.n5.s3.N5AmazonS3Reader;

import java.io.IOException;

public class TestN5AWSLoader {
    public static void main(String[] args) throws IOException {

        String uri = "s3://marwan-test-new/dataset.n5";
         AWSCredentialInstance.init("/Users/Marwan/Desktop/BigDistributer/aws_credentials/bigdistributer.csv");
        CredentialConfig.set(new CredentialSupplier(AWSCredentialInstance.get().getAWSAccessKeyId(),AWSCredentialInstance.get().getAWSSecretKey(), Regions.EU_CENTRAL_1.getName()));

        System.out.println(CredentialSupplier.get());
        N5AmazonS3Reader reader = new N5AmazonS3Reader(CredentialSupplier.get().getS3(), new AmazonS3URI(uri));
        System.out.println(reader.getVersion());
    }
}
