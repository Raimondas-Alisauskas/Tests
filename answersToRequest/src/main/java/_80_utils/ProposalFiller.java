package _80_utils;

import _30_producer.Producer;
import _50_request.Request;
import _60_proposal.Proposal;

public class ProposalFiller {

    public Proposal fillProposal(Proposal proposal, Request request, Producer producer) {
        proposal.setRequestId(request.getRequestId());
        proposal.setProducerName(producer.getProducerId());
        proposal.setAvailableStart(producer.getAvailableStart());
        proposal.setAvailableFinish(producer.getAvailableFinish());
        return proposal;
    }

}
