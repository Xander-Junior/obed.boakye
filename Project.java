package ashesi.edu.gh.ICP313;


import java.io.*;
import java.util.*;

public class Project {

    //    public static Airports get_airport(String city, String country){
//
//
//
//
//    }

    // method to find route from one Airport to another Airport
    static HashMap<String,String> path = new HashMap<>();
    public static ArrayList<String> route_find(String source_airport_code, String dest_airport_code) {
        List<String> explored = new ArrayList<>();
        Queue<String> stack = new ArrayDeque<>();
        path.put(source_airport_code, null);


        stack.add(source_airport_code);


        while (stack.size() > 0) {
            String t = stack.remove();
            explored.add(t);

            if (Route.airport_route.containsKey(t)) {
                for (int i = 0; i < Route.airport_route.get(t).size(); i++) {
                    String successor = Route.airport_route.get(t).get(i).destinationAirportCode;
                    if ((!(explored.contains(successor))) && !(stack.contains(successor))) {
                        if (path.containsKey(t)){
                            path.put(successor, t);
                        }
                        if (successor.equals(dest_airport_code)) {

                            return sol(successor);

                        } else {
                            stack.add(successor);
                        }

                    }
                }
            } else {

                continue;
            }


    }
        System.out.println("Unsuccessful");
        return null;
    }

// method to find solution path
    public static ArrayList<String> sol(String code) {

        ArrayList<String> sol = new ArrayList<>();
        sol.add(code);
        String recent = code;

        while (path.containsKey(recent)) {
            recent = path.get(recent);

            sol.add(recent);
        }
        Collections.reverse(sol);
        return sol;
    }







// main method to run the following programs
    public static void main(String[] args) {
        Route.route_data();
        Airports.airport_data();
        Airlines.airline_data();
        Route.route_data();


        String input_file = "/Users/xander/Documents/OneDrive - Ashesi University/ Academia/2nd Year Sem 2/Intermediate Computer Programming /Class Activities/ashesi/edu/gh/ICP313/input.txt";
        ArrayList<Airports> start_venue_port;
        ArrayList<Airports> end_venue_port;

// program to read input file
        try {
            Airports.airport_data();
            Airlines.airline_data();
            Scanner sc = new Scanner(new FileInputStream(input_file));
            String start_venue = sc.nextLine();

            String end_venue = sc.nextLine();
            sc.close();

            start_venue_port = Airports.getAirport_details(start_venue);
            end_venue_port = Airports.getAirport_details(end_venue);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);


        }

        String code = null;
        String endcode = null;
        for (int i = 0; i < start_venue_port.size(); i++) {
            code = start_venue_port.get(i).IATA_code;
        }


        for (int i = 0; i < end_venue_port.size(); i++) {
            endcode = end_venue_port.get(i).IATA_code;
        }

        ArrayList out = route_find(code, endcode);
        int i = 1; int j = 1;
        PrintWriter outputWriter = null;
        try {
            outputWriter = new PrintWriter(new FileOutputStream("_output.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(i < out.size()-1){
            String loc = out.get(i) + " " + out.get(i+1);
            Route.portLine_Id(loc);
            String output = "\t" + j + ". " + Route.portLine_Id(loc)+ " from " + out.get(i) + " to " + out.get(i+1) + " 0 stops.";

            System.out.println(output);

            outputWriter.println(output);

            i++;
            j++;

        }
        i = i - 1;
        outputWriter.println("\nTotal flights = " + i);
        outputWriter.println("Total Additional stops = 0. ");

        outputWriter.close();



        }





// program to write to output file









}
