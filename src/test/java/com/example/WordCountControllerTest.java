package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by trainer2 on 5/15/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class WordCountControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    WordCounter wordCounter;

    @Test
    public void wordCounterTest() throws Exception {

        HashMap<String, Integer> testMap= new HashMap<String, Integer>(){
            {
                put("foo", 2);
                put("test", 2);

            }
        };


        when(wordCounter.count("foo test foo test")).thenReturn(testMap);

        this.mvc.perform(post("/words/count").content("foo test foo test")).
                andExpect(jsonPath("$.foo", equalTo(2)));

    }


}


