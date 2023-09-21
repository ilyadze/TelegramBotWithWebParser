package com.example.tgbotwithparser.service;

import com.example.tgbotwithparser.model.BamperByModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebService {

    private final String URL = "https://bamper.by/zchbu/marka_citroen/model_c5/zapchast_shchitok-priborov-pribornaya-panel/?sort=DATE-DESC&PAGEN_1=21";
    private final String PARAMETRS = "?ACTION=REWRITED3&FORM_DATA=marka_citroen%2Fmodel_c5%2Fzapchast_shchitok-priborov-pribornaya-panel&PAGEN_1=";

    public List<BamperByModel> getModels() throws IOException {
        Document doc1 = Jsoup.connect(URL).get();
//        Elements pages = doc1.select("aside.left-col-banner");
//        pages.forEach(page -> {
//                System.out.println(page.html());
//        });
//        int numberOfPage = 1;
        Document doc = Jsoup.connect(URL).get();
        Elements links = doc.select("div.item-list");
        return elementsToModels(links);
    }

    public List<BamperByModel> elementsToModels(Elements links) {
        List<BamperByModel> models = new ArrayList<>();
        for(Element link : links) {
            BamperByModel model = new BamperByModel();
            model.setTitle( link.getElementsByClass("add-title").text());
            model.setUrl("https://bamper.by" + link.getElementsByClass("add-title").select("a").attr("href"));
            model.setDescription( link.getElementsByClass("info-row").first().text());

            Elements options = link.getElementsByClass("date");
            Elements names = link.getElementsByClass("gray2");
            int i =0;
            for(Element name: names) {
                if (name.text().equals("Артикул:")) {
                    model.setVendorCode(options.get(i).text());
                } else if(name.text().equals("VIN:")) {
                    model.setVIN(options.get(i).text());
                } else if(name.text().equals("Номер запчасти:")) {
                    model.setPartNumber(options.get(i).text());
                }
                i++;
            }
            model.setDate(options.get(i).text());
            model.setLocation(link.getElementsByClass("city").first().text());
            model.setPrice(link.getElementsByClass("item-price").first().text());
            models.add(model);
//            System.out.println(model);
        }
        return models;
    }
}
