package com.stockbolt.android.util;


import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import io.realm.RealmObject;

/**
 * Created by Jenson on 6/9/16.
 */
public class GsonUtil {

    /*static TypeAdapterFactory resultTypeAdapter = new TypeAdapterFactory() {
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

            if (!type.getType().equals(Result.class))
                return null;

            return new TypeAdapter<T>() {
                @Override
                public T read(JsonReader reader) throws IOException {

                    JsonElement tree = elementAdapter.read(reader);
                    boolean success = tree.getAsJsonObject().get("success").getAsBoolean();
                    String data = tree.getAsJsonObject().get("data").toString();
                    JsonElement error = tree.getAsJsonObject().get("error");
                    if (tree == null)
                        return delegate.fromJsonTree(tree);

                    Result result = new Result();
                    result.setSuccess(success);
                    result.setData(data);
                    result.setError(new Error(error == null ? null : error.getAsString()));
                    return (T) result;
                }

                @Override
                public void write(JsonWriter writer, T obj) throws IOException {
                    delegate.write(writer, obj);
                }
            };
        }
    };*/

    public static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                });
        // register the deserializer
/*
        gsonBuilder.registerTypeAdapter(new TypeToken<RealmList<RealmString>>() {
        }.getType(), new RealmStringDeserializer());

        gsonBuilder.registerTypeAdapter(new TypeToken<RealmLocale>() {
        }.getType(), new RealmLocaleDeserializer());
*/

        gsonBuilder.registerTypeAdapter(new TypeToken<Date>() {
        }.getType(), new DateGsonDeserializer());

//        gsonBuilder.registerTypeAdapter(Result.class, new ResultDeserializer());
//        gsonBuilder.registerTypeAdapterFactory(resultTypeAdapter);

        return gsonBuilder.create();
    }


   /* public static class RealmStringDeserializer implements
            JsonDeserializer<RealmList<RealmString>> {

        @Override
        public RealmList<RealmString> deserialize(JsonElement json, Type typeOfT,
                                                  JsonDeserializationContext context) throws JsonParseException {

            RealmList<RealmString> realmStrings = new RealmList<>();
            JsonArray stringList = json.getAsJsonArray();

            for (JsonElement stringElement : stringList) {
                realmStrings.add(new RealmString(stringElement.getAsString()));
            }

            return realmStrings;
        }
    }*/

    /*public static class RealmMapDeserializer implements
            JsonDeserializer<RealmMapString> {

        @Override
        public RealmMapString deserialize(JsonElement json, Type typeOfT,
                                          JsonDeserializationContext context) throws JsonParseException {

            JsonObject jsonValue = json.getAsJsonObject();

            RealmMapString mapString = new RealmMapString();

            for (Map.Entry<String, JsonElement> entry : jsonValue.entrySet()) {
                mapString.setKey(entry.getKey());
                mapString.setValue(entry.getValue().getAsString());
            }

            return mapString;
        }
    }*/

   /* public static class RealmLocaleDeserializer implements
            JsonDeserializer<RealmLocale> {

        @Override
        public RealmLocale deserialize(JsonElement json, Type typeOfT,
                                       JsonDeserializationContext context) throws JsonParseException {

            JsonObject jsonValue = json.getAsJsonObject();

            RealmLocale rlocale = new RealmLocale();

            for (Map.Entry<String, JsonElement> entry : jsonValue.entrySet()) {
                switch (entry.getKey()) {
                    case "en":
                        rlocale.setEn(entry.getValue().getAsString());
                        break;
                    case "zh":
                        rlocale.setZh(entry.getValue().getAsString());
                        break;
                }
            }
            return rlocale;
        }
    }*/

    public static class DateGsonDeserializer implements JsonDeserializer<Date> {

        private static final String[] DATE_FORMATS = new String[]{
                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
                "yyyy-MM-dd"
        };

        @Override
        public Date deserialize(JsonElement jsonElement, Type typeOF,
                                JsonDeserializationContext context) throws JsonParseException {
            for (String format : DATE_FORMATS) {
                try {
                    return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
                } catch (ParseException e) {
                }
            }
            throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                    + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
        }
    }
//    public static class RawJsonTypeAdapter extends TypeAdapter<Result> {
//
//        @Override
//        public void write(JsonWriter out, Result value) throws IOException {
//
//        }
//
//        @Override
//        public Result read(final JsonReader in) throws IOException {
//            final Result result = new Result();
//            System.out.print("RawJsonTypeAdapter read:"+in.hasNext());
//            in.beginObject();
//            while (in.hasNext()) {
//                switch (in.nextName()) {
//                    case "success":
//                        result.setSuccess(in.nextBoolean());
//                        break;
//                    case "data":
//                        result.setData(in.nextString());
//                        break;
//                    case "error":
//                        result.setError(new Error(in.nextString()));
//                        break;
//                }
//            }
//            in.endObject();
//            return result;
//        }
//    }

//    public static class ResultDeserializer implements JsonDeserializer<Result> {
//
//        @Override
//        public Result deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
//                throws JsonParseException {
//            final JsonObject jsonObject = json.getAsJsonObject();
//            JsonElement error = json.getAsJsonObject().get("error");
//
//            final Result result = new Result();
//            result.setSuccess(jsonObject.get("success").getAsBoolean());
//            result.setData(jsonObject.get("data").toString());
//            result.setError(new Error(error == null ? null : error.getAsString()));
//
//            return result;
//        }
//}
}
