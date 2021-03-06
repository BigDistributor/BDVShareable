package net.preibisch.bdvshare.core.bdv.loader;

import com.amazonaws.regions.Regions;
import com.bigdistributor.aws.data.CredentialConfig;
import com.bigdistributor.aws.data.CredentialSupplier;
import com.bigdistributor.aws.dataexchange.aws.s3.func.auth.AWSCredentialInstance;
import com.bigdistributor.aws.spimloader.AWSSpimLoader;
import net.preibisch.bdvshare.api.BDVShareable;
import net.preibisch.mvrecon.fiji.spimdata.SpimData2;

public class AWSSpimSupplier extends RemoteLoadSupplier {
    @Override
    public BDVShareable open() {
        return BDVShareable.openSpim(this);
    }

    public AWSSpimSupplier(CredentialSupplier cred, String uri) {
        super(cred, uri);
    }

    public SpimData2 getData() {
        CredentialConfig.set(cred);
        AWSSpimLoader loader = AWSSpimLoader.init(cred.getS3(), uri);
        return loader.getSpimdata();
    }

    public static void main(String[] args) {
        String uri = "s3://marwan-test-new/dataset-n5.xml";
        AWSCredentialInstance.init("/Users/Marwan/Desktop/BigDistributer/aws_credentials/bigdistributer.csv");
        CredentialSupplier cred = new CredentialSupplier(AWSCredentialInstance.get().getAWSAccessKeyId(), AWSCredentialInstance.get().getAWSSecretKey(), Regions.EU_CENTRAL_1.getName());

        System.out.println(new AWSSpimSupplier(cred, uri).getData().toString());
    }
}
