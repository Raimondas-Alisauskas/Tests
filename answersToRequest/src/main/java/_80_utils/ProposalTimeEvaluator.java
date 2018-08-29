package _80_utils;

import _10_model.data.DASData;
import _60_proposal.Proposal;
import _30_producer.Producer;
import _50_request.Request;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProposalTimeEvaluator {


    public List<Proposal> getTimeFitProducers(Request request, DASData<Producer> producersData) {

        ProductionDurationCalculator productionDurationCalculator = new ProductionDurationCalculator();
        ProducerAvailabilityCalculator producerAvailabilityCalculator = new ProducerAvailabilityCalculator();
        EarlyFinishDateCalculator earlyFinishDateCalculator = new EarlyFinishDateCalculator();
        ProposalFiller proposalFiller = new ProposalFiller();
        List<Proposal> timeFitProducers = new ArrayList();


        for (int i = 0; i < producersData.getData().size(); i++) {
            Producer producer = new Producer(i, producersData);

            // calculate productionDuration
            Duration productionDuration = productionDurationCalculator.calcProductionDuration(request, producer);

            // calculate availability
            boolean producerAvailable = producerAvailabilityCalculator.calculateProducerAvailability(producer, productionDuration);

            if (producerAvailable) {

                //calculate earlyFinishDate date of Proposal
                LocalDateTime earlyFinishDate = earlyFinishDateCalculator.calculateEarlyFinish(producer, productionDuration);

                //check Request's deadline
                LocalDateTime deadline = request.getDeadline();
                boolean productionIsOnTime = earlyFinishDate.isBefore(deadline);

                if (productionIsOnTime) {

                    //create empty Proposal
                    Proposal proposal = new Proposal();

                    //fill Proposal
                    proposal.setEarlyFinishDate(earlyFinishDate);
                    proposal = proposalFiller.fillProposal(proposal, request, producer);

                    //put Proposal to proposalsList
                    timeFitProducers.add(proposal);
                }

            }
        }
        return timeFitProducers;
    }


}

