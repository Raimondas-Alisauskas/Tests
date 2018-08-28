package _80_utils;

import _30_producer.Producer;

import java.time.Duration;
import java.time.LocalDateTime;

public class ProducerAvailabilityCalculator {

    // availability evaluated for 24/7 Producer's worktime
    public boolean calculateProducerAvailability(Producer producer, Duration productionDuration) {

        LocalDateTime availableStart = producer.getAvailableStart();
        LocalDateTime availableFinish = producer.getAvailableFinish();

        return availableStart.plus(productionDuration).isBefore(availableFinish);
    }

}
