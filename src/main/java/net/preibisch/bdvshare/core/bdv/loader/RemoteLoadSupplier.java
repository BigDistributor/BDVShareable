package net.preibisch.bdvshare.core.bdv.loader;

import com.bigdistributor.aws.data.CredentialConfig;
import com.bigdistributor.aws.data.CredentialSupplier;

public abstract class RemoteLoadSupplier extends AbstractLoadSupplier{
    protected final CredentialSupplier cred;
    RemoteLoadSupplier(CredentialSupplier cred,String uri){
        super(uri);
        this.cred = cred;
        CredentialConfig.set(cred);
    }
}
