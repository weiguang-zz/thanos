package com.thanos.portal.rest.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

  @Bean
  public ObjectMapper createObjectMapper() {
    return new CustomObjectMapper();
  }

  public static final class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
      super();

      SimpleModule customModule = new SimpleModule("CustomSimpleModule", Version.unknownVersion());
      // customModule.addSerializer(Date.class, new CustomDateSerializer());
      customModule.addSerializer(ObjectId.class, new ObjectIdSerializer());
      customModule.addDeserializer(ObjectId.class, new ObjectIdDeserializer());
      this.registerModule(customModule);
//      this.registerModule(new JsonOrgModule());

      this.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
      this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
      // Ignore unknown fields instead of throwing an exception
      this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      /*this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
      this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
          @Override
          public void serialize(
                  Object value,
                  JsonGenerator gen,
                  SerializerProvider sp) throws IOException, JsonProcessingException {
              gen.writeString("");
          }
      });*/
    }
  }

  private static final class ObjectIdSerializer extends JsonSerializer<ObjectId> {

    @Override
    public void serialize(ObjectId id, JsonGenerator gen, SerializerProvider serializers)
        throws IOException {
      if (id == null) {
        gen.writeNull();
      } else {
        gen.writeString(id.toHexString());
      }
    }
  }

  private static final class ObjectIdDeserializer extends JsonDeserializer<ObjectId> {

    @Override
    public ObjectId deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
      String value = parser.getText();
      if (value == null) {
        return null;
      } else {
        return new ObjectId(value);
      }
    }
  }
}
