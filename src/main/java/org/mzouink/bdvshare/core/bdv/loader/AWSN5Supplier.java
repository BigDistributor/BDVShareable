package org.mzouink.bdvshare.core.bdv.loader;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3URI;
import com.bigdistributor.aws.data.CredentialSupplier;
import com.bigdistributor.aws.dataexchange.aws.s3.func.auth.AWSCredentialInstance;
import org.janelia.saalfeldlab.n5.N5Reader;
import org.janelia.saalfeldlab.n5.s3.N5AmazonS3Reader;

import java.io.IOException;

public class AWSN5Supplier extends AbstractLoadSupplier {

    AWSN5Supplier(CredentialSupplier cred, String uri) {
        super(cred, uri);
    }

    public N5Reader getReader() throws IOException {
        return new N5AmazonS3Reader(cred.getS3(), new AmazonS3URI(uri));
    }

    public static void main(String[] args) throws IOException {
        String uri = "s3://marwan-test-new/dataset.n5";
        AWSCredentialInstance.init("/Users/Marwan/Desktop/BigDistributer/aws_credentials/bigdistributer.csv");
        CredentialSupplier cred = new CredentialSupplier(AWSCredentialInstance.get().getAWSAccessKeyId(), AWSCredentialInstance.get().getAWSSecretKey(), Regions.EU_CENTRAL_1.getName());
        AWSN5Supplier supplier = new AWSN5Supplier(cred, uri);
        System.out.println(supplier.getReader().getVersion());
    }
}
