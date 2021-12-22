package org.mzouink.bdvshare.core.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.mzouink.bdvshare.core.bdv.loader.AbstractLoadSupplier;
import org.mzouink.bdvshare.core.bdv.loader.LoaderSupplier;
import org.mzouink.bdvshare.core.bdv.loader.LoaderType;

import java.lang.reflect.Type;

public class LoaderSupplierDeserializer implements JsonDeserializer<LoaderSupplier> {

    @Override
    public LoaderSupplier deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String loaderType = jsonObject.get("loaderType").getAsString();
        System.out.println("Loader Type: "+loaderType);
        AbstractLoadSupplier loader = new Gson().fromJson(jsonObject.get("loader").getAsJsonObject(), LoaderType.forName(loaderType).getLoaderClass());
        return LoaderSupplier.fromLoader(loader);
    }
}
