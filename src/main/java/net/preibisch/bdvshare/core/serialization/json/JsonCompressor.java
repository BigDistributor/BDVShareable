package net.preibisch.bdvshare.core.serialization.json;

import com.github.diogoduailibe.lzstring4j.LZString;

import java.io.IOException;

public class JsonCompressor {

    public static void main(String[] args) throws IOException {
        String test = "{'viewerStateSupplier':{'currentTransformation':[1.1311154598825832,0.0,0.0,661.0420276966709,0.0,1.1311154598825832,0.0,802.7722050716209,0.0,0.0,1.1311154598825832,0.40193749403698487],'viewStates':{'0':{'setupid':0,'color':-1,'min':20.0,'max':130.0},'1':{'setupid':1,'color':-1,'min':20.0,'max':130.0},'2':{'setupid':2,'color':-1,'min':20.0,'max':130.0},'3':{'setupid':3,'color':-1,'min':20.0,'max':130.0},'4':{'setupid':4,'color':-1,'min':20.0,'max':130.0},'5':{'setupid':5,'color':-1,'min':20.0,'max':130.0},'6':{'setupid':6,'color':-1,'min':20.0,'max':130.0},'7':{'setupid':7,'color':-1,'min':20.0,'max':130.0},'8':{'setupid':8,'color':-1,'min':20.0,'max':130.0},'9':{'setupid':9,'color':-1,'min':20.0,'max':130.0},'10':{'setupid':10,'color':-1,'min':20.0,'max':130.0},'11':{'setupid':11,'color':-1,'min':20.0,'max':130.0},'12':{'setupid':12,'color':-1,'min':20.0,'max':130.0},'13':{'setupid':13,'color':-1,'min':20.0,'max':130.0},'14':{'setupid':14,'color':-1,'min':20.0,'max':130.0},'15':{'setupid':15,'color':-1,'min':20.0,'max':130.0},'16':{'setupid':16,'color':-1,'min':20.0,'max':130.0},'17':{'setupid':17,'color':-1,'min':20.0,'max':130.0}}},'loaderSupplier':{'loaderType':'spim','loader':{'cred':{'credPublicKey':'AKIAX66ZTWMMOEIJL4W7','credPrivateKey':'bGNJfO03iPHNrhRU9koAzbxyE2AZ9oK2kMMVGyxy','region':'eu-central-1'},'uri':'s3://marwan-test-new/dataset-n5.xml'}}}";
//        test = "Lets see how much we can compress this string!";

        String output = LZString.compress(test);

        System.out.println("Compressed: " + output);

        String decompressed = LZString.decompress(output);

        System.out.println("Decompressed: " + decompressed);
    }
}
