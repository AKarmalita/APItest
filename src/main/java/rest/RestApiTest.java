package rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RestApiTest {
    String url1 = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=";
    String url2 = "&json";
    String[] currency = {"USD", "EUR", "RUB"};


    @Test
    public void Test() throws JsonProcessingException {
        for (String i:currency) {
            String s = RestApiGet.GetExchange(url1 + i + url2);
            Currency myCurrency = new ObjectMapper().readValue(s, Currency.class);
            System.out.println(myCurrency.exchangedate + " the rate of " + i + " is " + myCurrency.rate);
        }
    }
}


