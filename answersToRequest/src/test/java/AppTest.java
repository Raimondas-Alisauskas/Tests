
import _10_model.data.*;
import _30_producer.Producer;
import _50_request.Request;
import _60_proposal.Proposal;
import _80_utils.ProposalTimeEvaluator;
import main.java.App;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.java.TestDataPopulator;

class AppTest {


    @BeforeAll
    public void AppTest() {
        DASData<Request> requestData;
        DASData<Producer> producersData = ProducersDBFactory.getDbInstance();
        DASData<Proposal> proposalsData = ProposalsDBFactory.getDbInstance();
        DASData<DASData<Proposal>> answersData = AnswersDBFactory.getDbInstance();

        requestData = RequestsDBFactory.getDASInstance();

        TestDataPopulator testDataPopulator = new TestDataPopulator();

        App app = new main.java.App(requestData, producersData, proposalsData, answersData);
        app.runApp();


    }


    @Test
    public void runApp() {




    }
}





