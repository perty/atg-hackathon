package se.atg.hackathon.spring.wallet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class WalletControllerTest {

    private static final String SOME_NAME = "Some Name";
    private static final Integer SOME_AGE = 92;
    private static final String SOME_USER = "someUser";
    private static final Integer SOME_AMOUNT = 100_000;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void createAWallet() throws Exception {
        ResponseEntity<Map> responseEntity = createWallet();

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody().get("name"), is(SOME_NAME));
        assertThat(responseEntity.getBody().get("age"), is(SOME_AGE));
        assertThat(responseEntity.getBody().get("userName"), is(SOME_USER));
    }

    @Test
    public void aNewWalletHasZeroBalance() throws Exception {
        createWallet();
        ResponseEntity<Map> responseEntity = getBalance();

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody().get("value").toString(), is("0"));
    }

    @Test
    public void aDepositIncreasesTheBalance() throws Exception {
        createWallet();
        String path = String.format("http://localhost:%d/deposit?userName=%s&amount=%d", port, SOME_USER, SOME_AMOUNT);
        ResponseEntity<Map> responseEntity = testRestTemplate.getForEntity(path, Map.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        responseEntity = getBalance();
        assertThat(responseEntity.getBody().get("value"), is(SOME_AMOUNT));
    }

    private ResponseEntity<Map> createWallet() {
        String path = String.format("http://localhost:%d/createWallet?name=%s&age=%d&userName=%s",
                port,
                SOME_NAME,
                SOME_AGE,
                SOME_USER);
        return testRestTemplate.getForEntity(path, Map.class);
    }

    private ResponseEntity<Map> getBalance() {
        String path = String.format("http://localhost:%d/balance?userName=%s", port, SOME_USER);
        return testRestTemplate.getForEntity(path, Map.class);
    }
}
