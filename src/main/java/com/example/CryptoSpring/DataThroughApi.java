package com.example.CryptoSpring;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataThroughApi {
    String url = "https://api.bittrex.com/api/v1.1/public/getmarketsummaries";
    List<Crypto> market_value = new ArrayList<>();

    {
        try {
            URL web = new URL(url);
            InputStream is = web.openStream();
            JsonReader rdr = Json.createReader(is);
            JsonObject obj = rdr.readObject();
            JsonArray results = obj.getJsonArray("result");
            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                JsonValue getMarket = result.get("MarketName");
                JsonValue getLast = result.get("Last");
                float last = Float.parseFloat(getLast.toString());
                String market = getMarket.toString().replace("\"", "");
                if (market.contains("USD")) {
                    String[] splittedMarket = market.split("-");
                    if (splittedMarket[0].equals("USD")) {

                        Crypto crypto = new Crypto(splittedMarket[1],last);
                        market_value.add(crypto);

                    }
                }
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public List<Crypto> getMarket_value(){
        return market_value;
    }
}
