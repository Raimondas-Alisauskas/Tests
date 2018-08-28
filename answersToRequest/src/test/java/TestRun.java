
import _10_model.data.*;
import _30_producer.Producer;
import _50_request.Request;
import _60_proposal.Proposal;
import main.java.App;

public class TestRun {

    public static void main(String[] args) {

        DASData<Request> requestData = RequestsDBFactory.getDASInstance();
        DASData<Producer> producersData = ProducersDBFactory.getDbInstance();
        DASData<Proposal> proposalsData = ProposalsDBFactory.getDbInstance();
        DASData<DASData<Proposal>> answersData = AnswersDBFactory.getDbInstance();

        test.java.TestDataPopulator testDataPopulator = new test.java.TestDataPopulator();
//        testDataPopulator.putProducerData(testDataPopulator.producersData);

        App app = new main.java.App(requestData, producersData, proposalsData, answersData);
        app.runApp();


    }

}
