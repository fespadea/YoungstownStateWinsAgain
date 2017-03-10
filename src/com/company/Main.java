package com.company;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main implements Comparator{

    public static void main(String[] args) throws IOException  {
        Scanner yts = new Scanner(new File("RegularSeasonDetailedResults3YoungstownState (1) (2) (3) (4) (5) (6).tsv"));
        ArrayList<Team> lty = new ArrayList<>();
        Team bob = new Team(yts.nextInt());
        bob.acceptValues(yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble());
        lty.add(bob);
        int f = bob.team;
        while(yts.hasNextInt()){
            int s = yts.nextInt();
            if(s >= f + 1) {
                f = s;
                Team bill = new Team(f);
                bill.acceptValues(yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble());
                lty.add(bill);
            } else if (s == f){
                lty.get(lty.size()-1).acceptValues(yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(), yts.nextDouble(),yts.nextDouble(),yts.nextDouble(),yts.nextDouble());
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
            System.out.print(bobo.fgMadeAvg*(bobo.fgRatioAvg/100)*7 + "-");
            System.out.print(bobo.fg3MadeAvg*(bobo.fg3RatioAvg/100)*20 + "-");
            System.out.print(bobo.ftMadeAvg*(bobo.ftRatioAvg/100)*4 + "-");
            System.out.print(bobo.orAvg*4 + "-");
            System.out.print(bobo.drAvg*2 + "-");
            System.out.print(bobo.astAvg*3.5 + "-");
            System.out.print(bobo.toAvg*4 + "-");
            System.out.print(bobo.stlAvg*5 + "-");
            System.out.println(bobo.blkAvg*8);
        }
        ArrayList<String> billo = new ArrayList<>();
        int [] bibo = new int[64];
        ArrayList<Team> bracket = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        for(int x = 0; x < 64; x++){
            billo.add(input.nextLine());
        }
        for (int x = 0; x < 64; x++) {
            Scanner teams = new Scanner(new File("Teams.tsv"));
            for(int i = 0; i < 364; i++) {
                if(bibo[x] == 0) {
                    if (teams.nextLine().substring(5).equals(billo.get(x))) {
                        bibo[x] = teams.nextInt() - 1;
                    }
                }
            }
            for (int i = 0; i < lty.size(); i++) {
                if (lty.get(i).team == bibo[x]) {
                    lty.get(i).teamName = billo.get(x);
                    bracket.add(lty.get(i));
                }
            }
        }
        brack(bracket);
    }
    public static void brack(ArrayList<Team> bracket){
        int t =  bracket.size()/2;
        for(int x = 0; x <t; x++){
            Main bob = new Main();
            System.out.print(x + 1 + "." + bracket.get(x).teamName + " vs " + bracket.get(x+1).teamName + " = ");
            if(bob.compare(bracket.get(x), bracket.get(x+1)) == 1){
                bracket.remove(x+1);
            }
            else{
                bracket.remove(x);
            }
            System.out.println(bracket.get(x).teamName);
        }
        if(bracket.size() > 1){
            System.out.println();
            brack(bracket);
        }
        else{
            System.out.print("\n    " + bracket.get(0).teamName + " is the winner.");
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
