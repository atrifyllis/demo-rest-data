package gr.alx.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DemoRestDataApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void contextLoads() throws Exception {

//        mvc.perform(get("/users")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//        ;
        User user = userRepository.findAll().iterator().next();
        String newUser = objectMapper.writeValueAsString(new User(user.getId(), user.getUsername(), null));
        mvc.perform(patch("/users/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(newUser))
                .andExpect(content().json("{'username':'alex','password':'pass'}"))
        ;

    }

}
