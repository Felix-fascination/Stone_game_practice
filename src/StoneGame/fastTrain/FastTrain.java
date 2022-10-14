package StoneGame.fastTrain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FastTrain {
    public static void main(String[] args)
            throws FileNotFoundException, ParseException {

        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Date> dates = new ArrayList<>(n*2);
        ArrayList<String> names = new ArrayList<>(n);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long speedMax = -1;
        int speedMaxIndex = -1;
        String line;

        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            names.add(line.substring(line.indexOf("\""), line.lastIndexOf("\"") + 1) );

            String[] strings = line.split(" ");
            dates.add(sdf.parse(strings[strings.length - 2])) ;
            dates.add(sdf.parse(strings[strings.length - 1])) ;

            long thisSpeed = TrainTime.speedWithTime(dates.get(i*2), dates.get(i*2 + 1), 650);
            if (speedMax < thisSpeed){
                speedMax = thisSpeed;
                speedMaxIndex = i;
            }
        }
        TrainTime.printTrainToFile(names, speedMax,speedMaxIndex);
        System.out.println("Hello");

    }
}

class TrainTime{
    static long speedWithTime (Date date1, Date date2, int road){
        return speedWithIntTimeRoad(
                timeDifference(date1, date2), road
        );
    }

    static double timeDifference (Date date1, Date date2){
        long diffInMillies = date2.getTime() - date1.getTime();
        double diff = (double)diffInMillies/3600/1000;
        if (date2.getTime() < date1.getTime()) diff = (24 + diff)%24;
        return diff;
    }

    static long speedWithIntTimeRoad (double time, int road){
        if (time == 0f) return 0;
        return Math.round(road/time);
    }

    static void printTrainToFile (ArrayList<String> names, long speed, int speedIndex ) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"));
        pw.println("The fastest train is " + names.get(speedIndex) + ".");
        pw.println("Its speed is "+ speed + " km/h, approximately.");
        pw.close();
    }
}