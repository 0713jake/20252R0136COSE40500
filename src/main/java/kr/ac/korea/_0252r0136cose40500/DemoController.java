package kr.ac.korea._0252r0136cose40500;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class DemoController {

    private final RestClient restClient;

    public DemoController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    @GetMapping("/demo/external")
    public String getExternalData() {
        return restClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .body(String.class);
    }
}
