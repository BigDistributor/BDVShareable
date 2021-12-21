package org.mzouink.bdvshare.core.api;

import org.mzouink.bdvshare.core.SETTINGS;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class RESTGet {
    private static final String get = "get";
    private static final String param = "id";

    public static String getJson(String id) {
        try {
            final Client client = ClientBuilder.newClient();
            final String REST_URI
                    = SETTINGS.LINK+get;
            System.out.println(client.target(REST_URI).queryParam(param,id).getUri());
            return client
                    .target(REST_URI)
                    .queryParam(param,id)
                    .request(MediaType.TEXT_PLAIN).get(String.class);
        }catch (Exception e){
            System.out.println("Error: "+e);
            return null;
        }

    }

    public static void main(String[] args)  {
//        System.out.println(RESTGet.getJson(""));
        System.out.println(RESTGet.getJson("0H0v"));
        System.out.println(RESTGet.getJson("vPbF"));
        System.out.println(RESTGet.getJson("0H0v"));
    }

}
