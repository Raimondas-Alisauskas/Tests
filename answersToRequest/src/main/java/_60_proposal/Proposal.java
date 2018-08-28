package _60_proposal;

import _80_utils.IdGenerator;

import java.time.LocalDateTime;

public class Proposal extends ProposalTime3D implements IProposal{

    //id
    private String proposalId;
    private String requestId;
    private String producerName;

    public Proposal() {
        this.proposalId = new IdGenerator().generateIdKey("Pr ");
    }

    //for manual input
    public Proposal(String requestId, String producerName,
                    LocalDateTime availableStart, LocalDateTime availableFinish, LocalDateTime earlyFinish) {
        super(availableStart, availableFinish, earlyFinish);
        this.proposalId = new IdGenerator().generateIdKey("Pr ");
        this.requestId = requestId;
        this.producerName = producerName;

    }

    //getset

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}
// TODO: 18.8.18 Stage2
////price
//private double proposalPrice;
//
//    //score
//    private int score;