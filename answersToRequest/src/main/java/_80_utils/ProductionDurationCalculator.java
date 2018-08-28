package _80_utils;

import _30_producer.Producer;
import _50_request.Request;

import java.time.Duration;

public class ProductionDurationCalculator {

    public Duration calcProductionDuration(Request request, Producer producer) {

        long processingSpeedUnitpH = producer.getProcessingSpeedCM3pH();
        long volumeUnit = request.getVolumeCM3();
        Duration preparationTime = producer.getProgramingTimeH();
        Duration deliveringTime = producer.getDeliveringTimeH();

        Duration executionTime = calcExecutionDuration(processingSpeedUnitpH, volumeUnit);

        return preparationTime.plus(executionTime.plus(deliveringTime));
    }


    private Duration calcExecutionDuration(long processingSpeedUnitpH, long volumeUnit) {

        long processingTimeH = volumeUnit / processingSpeedUnitpH;
        return Duration.ofHours(processingTimeH);
    }


}
