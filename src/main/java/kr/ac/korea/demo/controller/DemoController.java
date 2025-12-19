package kr.ac.korea.demo.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String ITEM_URL = BASE_URL + "/1";

    private final RestClient restClient;

    public DemoController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    @GetMapping("/external")
    public String getExternalData() {
        return restClient.get()
                .uri(ITEM_URL)
                .retrieve()
                .body(String.class);
    }

    @PostMapping("/external-post")
    public String postExternalData() {
        return restClient.post()
                .uri(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
                .retrieve()
                .body(String.class);
    }

    @PutMapping("/external-put")
    public String putExternalData() {
        return restClient.put()
                .uri(ITEM_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"id\": 1, \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
                .retrieve()
                .body(String.class);
    }

    @PatchMapping("/external-patch")
    public String patchExternalData() {
        return restClient.patch()
                .uri(ITEM_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"title\": \"foo-patched\"}")
                .retrieve()
                .body(String.class);
    }

    @DeleteMapping("/external-delete")
    public String deleteExternalData() {
        return restClient.delete()
                .uri(ITEM_URL)
                .retrieve()
                .body(String.class);
    }

    @RequestMapping(value = "/external-head", method = RequestMethod.HEAD)
    public void headExternalData() {
        restClient.head()
                .uri(ITEM_URL)
                .retrieve()
                .toBodilessEntity();
    }

    @GetMapping("/external-connect")
    public void connectExternalData() {
        restClient.options()
                .uri(ITEM_URL)
                .retrieve()
                .toBodilessEntity();
    }

    @RequestMapping(value = "/external-options", method = RequestMethod.OPTIONS)
    public void optionsExternalData() {
        restClient.options()
                .uri(ITEM_URL)
                .retrieve()
                .toBodilessEntity();
    }

    @RequestMapping(value = "/external-trace", method = RequestMethod.TRACE)
    public void traceExternalData() {
        restClient.method(HttpMethod.TRACE)
                .uri(ITEM_URL)
                .retrieve()
                .toBodilessEntity();
    }
}
