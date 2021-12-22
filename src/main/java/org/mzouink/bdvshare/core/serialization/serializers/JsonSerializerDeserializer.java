package org.mzouink.bdvshare.core.serialization.serializers;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public interface JsonSerializerDeserializer<T> extends JsonSerializer<T>, JsonDeserializer<T> {
}