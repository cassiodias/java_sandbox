package com.cassio.future.example.test;

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

public class AsyncTestTest {

    private static final String TAKE_YOUR_RESPONSE = "take your response...";
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCase.class);
    private AsyncTest asyncTest;

    @Before
    public void setup() {
        asyncTest = new AsyncTest();
    }

    @Test
    public void happyPath() throws InterruptedException, ExecutionException {
        Future<String> futurePointer = asyncTest.fireAndForget(5);
        while (!futurePointer.isDone()) {
            LOGGER.debug("Still waiting...");
        }
        assertNotNull("future is null!", futurePointer);
        String response = futurePointer.get();
        assertNotNull("future response is null!", response);
        assertEquals(TAKE_YOUR_RESPONSE, response);
        LOGGER.debug(response);
    }

    @Test
    public void waitingForTwoExecutions() throws InterruptedException, ExecutionException {
        Future<String> future1 = asyncTest.fireAndForget(5);
        Future<String> future2 = asyncTest.fireAndForget(10);
        while (!future1.isDone() && !future2.isDone()) {
            LOGGER.debug("Still waiting for both...");
        }

        while (future1.isDone() && !future2.isDone()) {
            LOGGER.debug("Still waiting for future 2...");
        }

        String response1 = future1.get();
        String response2 = future2.get();
        assertNotNull("future response 1 is null!", response1);
        assertEquals(TAKE_YOUR_RESPONSE, response1);
        assertNotNull("future response 2 is null!", response2);
        assertEquals(TAKE_YOUR_RESPONSE, response2);
        LOGGER.debug(response1 + " / " + response2);
    }

}
