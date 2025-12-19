package kr.ac.korea.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testExternalGet() throws Exception {
        mockMvc.perform(get("/demo/external"))
                .andExpect(status().isOk());
    }

    @Test
    void testExternalPost() throws Exception {
        mockMvc.perform(post("/demo/external-post"))
                .andExpect(status().isOk());
    }

    @Test
    void testExternalPut() throws Exception {
        mockMvc.perform(put("/demo/external-put"))
                .andExpect(status().isOk());
    }

    @Test
    void testExternalPatch() throws Exception {
        mockMvc.perform(patch("/demo/external-patch"))
                .andExpect(status().isOk());
    }

    @Test
    void testExternalDelete() throws Exception {
        mockMvc.perform(delete("/demo/external-delete"))
                .andExpect(status().isOk());
    }

    @Test
    void testExternalHead() throws Exception {
        mockMvc.perform(head("/demo/external-head"))
                .andExpect(status().isOk());
    }

    @Test
    void testExternalConnect() throws Exception {
        mockMvc.perform(get("/demo/external-connect"))
                .andExpect(status().isOk());
    }

    @Test
    void testExternalOptions() throws Exception {
        mockMvc.perform(options("/demo/external-options"))
                .andExpect(status().isOk());
    }

    @Test
    void testExternalTrace() throws Exception {
        mockMvc.perform(request(HttpMethod.TRACE, "/demo/external-trace"))
                .andExpect(status().isOk());
    }
}
