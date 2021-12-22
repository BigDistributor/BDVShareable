package org.mzouink.bdvshare.core.serialization.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import mpicbg.spim.data.sequence.ViewId;

import java.lang.reflect.Type;

public class ViewIdJsonSerializer implements JsonSerializerDeserializer<ViewId> {

	@Override
	public ViewId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return new Gson().fromJson(json, ViewIdSerializable.class).toViewId();
	}

	@Override
	public JsonElement serialize(ViewId src, Type type, JsonSerializationContext context) {
		ViewIdSerializable vs = new ViewIdSerializable(src);
		JsonElement x = new GsonBuilder().create().toJsonTree(vs);
		return x;
	}

}
