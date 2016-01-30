package com.andika;

import com.andika.models.*;
import com.andika.payloads.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;

import java.io.IOException;
import java.io.StringWriter;

import static spark.Spark.*;

public class MainApp {

    private static final int HTTP_BAD_REQUEST = 400;

    public static void main(String[] args) {

        Model model = new Model();

        post("/story", (request, response) -> {
            try {
                ObjectMapper mapper = new ObjectMapper();
                NewStoryPayload creation = mapper.readValue(request.body(), NewStoryPayload.class);
                if (!creation.isValid()) {
                    response.status(HTTP_BAD_REQUEST);
                    return "";
                }

                int id = model.createStory(creation.getOwner(),
                        creation.getLength(), 
                        creation.getPhraseLength(),
                        creation.getQuorum());

                response.status(200);
                response.type("application/json");
                return id;
            } catch (JsonParseException jpe) {
                response.status(HTTP_BAD_REQUEST);
                return "";
            }
        });


        get("/story", (request, response) -> {
            response.status(200);
            response.type("application/json");
            return dataToJson(model.getAllStories());
        });
    }

    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, data);
            return sw.toString();
        } catch (IOException e) {
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }
}