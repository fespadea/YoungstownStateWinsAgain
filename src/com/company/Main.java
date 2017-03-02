package com.company;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner yts = new Scanner(new File(""));
        ArrayList<Team> lty = new ArrayList<>();
        Team bob = new Team(yts.nextInt());
        bob.acceptValues(yts.nextInt(),yts.nextInt(),yts.nextInt(),yts.nextInt(),yts.nextInt(),yts.nextInt(),yts.nextInt(),yts.nextInt(),yts.nextInt());
        lty.add(bob);
        int f = bob.team;
        while(yts.hasNextInt()){
            if(yts.nextInt() == f) {
                Team bill = new Team(yts.nextInt());
                bill.acceptValues(yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt());
                lty.add(bill);
            } else if (yts.nextInt() == f + 1){
                lty.get(lty.size()-1).acceptValues(yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt(), yts.nextInt());
            }
        }
    }
}
