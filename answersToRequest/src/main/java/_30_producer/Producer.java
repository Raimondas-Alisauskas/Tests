package _30_producer;

import _10_model.data.DASData;

public class Producer extends ProducerTime3D{

    private String producerId;

    //calculations
    public Producer(int i, DASData<Producer> producersData) {
        super (i, producersData);
        this.producerId = producersData.getData().get(i).getProducerId();
      }

    // manual input
    public Producer(String producerId, String programingTimeH, String availableStart, String availableFinish, String processingSpeedCM3pH, String deliveringTimeH) {
        super(programingTimeH, availableStart, availableFinish, processingSpeedCM3pH, deliveringTimeH);
        this.producerId = producerId;
     }

    public String getProducerId() {
        return producerId;
    }
}

// TODO: 18.8.18 Stage2
//    // id
//    private static int producerId; ??

//    //scope
//    private String maxDimensionsMM;

//    //price
//    private double materialCost; //
//    private double programmingRate; //
//    private double machineUsageRate; //
//    private double handlingCost; //
//    private double deliveringCost;  //
