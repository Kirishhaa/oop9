package com.example.demofx;

import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Operations {

    private static final double EPS = 1e-9;

    public void tabulation(ArrayList<Point> values){
        for (Point value : values) {
            System.out.printf("x = %.4f  y = %.6f%n", value.x(), value.y());
        }
    }

    public Point findMax(ArrayList<Point> values){
        Point max = values.get(0);
        for(int i =1;i<values.size();i++) if(values.get(i).y()>max.y()) max = values.get(i);
        return max;
    }

    public Point findMin(ArrayList<Point> values){
        Point min = values.get(0);
        for(int i =1; i<values.size();i++) if(values.get(i).y()<min.y()) min = values.get(i);
        return min;
    }

    public double sumValues(ArrayList<Point> values){
        double sum =0.0;
        for (Point value : values) {
            sum += value.y();
        }
        return sum;
    }

    public double averageValues(ArrayList<Point> values){
        return sumValues(values)/values.size();
    }

    public ArrayList<Point> getMassiveFromData(double start, double step, int steps){
        ArrayList<Point> values = new ArrayList<>();
        for(int i =0; i<steps;i++){
            double x = start+i*step;
            double y = calcY(x);
            values.add(new Point(x,y));
        }
        return values;
    }

    public int calcSteps(double a, double b, double step){
        return (int)Math.round((b-a)/step)+1;
    }

    public double calcY(double x){
        double a = 2.8;
        double b = -0.3;
        double c = 4;
        if(x<1.4){
            return a*x*x+b*x+c;
        } else if(abs(x-1.4)<=EPS){
            return a/x+sqrt(x*x+1);
        } else {
            return (a+b*x) / sqrt(x*x+1);
        }
    }

}
