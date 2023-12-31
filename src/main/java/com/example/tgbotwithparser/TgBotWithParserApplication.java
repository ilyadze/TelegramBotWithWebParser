package com.example.tgbotwithparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TgBotWithParserApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TgBotWithParserApplication.class, args);

    }

}
