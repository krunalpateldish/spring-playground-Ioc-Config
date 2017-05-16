package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by trainer2 on 5/16/17.
 */

@Component
@ConfigurationProperties("wordCount")
public class WordConfig {
    private Words words;
    private boolean caseSensitive = true;


    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }



    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }


    public static class Words {
        private ArrayList<String> skip = new ArrayList<String>();


        public ArrayList<String> getSkip() {
            return skip;
        }

        public void setSkip(ArrayList<String> skip) {
            this.skip = skip;
        }
    }

}
