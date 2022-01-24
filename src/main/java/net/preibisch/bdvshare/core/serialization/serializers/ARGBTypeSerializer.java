package net.preibisch.bdvshare.core.serialization.serializers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import net.imglib2.type.numeric.ARGBType;

import java.lang.reflect.Type;

public class ARGBTypeSerializer implements JsonSerializerDeserializer<ARGBType> {

    @Override
    public ARGBType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        Integer val = new Gson().fromJson(json, Integer.class);
        return new ARGBType(val);
    }

    @Override
    public JsonElement serialize(ARGBType argbType, Type type, JsonSerializationContext jsonSerializationContext) {
        Integer val = argbType.get();
       return new Gson().toJsonTree(val);
    }

    public static void main(String[] args) {
        ARGBType color =new ARGBType(-16714241);
        System.out.println(color);
        Gson gson = new GsonBuilder().registerTypeAdapter(ARGBType.class, new ARGBTypeSerializer()).create();
        String json = gson.toJson(color);
        System.out.println(json);
        ARGBType color2 = gson.fromJson(json,ARGBType.class);
        System.out.println(color2);
    }
}
