package com.example.sjdeuces.hackucsc;

/**
 * Created by SJDeuces on 1/31/16.
 */
import com.example.sjdeuces.hackucsc.DiningHall;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

public class DiningHallDeserializer implements JsonDeserializer <DiningHall>{
    @Override
    public DiningHall deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final DiningHall hall = new DiningHall();
        JsonObject total_obj = json.getAsJsonObject();
        hall.Name = total_obj.get("Name").getAsString();
        //hall.Breakfast = total_obj.get("Breakfast");

        return hall;
    }
}
