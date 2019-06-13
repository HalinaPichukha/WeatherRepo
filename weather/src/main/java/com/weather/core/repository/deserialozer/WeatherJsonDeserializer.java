package com.weather.core.repository.deserialozer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.weather.core.entity.WeatherEntity;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class WeatherJsonDeserializer extends JsonDeserializer<WeatherEntity> {

  @Override
  public WeatherEntity deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

    WeatherEntity weather = new WeatherEntity();

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);
    JsonNode list = node.get("list");

    Consumer<JsonNode> data =
        (JsonNode noded) -> {
          if (noded.has("name")) {
            weather.setName(noded.get("name").asText());
          }
          if (noded.has("main")) {
            JsonNode main = noded.get("main");
            weather.setTempMin(main.get("temp_min").asText());
          }
          if (noded.has("main")) {
            JsonNode main = noded.get("main");
            weather.setTempMax(main.get("temp_max").asText());
          }
          if (noded.has("wind")) {
            JsonNode main = noded.get("wind");
            weather.setSpeed(main.get("speed").asText());
          }
          if (noded.has("rain")) {
            weather.setRain(noded.get("rain").asText());
          }
          if (noded.has("snow")) {
            weather.setSnow(noded.get("snow").asText());
          }
          if (noded.has("weather")) {
            for (JsonNode weatherNode : noded.get("weather")) {
              if (weatherNode.has("description")) {
                weather.setDescription(weatherNode.get("description").asText());
              }
            }
          }
        };

    list.forEach(data);

    Stream.of(list)
        .filter(n -> n.has("name"))
        .forEach(nn -> weather.setName(nn.get("name").asText())
        );

    return weather;
  }
}