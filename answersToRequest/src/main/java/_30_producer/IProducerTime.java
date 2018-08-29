package _30_producer;

import java.time.Duration;
import java.time.LocalDateTime;

public interface IProducerTime {

    // Producer's time input
    Duration programingTimeH = null;
    LocalDateTime availableStart = null; // TODO: 18.8.18 Stage1.1 availability to list of dates
    LocalDateTime availableFinish = null;
    int processingSpeedCM3pH = 0;
    Duration deliveringTimeH = null;
}
