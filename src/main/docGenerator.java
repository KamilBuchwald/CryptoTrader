package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class docGenerator {

    public static void JSONgenerate(double dFV, double c_Value, double c_Ask, double c_Bid,double date){

        JSONObject obj = new JSONObject();
        obj.put("date", "2018-02-01");
        JSONArray list = new JSONArray();
        JSONObject inter = new JSONObject();
        inter.put("DesiredFIATDeal", dFV);
        inter.put("Transaction Ask", c_Ask);
        inter.put("Transsaction Bid", c_Bid);

        list.add(inter);



        obj.put("Transsactions", list);

        try (FileWriter file = new FileWriter("c://users/kamil/Desktop/test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);


    }


}
