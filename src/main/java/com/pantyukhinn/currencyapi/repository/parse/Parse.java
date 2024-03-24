package com.pantyukhinn.currencyapi.repository.parse;

import com.pantyukhinn.currencyapi.model.Currency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Parse {

    private static Document doc;

    public Parse() {
    }

    public static List<Currency> parse() {
        List<Currency> list = new ArrayList<>();

        try {
            doc = Jsoup.connect("https://www.finmarket.ru/currency/rates/").get();

            Elements tr = doc.getElementsByTag("tr");

            Integer id = 0;
            for (Element element : tr) {
                String valut = null, count = null, course = null, ost = null;
                Elements td = element.getElementsByTag("td");

                for (Element element1 : td) {
                    Elements names = element1.getElementsByTag("a");

                    for (Element name : names) {
                        valut = name.text();
                    }
                    if (element1.text().matches("[0-9 ]+")) {
                        count = element1.text().replace(" ", "");
                    }
                    if (element1.text().matches("[0-9,]+")) {
                        course = element1.text().replace(",", ".");
                    }
                    if (element1.text().matches("[-+][0-9,]+")) {
                        ost = element1.text();
                    }
                }
                if (valut != null && count != null && course != null && ost != null) {
                    list.add(new Currency(id++, valut, Integer.parseInt(count), Double.parseDouble(course), ost));
                }
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка получения валют из сети.");
            e.printStackTrace();
        }
        return list;
    }
}
