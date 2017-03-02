package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fs279 on 3/2/17.
 */
public class Team {
    public Team(int t){
        team = t;
    }
    public void acceptValues(int a, int b, int c, int d, int e, int f, int g, int h, int i){
        fgRatio.add(a);
        fg3Ratio.add(b);
        ftRatio.add(c);
        or.add(d);
        dr.add(e);
        ast.add(f);
        to.add(g);
        stl.add(h);
        blk.add(i);
    }
    public int team;
    public ArrayList<Integer> fgRatio;
    public ArrayList<Integer> fg3Ratio;
    public ArrayList<Integer> ftRatio;
    public ArrayList<Integer> or;
    public ArrayList<Integer> dr;
    public ArrayList<Integer> ast;
    public ArrayList<Integer> to;
    public ArrayList<Integer> stl;
    public ArrayList<Integer> blk;
}
