package net.preibisch.bdvshare.core.serialization.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import net.imglib2.Interval;
import net.preibisch.mvrecon.fiji.spimdata.boundingbox.BoundingBox;

import java.lang.reflect.Type;

public class IntervalSerializer implements JsonSerializerDeserializer<Interval> {

    @Override
    public Interval deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return new Gson().fromJson(json, BoundingBox.class);
    }

    @Override
    public JsonElement serialize(Interval src, Type type, JsonSerializationContext context) {
        BoundingBox vs = new BoundingBox(src);
        JsonElement x = new GsonBuilder().create().toJsonTree(vs);
        return x;
    }

}
