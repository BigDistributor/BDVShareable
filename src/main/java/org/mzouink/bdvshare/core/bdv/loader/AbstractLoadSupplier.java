package org.mzouink.bdvshare.core.bdv.loader;

import com.bigdistributor.aws.data.CredentialConfig;
import com.bigdistributor.aws.data.CredentialSupplier;
import org.mzouink.bdvshare.api.BDVShareable;

import java.io.Serializable;

public abstract class AbstractLoadSupplier implements Serializable {
    protected final CredentialSupplier cred;
    protected final String uri;

    public abstract BDVShareable open();
    AbstractLoadSupplier(CredentialSupplier cred,String uri){
         this.cred = cred;
         this.uri = uri;
         CredentialConfig.set(cred);
     }
}
