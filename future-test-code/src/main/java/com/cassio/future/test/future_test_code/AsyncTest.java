package com.cassio.future.test.future_test_code;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Simple example of <Future> api.
 */
public class AsyncTest {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public Future<String> fireAndForget() {
        // send to new thread.
        return executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return "take your response...";
            }
        });
    }

}
