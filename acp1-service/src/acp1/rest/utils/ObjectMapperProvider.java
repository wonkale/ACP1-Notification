package acp1.rest.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

/**
 * Created by mohammed al-ani on 1/23/2017.
 */
public class ObjectMapperProvider {

    private ObjectMapper mapper = null;

    private static ObjectMapperProvider instance;

    private ObjectMapperProvider() {
        this.mapper = new ObjectMapper();

        // Java8 Date support
        mapper.registerModule(new JSR310Module());

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public static ObjectMapper get() {
        if (instance == null) {
            instance = new ObjectMapperProvider();
        }

        return instance.mapper.copy();
    }
}
