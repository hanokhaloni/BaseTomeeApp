/**
 * Created by IntelliJ IDEA.
 * User: Aviram Dayan
 * Date: 23/12/12
 * Time: 15:58
 *
 *<a href=mailto:avdayan@cs.bgu.ac.il>avdayan@cs.bgu.ac.il</a>
 */
package com.scouter.commons.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GsonProvider implements MessageBodyWriter<Object>, MessageBodyReader<Object> {

    private final Gson gson;

    public GsonProvider() {

        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                .create();
    }

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public void writeTo(
        Object t,
        Class<?> aClass,
        Type genericType,
        Annotation[] annotations,
        MediaType mediaType,
        MultivaluedMap<String, Object> stringObjectMultivaluedMap,
        OutputStream entityStream
    ) throws IOException {
        String json = gson.toJson(t);

        entityStream.write(json.getBytes());

//        OutputStreamWriter writer = new OutputStreamWriter(entityStream, UTF_8);


//        try {
//            Type jsonType;
//            if (type.equals(genericType)) {
//                jsonType = type;
//            } else {
//                jsonType = genericType;
//            }
//            getGson().toJson(object, jsonType, writer);
//        } finally {
//            writer.close();
//        }
    }

    @Override
    public long getSize(Object o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public Object readFrom(
        Class<Object> objectClass,
        Type type,
        Annotation[] annotations,
        MediaType mediaType,
        MultivaluedMap<String, String> stringStringMultivaluedMap,
        InputStream inputStream
    ) throws IOException, WebApplicationException {

        Reader reader = new InputStreamReader(inputStream);


        // objectClass | type              | What to use?
        // ------------+-------------------+------------------
        // AppEntity   | AppEntity         | use any
        // Object      | GenericArrayType  | use type
        // Object      | ParameterizedType | use type
        // Object      | TypeVariable<D>   | use type
        // Object      | WildcardType      | use type
        // String      | Object            | use objectClass
        // Integer     | Object ?          | use objectClass


        try {
            Type jsonType;

            //This If exists because Type implements Class interface.
            if (objectClass.equals(type)) {
                jsonType = objectClass;
            } else {
                jsonType = type;
            }
            return getGson().fromJson(reader, jsonType);
        } finally {
            reader.close();
        }
    }

    public Gson getGson() {
        return gson;
    }
}