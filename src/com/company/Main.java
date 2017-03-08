package com.company;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main implements Comparator{

    public static void main(String[] args) throws IOException  {
        Scanner yts = new Scanner(new File("RegularSeasonDetailedResults3YoungstownState (1) (2) (3) (4) (5).tsv"));
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
        }
        Main comp = new Main();
        lty.sort(comp);
        int v = 351;
        for(Team bobo: lty){
            System.out.println(v-- + ".");
            System.out.println(bobo.team);
            System.out.println(bobo.dgap());
            System.out.println(bobo.ogap());
        }
    }

    @Override
    public int compare(Object o1, Object o2) {
        Team bob = (Team)o1;
        Team bill = (Team)o2;
        if(bob.ogap()-bill.dgap() > bill.ogap()-bob.dgap()){
            return 1;
        }
        else if(bob.ogap()-bill.dgap() < bill.ogap()-bob.dgap()){
            return -1;
        }
        return 0;
    }
}
