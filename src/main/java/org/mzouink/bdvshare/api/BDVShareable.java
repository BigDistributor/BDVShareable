package org.mzouink.bdvshare.api;

import bdv.BigDataViewer;
import com.amazonaws.regions.Regions;
import com.bigdistributor.aws.data.CredentialSupplier;
import com.bigdistributor.aws.dataexchange.aws.s3.func.auth.AWSCredentialInstance;
import net.preibisch.mvrecon.fiji.spimdata.explorer.popup.BDVPopup;
import org.mzouink.bdvshare.core.bdv.loader.AWSN5Supplier;
import org.mzouink.bdvshare.core.bdv.loader.AWSSpimSupplier;

import javax.swing.*;

public class BDVShareable {
    final private BigDataViewer bdv;

    private BDVShareable(BigDataViewer bdv) {
        this.bdv = bdv;
        JMenuItem shareButton = new JMenuItem("Share");
        shareButton.addActionListener(e -> share());
        bdv.getViewerFrame().getJMenuBar().add(shareButton);
       refresh();
    }

    private void refresh() {
        bdv.getViewerFrame().revalidate();
        bdv.getViewerFrame().repaint();
    }

    public static BDVShareable openSpim(AWSSpimSupplier supplier){
        return new BDVShareable(BDVPopup.createBDV(supplier.getData(),"Data"));

    }
    public static BDVShareable openN5(AWSN5Supplier supplier){
        return null;
    }

    public String share(){
        System.out.println("Hello from share");
        return null;};

    public static BDVShareable fromID(String id){return null;}

    public static void main(String[] args) {
        String uri ="s3://marwan-test-new/dataset-n5.xml";
        AWSCredentialInstance.init("/Users/Marwan/Desktop/BigDistributer/aws_credentials/bigdistributer.csv");
        CredentialSupplier cred = new CredentialSupplier(AWSCredentialInstance.get().getAWSAccessKeyId(), AWSCredentialInstance.get().getAWSSecretKey(), Regions.EU_CENTRAL_1.getName());

        BDVShareable bdvShareable = BDVShareable.openSpim(new AWSSpimSupplier(cred,uri));
    }
}
