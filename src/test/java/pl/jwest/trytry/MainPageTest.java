package pl.jwest.trytry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CicdApplication.class)
@WebAppConfiguration
@IntegrationTest
public class MainPageTest {

    @Test
    public void should_show_main_page() {
        // when
        ResponseEntity<String> result = template.getForEntity(HOST + "/", String.class);

        // then
        assert result.getStatusCode() == HttpStatus.OK;
        assert result.getBody().contains("Hello");
    }

    public static final String HOST = "http://localhost:8080";

    TestRestTemplate template = new TestRestTemplate();
}
