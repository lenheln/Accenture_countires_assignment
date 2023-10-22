package com.Accenture.countriesassignment.service.requestSender;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestSenderTest {

    @Autowired
    private RequestSender requestSender;
    private MockWebServer mockWebServer;

    private static String EMPTY_RESPONSE = "";
    private static String VALID_RESPONSE = "\"{\\\"id\\\":\\\"1\\\",\\\"name\\\":\\\"Germany\\\"}\"";

    @BeforeEach
    void initService() {
        this.mockWebServer = new MockWebServer();
    }

    @Test
    public void shouldReturnEmptyString_whenResponseStatus500() {
        mockWebServer.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setResponseCode(500));

        String result = requestSender.send(mockWebServer.url("/").toString());
        Assertions.assertEquals(EMPTY_RESPONSE, result);
    }

    @Test
    public void shouldReturnValidResponse_whenResponseStatus200() {
        mockWebServer.enqueue(new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody(VALID_RESPONSE)
                .setResponseCode(200));

        String result = requestSender.send(mockWebServer.url("/").toString());
        Assertions.assertEquals(VALID_RESPONSE, result);
    }

}
