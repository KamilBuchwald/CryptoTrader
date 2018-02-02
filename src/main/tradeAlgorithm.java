package main;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;



public class tradeAlgorithm {


    public static void main(String[] args) throws IOException {

        mainAlgorithm();
        Info();


    }


    public static boolean mainAlgorithm() throws IOException {


        double[] Wallets = prospectorsClass.setCurrentValue(); //Wallet[0] = Regular Wallet, Wallet[1] = Crypto Wallet


        double desireReguralDeal = Wallets[0] + (Wallets[0] * 0.003);
        double[] currentAskBid = prospectorsClass.getBidAskCrypto(); // currentAskBid[0] = ask currentAskBid[1] = bid
        double currentStock = Wallets[1] * currentAskBid[1];

        boolean decision = false;


        if (currentStock < desireReguralDeal) {
            decision = false;
        } else if (currentStock > desireReguralDeal) {
            decision = true;
        } else {
            decision = false;
        }


        return decision;
    }

    public static void Info() throws IOException {

        double[] Wallets = prospectorsClass.setCurrentValue(); //Wallet[0] = Regular Wallet, Wallet[1] = Crypto Wallet


        double desireReguralDeal = Wallets[0] + (Wallets[0] * 0.003);
        double[] currentAskBid = prospectorsClass.getBidAskCrypto(); // currentAskBid[0] = ask currentAskBid[1] = bid
        double currentStock = Wallets[1] * currentAskBid[1];

        System.out.println("Stan konta regularnego wynosi: " + Wallets[0] + " " + "Stan konta kryptowalut wynosi: " + Wallets[1] +
                " " + "Wymagana kwota do wykonania transakcji: " + desireReguralDeal + "  Obecna kwota po kursie wynosi: " + currentStock);
    }


    public static void JSONgenerate(double dFV, double c_Value, double c_Ask, double c_Bid,double date){

        JSONObject obj = new JSONObject();
        obj.put("date", "2018-02-01");
        JSONArray list = new JSONArray();
        JSONObject inter = new JSONObject();
        inter.put("DesiredFIATDeal", dFV);
        inter.put("Transaction Ask", c_Ask);
        inter.put("Transsaction Bid", c_Bid);

        //list.add(inter);



        obj.put("Transsactions", list);

        try (FileWriter file = new FileWriter("c://users/buchka/Desktop/test.json")) {

            file.write(obj.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);


    }



}