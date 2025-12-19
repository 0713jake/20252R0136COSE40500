package kr.ac.korea._0252r0136cose40500;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
}
