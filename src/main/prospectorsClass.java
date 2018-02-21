package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class prospectorsClass {

    public static double[] getBidAskCrypto() throws IOException {
        String url = "https://bitbay.net/API/Public/BTCPLN/orderbook.json";
        String USER_AGENT = "Mozilla/5.0";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", USER_AGENT);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }


        String jObject = response.toString();


        JSONObject json = new JSONObject(jObject);


        JSONArray asks = (JSONArray) json.getJSONArray("asks").get(1);
        double ask = asks.getDouble(0);


        JSONArray bids = (JSONArray) json.getJSONArray("bids").get(1);
        double bid = bids.getDouble(0);


        double[] AskBid = null;
        AskBid = new double[2];
        AskBid[0] = ask;
        AskBid[1] = bid;

        return AskBid;

    }


    public static double[] setCurrentValue() throws IOException {

        //Get data from JSON file( temporary) about current status of regularWaller Value it needs method ( getLastInfo() )
        double[] dataArray = docGenerator.getLastData();
        double regularWallet = dataArray[0]; // In future getHistoricalData() method
        double lastBid = dataArray[3];
        double cryptoWallet = regularWallet / lastBid;

        double[] regular_cryptoWallet = new double[2];

        regular_cryptoWallet[0] = regularWallet;
        regular_cryptoWallet[1] = cryptoWallet;

        return regular_cryptoWallet;

    }
}
