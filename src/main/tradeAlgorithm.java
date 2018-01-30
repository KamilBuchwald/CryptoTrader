package main;

import java.io.BufferedReader;
import java.io.IOException;



public class tradeAlgorithm {



    public static void main(String[] args) throws IOException {

      mainAlgorithm();
      Info();



    }



    public static boolean mainAlgorithm() throws IOException {


            double[] Wallets = prospectorsClass.setCurrentValue(); //Wallet[0] = Regular Wallet, Wallet[1] = Crypto Wallet


            double desireReguralDeal = Wallets[0]+(Wallets[0]*0.003);
            double[] currentAskBid = prospectorsClass.getBidAskCrypto(); // currentAskBid[0] = ask currentAskBid[1] = bid
            double currentStock = Wallets[1]*currentAskBid[1];

            boolean decision = false;


            if(currentStock<desireReguralDeal){
                decision = false;
            }else if(currentStock>desireReguralDeal){
                decision =true;
            }else{
                decision = false;
            }



        return decision;
    }

    public static void Info() throws IOException {

        double[] Wallets = prospectorsClass.setCurrentValue(); //Wallet[0] = Regular Wallet, Wallet[1] = Crypto Wallet


        double desireReguralDeal = Wallets[0]+(Wallets[0]*0.003);
        double[] currentAskBid = prospectorsClass.getBidAskCrypto(); // currentAskBid[0] = ask currentAskBid[1] = bid
        double currentStock = Wallets[1]*currentAskBid[1];

        System.out.println("Stan konta regularnego wynosi: "+Wallets[0]+" "+"Stan konta kryptowalut wynosi: "+ Wallets[1] +
        " "+"Wymagana kwota do wykonania transakcji: "+ desireReguralDeal+"  Obecna kwota po kursie wynosi: "+currentStock );
    }





}
