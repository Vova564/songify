package feature;

import org.example.songify.SongifyApplication;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest(classes = SongifyApplication.class)
@Testcontainers
@AutoConfigureMockMvc
@ActiveProfiles("integration")
class HappyPathIntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15-alpine");

    @Autowired
    MockMvc mockMvc;

    @DynamicPropertySource
    public static void propertyOverride(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/songs")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.songs", Matchers.empty()));

        mockMvc.perform(MockMvcRequestBuilders.post("/songs")
                .content("""
                      {
                          "name": "Till I Collapse",
                          "releaseDate": "2024-10-09T10:41:51.066Z",
                          "duration": 0,
                          "language": "ENGLISH"
                      }
                    """)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Till I Collapse")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre.name", Matchers.is("default")));
    }

}
