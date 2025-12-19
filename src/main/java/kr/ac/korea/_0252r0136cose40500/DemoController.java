package kr.ac.korea._0252r0136cose40500;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/demo/external-post")
    public String postExternalData() {
        return restClient.post()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
                .retrieve()
                .body(String.class);
    }

    @PutMapping("/demo/external-put")
    public String putExternalData() {
        return restClient.put()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"id\": 1, \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
                .retrieve()
                .body(String.class);
    }

    @PatchMapping("/demo/external-patch")
    public String patchExternalData() {
        return restClient.patch()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"title\": \"foo-patched\"}")
                .retrieve()
                .body(String.class);
    }

    @DeleteMapping("/demo/external-delete")
    public String deleteExternalData() {
        return restClient.delete()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .body(String.class);
    }
}
