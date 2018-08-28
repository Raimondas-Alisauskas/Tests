package _80_utils;

import _30_producer.Producer;

import java.time.Duration;
import java.time.LocalDateTime;

public class EarlyFinishDateCalculator {


    public LocalDateTime calculateEarlyFinish(Producer producer, Duration productionDuration) {

        LocalDateTime availableStart = producer.getAvailableStart();
        Duration deliveringTime = producer.getDeliveringTimeH();

        return availableStart.plus(productionDuration).plus(deliveringTime);
    }


}

