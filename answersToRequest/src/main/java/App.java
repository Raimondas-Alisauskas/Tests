package main.java;

import _10_model.data.DASData;
import _10_model.data.ProducersDBFactory;
import _10_model.data.RequestsDBFactory;
import _10_model.input.RequestInput;
import _50_request.Request;
import _30_producer.Producer;
import _60_proposal.Proposal;
import _80_utils.ProposalTimeEvaluator;
import _80_utils.RequestFiller;

import java.util.List;

public class App {

    DASData<Request> requestsData;
    DASData<Producer> producersData;
//    DASData<Proposal> proposalsForAnswer;//todo Stage1.1 make DASData<Answer>
//    DASData<DASData<Proposal>> answersData;todo Stage1.1 remove

    //for tests
    public App(DASData<Request> requestsData, DASData<Producer> producersData,
               DASData<Proposal> proposalsForAnswer, DASData<DASData<Proposal>> answersData) {

        this.requestsData = requestsData;
        this.producersData = producersData;
//        this.answersData = answersData; todo Stage1.1
    }

    // for general run
    public App() {

        requestsData = RequestsDBFactory.getDASInstance();
        producersData = ProducersDBFactory.getDbInstance();
//        answersData = AnswersDBFactory.getDbInstance(); todo Stage1.1
    }

    public void runApp() {

//        Receiving Request for production: Create mock RequestInput
        RequestInput requestInput = new RequestInput();

//        Create empty Request
        Request request = new Request();

        //fill the Request
        RequestFiller requestFiller = new RequestFiller();
        request =requestFiller.fillRequest(requestInput, request);

//        Put the Request in to requestsData
        requestsData.getData().add(request);


        //Get timeFitProducers list which meets Request's time requirements
        ProposalTimeEvaluator proposalTimeEvaluator = new ProposalTimeEvaluator();
        List<Proposal> timeFitProducers = proposalTimeEvaluator.getTimeFitProducers(request, producersData);

//        Put timeFitProducers to Answer todo Stage1.1
//        answersData.getData().add(answer);

//        Put Answer to AnswersData todo Stage1.1


        //exeptions todo Stage1.0
        //tests todo Stage1.0


        for (int i = 0; i < timeFitProducers.size(); i++){
            System.out.println("Time fit producer name :" + timeFitProducers.get(i).getProducerName());
        }

    }
}

// TODO: 18.8.20 Stage2
//       check Producers for max dimmensions
//       Sort ProposalsStaticDASData acording to earlyFinish
//        If Client is new, create new Client id, put in to ClientDatabase
//        Create OutputToClient put Producer name, availale time, earlyFinish
//Give id to Answer
//       todo Stage3:
//        Receive ProducerInput
//        Check validity
//        Create ProducerId
//        Put to ProducersStaticDASData
//
//        Active/NotActive Producer, ProposalsStaticDASData