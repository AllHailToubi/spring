package Test;

import java.util.ArrayList;


public class test {
    public static void main(String[] args) {
        final java.util.Scanner input = new java.util.Scanner(System.in);

    System.out.print("Enter the number of measures: ");
    double[] items = new double[input.nextInt()];
    System.out.print("Enter the measures: ");
    for (int i = 0; i < items.length; i++) {
        items[i] = input.nextDouble();
    }

    ArrayList<Bin> containers = firstFit(items);

    //Display results
    for (int i = 0; i < containers.size(); i++) {
        System.out.println("Bar " + (i + 1)
                + " contains measures " + containers.get(i));
    }
    input.close();
}

//Greedy Algorithm??
public static ArrayList<Bin> firstFit(double[] items) {
    ArrayList<Bin> list = new ArrayList<>();


    for (int i = 0; i < items.length; i++) {
        boolean added=false;    
        for(Bin bin: list){ 
            if(bin.addItem(items[i])){
                added=true;         
                break;
            }
        }
        if(!added){
            Bin bin=new Bin();
            bin.addItem(items[i]);
            list.add(bin);
        }
    }
    return list;
}
}

//Bin Class
class Bin {
    private ArrayList<Double> objects = new ArrayList<>();
    private double maxLength = 6;
    private double totalength = 0;

    public Bin() {
    }

    public Bin(double maxLength) {
        this.maxLength = maxLength;
    }

    //Or is this supposed to be the Greedy algorithm??
    public boolean addItem(double length) {
        if ((totalength+length) <= maxLength) {
            objects.add(length);
            totalength += length;
            return true;
        }
        else {
            return false;
        }
    }

    public int getNumberOfObjects() {
        return objects.size();
    }

    @Override
    public String toString() {
        return objects.toString();
    }
}