package java._80_utils;

import _30_producer.Producer;
import _80_utils.ProducerAvailabilityCalculator;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ProducerAvailabilityCalculatorTest {

    @Test
    void calculateProducerAvailability() {

        ProducerAvailabilityCalculator test = new ProducerAvailabilityCalculator();

        Producer producer = new Producer(" ", "2", "2018-01-01",
                "2018-01-02","2", "2");
        Duration duration1 = Duration.ofHours(23L);
        Duration duration2 = Duration.ofHours(24L);

        assertEquals(true, test.calculateProducerAvailability(producer, duration1));
        assertEquals(false, test.calculateProducerAvailability(producer, duration2));

    }
}