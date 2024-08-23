package com.gaurav.project.online_bookstore.metrics;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final MeterRegistry meterRegistry;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        registerCustomMetrics();
    }

    // Method to register custom metrics
    private void registerCustomMetrics() {
        meterRegistry.counter("bookstore.customers.created").increment(0);
        meterRegistry.gauge("bookstore.customers.count", 0);
    }

    // Method to increment the customer created counter
    public void incrementCustomerCreatedCount() {
        meterRegistry.counter("bookstore.customers.created").increment();
    }

    // Method to update the customer count gauge
    public void updateCustomerCount(int count) {
        meterRegistry.gauge("bookstore.customers.count", count);
    }
}
