package main;

import org.json.simple.*;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;



public class tradeAlgorithm {



    public static void main(String[] args) throws IOException {


        mainAlgorithm();



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

            if(decision == true){
                transactionProcess(decision,desireReguralDeal,currentAskBid[0],currentAskBid[1]);
            }else {

                System.out.println("Stan konta regularnego wynosi: " + Wallets[0] + " " + "Stan konta kryptowalut wynosi: " + Wallets[1] +
                        " " + "Wymagana kwota do wykonania transakcji: " + desireReguralDeal + "  Obecna kwota po kursie wynosi: " + currentStock);


            }
            return decision;


    }



    public static void transactionProcess(boolean parameter,double dRD,double cA, double cB){


        System.out.println("Transsaction Executed");

    }





}
