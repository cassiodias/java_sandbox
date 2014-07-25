package com.cassio.future.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cassio.future.example.AsyncTest;

public class AppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCase.class);
    private AsyncTest asyncTest;

    @Before
    public void setup() {
        asyncTest = new AsyncTest();
    }

    @Test
    public void happyPath() throws InterruptedException, ExecutionException {
        Future<String> futurePointer = asyncTest.fireAndForget();
        while (!futurePointer.isDone()) {
            LOGGER.debug("Still waiting...");
        }
        assertNotNull("future is null!", futurePointer);
        String response = futurePointer.get();
        assertNotNull("future response is null!", response);
        assertEquals("take your response...", response);
        LOGGER.debug(response);
    }

}
