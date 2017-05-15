package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by trainer2 on 5/15/17.
 */

@RestController
public class WorkCounterController {

    private final WordCounter counter;


    public WorkCounterController(WordCounter counter) {
        this.counter = counter;
    }


    @PostMapping("/word/count")
    public HashMap<String, Integer> getWodCount(@RequestBody String inputString){
        HashMap<String, Integer> count= counter.count(inputString);

        return count;

    }

}
