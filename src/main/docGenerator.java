package main;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class docGenerator {

    public static void JSONgenerate(double rWS, double dFV, double c_Ask, double c_Bid) {

        JSONObject obj = new JSONObject();
        //  obj.put("date", date);
        JSONArray list = new JSONArray();
        JSONObject inter = new JSONObject();
        inter.put("RegularWalletStatus", rWS);
        inter.put("DesiredFIATDeal", dFV);
        inter.put("TranssactionAsk", c_Ask);
        inter.put("TranssactionBid", c_Bid);


        list.add(inter);


        obj.put("Transsactions", list);


        try (FileWriter file = new FileWriter("C:/Users/kamil/IdeaProjects/CryptoTraderApp/test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(obj);


    }


    public static double[] getLastData() {

        JSONParser parser = new JSONParser();

        double RegularWalletValue = 0.00;
        double DesiredFIATDeal = 0.00;
        double TranssactionAsk = 0.00;
        double TranssactionBid = 0.00;

        try {

            Object obj = parser.parse(new FileReader("C:/Users/kamil/IdeaProjects/CryptoTraderApp/test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray dataArray = (JSONArray) jsonObject.get("Transsactions");
            JSONObject internalObject = (JSONObject) dataArray.get(0);

            RegularWalletValue = (double) internalObject.get("RegularWalletStatus");
            DesiredFIATDeal = (double) internalObject.get("DesiredFIATDeal");
            TranssactionAsk = (double) internalObject.get("TranssactionAsk");
            TranssactionBid = (double) internalObject.get("TranssactionBid");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        double[] values = new double[4];
        values[0] = RegularWalletValue;
        values[1] = DesiredFIATDeal;
        values[2] = TranssactionAsk;
        values[3] = TranssactionBid;


        return values;

    }

}




