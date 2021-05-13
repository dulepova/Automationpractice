package tests;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.Retry;


public class SearchTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    @Description("Search by category and check the number of search results")
    public void searchValidCategory() {
        searchSteps
                .openPage()
                .search("Dress")
                .numberOfResultShouldBe(7);
    }
    @Test(retryAnalyzer = Retry.class)
    @Description("Invalid value search")
    public void searchInValidCategory() {
        searchSteps
                .openPage()
                .search("blablabla")
                .numberOfResultShouldBe(0);
    }
}
