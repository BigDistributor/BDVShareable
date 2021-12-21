package org.mzouink.bdvshare.core.bdv.loader;

import com.amazonaws.regions.Regions;
import com.bigdistributor.aws.dataexchange.aws.s3.func.auth.AWSCredentialInstance;
import com.bigdistributor.aws.dataexchange.aws.s3.func.bucket.S3BucketInstance;
import com.bigdistributor.aws.spimloader.AWSSpimLoader;
import net.preibisch.mvrecon.fiji.spimdata.SpimData2;

public class TestLoader {
    public static void main(String[] args) throws IllegalAccessException {
        AWSCredentialInstance.init("/Users/Marwan/Desktop/BigDistributer/aws_credentials/bigdistributer.csv");
        S3BucketInstance.init(AWSCredentialInstance.get(), Regions.EU_CENTRAL_1, "marwan-test-new", "");
        AWSSpimLoader loader = AWSSpimLoader.init(S3BucketInstance.get().getS3(), "s3://marwan-test-new/dataset-n5.xml");
        SpimData2 data = loader.getSpimdata();
        System.out.println(data.toString());
    }
}
