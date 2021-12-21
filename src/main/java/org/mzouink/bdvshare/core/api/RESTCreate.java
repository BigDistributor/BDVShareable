package org.mzouink.bdvshare.core.api;

import org.mzouink.bdvshare.core.SETTINGS;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RESTCreate {
    private static final String create = "create";

    public static String post(String json) throws Exception {
        final Client client = ClientBuilder.newClient();
        final String REST_URI
                = SETTINGS.LINK + create;
        Response response = client
                .target(REST_URI)
                .request(MediaType.TEXT_PLAIN)
                .post(Entity.entity(json, MediaType.TEXT_PLAIN));
        if (response.getStatus() == Response.Status.OK.getStatusCode())
            return response.readEntity(String.class);
        else throw new Exception("Not Created! "+Response.Status.fromStatusCode(response.getStatus())) ;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(RESTCreate.post("hello"));
        System.out.println(RESTCreate.post("hello2"));
        System.out.println(RESTCreate.post("hello2"));
    }

}
