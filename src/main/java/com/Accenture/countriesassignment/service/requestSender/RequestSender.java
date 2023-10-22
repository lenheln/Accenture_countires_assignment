package com.Accenture.countriesassignment.service.requestSender;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

@Component
public class RequestSender implements IRequestSender {

    private static final Logger log = Logger.getLogger(RequestSender.class.getName());
    private static final int STATUS_CODE_OK = 200;

    @Override
    public String send(String url) {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != STATUS_CODE_OK)
                log.warning(String.format("Request can't be performed. Status: %d Response: %s", response.statusCode(), response.body()));
            else
                return response.body();
        } catch (IOException | InterruptedException e) {
            log.warning("Request can't be performed. " + e.getMessage());
        }

        return "";
    }
}
