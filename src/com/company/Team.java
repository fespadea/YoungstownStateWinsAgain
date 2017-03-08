package com.company;

import java.util.ArrayList;

/**
 * Created by fs279 on 3/2/17.
 */
public class Team {
    public Team(int t){
        team = t;
    }
    public void acceptValues(double a, double b, double c, double d, double e, double f, double g, double h, double i){
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
    public void calcAvgs(){
        double [] billy = {fgRatioAvg, fg3RatioAvg, ftRatioAvg, orAvg, drAvg, astAvg, toAvg, stlAvg, blkAvg};
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
    }
    public double dgap(){
        gpa = 0;
        gpa += drAvg*3;
        gpa += stlAvg*3;
        gpa += blkAvg*20;
        return gpa;
    }
    public double ogap(){
        gpa = 0;
        gpa += fgRatioAvg*1.5;
        gpa += fg3RatioAvg*1.2;
        gpa += ftRatioAvg;
        gpa += orAvg*4.5;
        gpa += astAvg*3.5;
        gpa -= toAvg*4;
        return gpa;
    }
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
}
