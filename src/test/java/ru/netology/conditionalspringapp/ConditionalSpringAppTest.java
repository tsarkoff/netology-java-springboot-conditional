package ru.netology.conditionalspringapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.netology.conditionalspringapp.service.impl.DevProfile;
import ru.netology.conditionalspringapp.service.impl.ProductionProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConditionalSpringAppTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private final static GenericContainer<?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    @Container
    private final static GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    /*@BeforeAll
    public static void setUp() {
        appDev.start();
        appProd.start();
    }*/

    @Test
    void contextLoads() {
        System.out.println("DEV container is listening on port:" + devApp.getMappedPort(8080));
        System.out.println("PROD container is listening on port:" + prodApp.getMappedPort(8081));
    }

    @Test
    void devApp() {
        ResponseEntity<String> forEntityDev = restTemplate
                .getForEntity("http://localhost:" + devApp.getMappedPort(8080) + "/profile", String.class);
        String profileType = forEntityDev.getBody();
        assertEquals(profileType, DevProfile.MSG_DEV);
    }

    @Test
    void prodApp() {
        ResponseEntity<String> forEntityDev = restTemplate
                .getForEntity("http://localhost:" + prodApp.getMappedPort(8081) + "/profile", String.class);
        String profileType = forEntityDev.getBody();
        assertEquals(profileType, ProductionProfile.MSG_PROD);
    }
}
