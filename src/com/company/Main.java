package com.company;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner yts = new Scanner(new File("RegularSeasonDetailedResults3YoungstownState (1) (2) (3) (4) (5).txt"));
        ArrayList<Team> lty = new ArrayList<>();
        Team bob = new Team(yts.nextInt());
        bob.acceptValues(yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble());
        lty.add(bob);
        int f = bob.team;
        while(yts.hasNextInt()){
            int s = yts.nextInt();
            if(s >= f + 1) {
                f = s;
                Team bill = new Team(f);
                bill.acceptValues(yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble());
                lty.add(bill);
            } else if (s == f){
                lty.get(lty.size()-1).acceptValues(yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble());
            }
        }
        for(int x = 0; x < lty.size(); x++){
            lty.get(x).calcAvgs();
            System.out.println(lty.get(x).team);
            System.out.println(lty.get(x).gap());
        }
    }
}
