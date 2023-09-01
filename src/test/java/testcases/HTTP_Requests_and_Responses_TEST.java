package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HTTP_Requests_and_Responses_TEST extends BaseTest{

    @Test
    public void urlVerification () {

    String[] sites = {"https://www.ttrsonline.com", "https://www.deepl.com/", "https://prephouse.thinkific.com/"};
    SoftAssert softAssert = null;
    for (String site : sites) {
        driver.get(site);

        List<Integer> codes = hw_http_req_and_resp_page.urlVerification();
        softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code : codes) {
            softAssert.assertEquals(code, expected);
        }


    }
    softAssert.assertAll();
    }

}

