package org.mzouink.bdvshare.core.bdv.loader;

import com.bigdistributor.aws.data.CredentialConfig;
import com.bigdistributor.aws.data.CredentialSupplier;

import java.io.Serializable;

public abstract class AbstractLoadSupplier implements Serializable {
    protected final CredentialSupplier cred;
    protected final String uri;

    AbstractLoadSupplier(CredentialSupplier cred,String uri){
         this.cred = cred;
         this.uri = uri;
         CredentialConfig.set(cred);
     }
}
