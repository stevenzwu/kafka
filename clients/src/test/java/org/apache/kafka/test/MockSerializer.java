package org.apache.kafka.test;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MockSerializer implements Serializer<byte[]> {
    public static final AtomicInteger INIT_COUNT = new AtomicInteger(0);
    public static final AtomicInteger CLOSE_COUNT = new AtomicInteger(0);

    public MockSerializer() {
        INIT_COUNT.incrementAndGet();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, byte[] data) {
        return data;
    }

    @Override
    public void close() {
        CLOSE_COUNT.incrementAndGet();
    }
}
