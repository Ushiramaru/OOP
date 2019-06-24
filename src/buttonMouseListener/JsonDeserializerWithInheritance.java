package buttonMouseListener;

import com.google.gson.*;
import java.lang.reflect.Type;

public class JsonDeserializerWithInheritance<Shape> implements JsonDeserializer<Shape> {

    @Override
    public Shape deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive classNamePrimitive = (JsonPrimitive) jsonObject.get("type");
        String className = classNamePrimitive.getAsString();

        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            return null;
        }
        return context.deserialize(jsonObject, clazz);
    }
}