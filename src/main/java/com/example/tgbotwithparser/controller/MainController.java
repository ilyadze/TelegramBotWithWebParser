package com.example.tgbotwithparser.controller;

import com.example.tgbotwithparser.service.WebService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    @GetMapping()
    public ResponseEntity<Object> viewAll() throws IOException {
//        Document doc = Jsoup.connect("https://bamper.by/zchbu/marka_citroen/model_c5/zapchast_shchitok-priborov-pribornaya-panel/").get();
//        System.out.println(doc.title());
//        Elements links = doc.select("span.info-row");
//        for (Element link : links) {
//            System.out.println("Данные - " + link.getElementsByClass("date").text());
//        }
//        Elements prices = doc.select("h2.item-price");
//        for (Element link : prices) {
//            System.out.println("Цены - " + link.getElementsByClass("currency-list mobile-currency-hide").text());
//        }
        WebService webService = new WebService();
        System.out.println(webService.getModels().toArray().length);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
