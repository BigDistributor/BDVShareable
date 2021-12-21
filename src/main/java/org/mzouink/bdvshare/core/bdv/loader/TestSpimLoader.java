package org.mzouink.bdvshare.core.bdv.loader;

import com.amazonaws.regions.Regions;
import com.bigdistributor.aws.data.CredentialConfig;
import com.bigdistributor.aws.data.CredentialSupplier;
import com.bigdistributor.aws.dataexchange.aws.s3.func.auth.AWSCredentialInstance;
import com.bigdistributor.aws.spimloader.AWSSpimLoader;
import net.preibisch.mvrecon.fiji.spimdata.SpimData2;

public class TestSpimLoader {
    public static void main(String[] args) {
        AWSCredentialInstance.init("/Users/Marwan/Desktop/BigDistributer/aws_credentials/bigdistributer.csv");
        CredentialConfig.set(new CredentialSupplier(AWSCredentialInstance.get().getAWSAccessKeyId(),AWSCredentialInstance.get().getAWSSecretKey(), Regions.EU_CENTRAL_1.getName()));
        AWSSpimLoader loader = AWSSpimLoader.init(CredentialSupplier.get().getS3(), "s3://marwan-test-new/dataset-n5.xml");
        SpimData2 data = loader.getSpimdata();
        System.out.println(data.toString());
    }
}
