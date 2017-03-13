package com.company;

import java.util.ArrayList;

/**
 * Created by fs279 on 3/2/17.
 */
public class Team {
    public Team(int t){
        team = t;
    }
    public void acceptValues(double a, double b, double c, double d, double e, double f, double g, double h, double i, double j, double k, double l){
        fgRatio.add(a);
        fg3Ratio.add(b);
        ftRatio.add(c);
        or.add(d);
        dr.add(e);
        ast.add(f);
        to.add(g);
        stl.add(h);
        blk.add(i);
        fgMade.add(j);
        fg3Made.add(k);
        ftMade.add(l);
    }
    public void calcAvgs(){
        double [] billy = {fgRatioAvg, fg3RatioAvg, ftRatioAvg, orAvg, drAvg, astAvg, toAvg, stlAvg, blkAvg, fgMadeAvg, fg3MadeAvg, ftMadeAvg};
        ArrayList<ArrayList<Double>> bobby = new ArrayList<>();
        bobby.add(fgRatio);
        bobby.add(fg3Ratio);
        bobby.add(ftRatio);
        bobby.add(or);
        bobby.add(dr);
        bobby.add(ast);
        bobby.add(to);
        bobby.add(stl);
        bobby.add(blk);
        bobby.add(fgMade);
        bobby.add(fg3Made);
        bobby.add(ftMade);
        for(int x = 0; x < billy.length; x++){
            for(int y = 0; y < bobby.get(x).size(); y++){
                billy[x] += bobby.get(x).get(y);
            }
            billy[x] = billy[x] / bobby.get(x).size();
        }
        fgRatioAvg = billy[0];
        fg3RatioAvg = billy[1];
        ftRatioAvg = billy[2];
        orAvg = billy[3];
        drAvg = billy[4];
        astAvg = billy[5];
        toAvg = billy[6];
        stlAvg = billy[7];
        blkAvg = billy[8];
        fgMadeAvg = billy[9];
        fg3MadeAvg = billy[10];
        ftMadeAvg = billy[11];
    }
    public double dgap(){
        gpa = 0;
        gpa += stlAvg;
        gpa += blkAvg;
        gpa += drAvg;
        return gpa;
    }
    public double ogap(){
        gpa = 0;
        //gpa += fgMadeAvg*(fgRatioAvg/100);
        //gpa += fg3MadeAvg*(fg3RatioAvg/100);
        //gpa += ftMadeAvg*(ftRatioAvg/100);
        gpa += fgRatioAvg+fgMadeAvg;
        gpa += fg3RatioAvg+fg3MadeAvg;
        gpa += ftRatioAvg+ftMadeAvg;
        //gpa += orAvg;
        gpa += astAvg;
        gpa -= toAvg;
        return gpa;
    }
    public String teamName;
    public double gpa;
    public double fgRatioAvg = 0;
    public double fg3RatioAvg = 0;
    public double ftRatioAvg = 0;
    public double orAvg = 0;
    public double drAvg = 0;
    public double astAvg = 0;
    public double toAvg = 0;
    public double stlAvg = 0;
    public double blkAvg = 0;
    public double fgMadeAvg = 0;
    public double fg3MadeAvg = 0;
    public double ftMadeAvg = 0;
    public int team;
    public ArrayList<Double> fgRatio = new ArrayList<>();
    public ArrayList<Double> fg3Ratio = new ArrayList<>();
    public ArrayList<Double> ftRatio = new ArrayList<>();
    public ArrayList<Double> or = new ArrayList<>();
    public ArrayList<Double> dr = new ArrayList<>();
    public ArrayList<Double> ast = new ArrayList<>();
    public ArrayList<Double> to = new ArrayList<>();
    public ArrayList<Double> stl = new ArrayList<>();
    public ArrayList<Double> blk = new ArrayList<>();
    public ArrayList<Double> fgMade = new ArrayList<>();
    public ArrayList<Double> fg3Made = new ArrayList<>();
    public ArrayList<Double> ftMade = new ArrayList<>();
}
