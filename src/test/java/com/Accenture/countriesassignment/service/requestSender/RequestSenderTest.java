package com.Accenture.countriesassignment.service.requestSender;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest
public class RequestSenderTest {

    @Mock
    private HttpClient defaultHttpClient;
    @Mock
    private HttpResponse defaultResponse;
    @Autowired
    private RequestSender requestSender;

    @BeforeEach
    void initService() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void requestSenderReturnsNull_whenResponse400() throws IOException, InterruptedException {
        Mockito.when(defaultHttpClient.send(Mockito.any(HttpRequest.class), Mockito.any()))
                        .thenReturn(defaultResponse);
        Mockito.when(defaultResponse.statusCode()).thenReturn(400);
        Assertions.assertNull(requestSender.send("/"));

    }

}
