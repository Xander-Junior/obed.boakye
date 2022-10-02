package ashesi.edu.gh.ICP313;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Route {

    String airline_code, airline_id, sourceAirportCode, sourceAirportId, destinationAirportCode, destinationAirportId, stops;
    static HashMap<String, ArrayList> routeHash = new HashMap<>();
    private static ArrayList<Route> route_details = new ArrayList<>();
    static HashMap<String, ArrayList<Route>> airport_route = new HashMap<>();


//

    /**
     * A database of airlines.
     * Each entry contains the following information:
     * Airline code,
     * Airline ID,
     * Source airport code,
     * Source airport ID,
     * Destination airport code,
     * Destination airport ID,
     * Codeshare,
     * Stops,
     * Equipment
     */
    public Route(String aline_code, String aline_id, String aport_sourcecode, String aport_sourceid, String aport_destCode, String aport_destId) {
        this.airline_code = aline_code;
        this.airline_id = aline_id;
        this.sourceAirportCode = aport_sourcecode;
        this.sourceAirportId = aport_sourceid;
        this.destinationAirportCode = aport_destCode;
        this.destinationAirportId = aport_destId;
        this.stops = stops;

    }


//    public String toString(){
//        return "Airline Code: " + airline_code + " Airline ID: " + airline_id + " Source Airport Code : " + sourceAirportCode + " Source Airport ID: " + sourceAirportId +
//                " Destination Airport Code: " + destinationAirportCode + " Destination Airport ID: " + destinationAirportId + " Stops: " + stops + "\n";
//    }

    public String toString(){
        return airline_code + " from " + sourceAirportCode + " to " + destinationAirportCode + " : " + stops + " stops. \n";
    }

//    public String output(){
//
//
//    }


// method to read route information
    public static void route_data() {
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("routes.csv"));
            while ((line = br.readLine()) != null) {
                String[] route_info = line.split(",");
                if (routeHash.containsKey(route_info[2])){
                    ArrayList<Route> routeList = routeHash.get(route_info[2]);
                    Route route = new Route(route_info[0], route_info[1], route_info[2], route_info[3], route_info[4], route_info[5]);
                    route_details.add(route);
                    routeList.add(route);
                    airport_route.put(route_info[2], routeList);
                    routeHash.put(route_info[2],routeList);



                }
                else{

                    ArrayList<Route> routeList = new ArrayList<>();
                    Route route = new Route(route_info[0], route_info[1], route_info[2], route_info[3], route_info[4], route_info[5]);
                    route_details.add(route);
                    routeList.add(route);
                    routeHash.put(route_info[2],routeList);

                }

            }
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException io) {
            System.out.println("Error reading file: " + io);
        }


    }

//    public static void main(String[] args) {
//        Route.route_data();
//        System.out.println(airport_route);
////        System.out.println(routeHash);
////        System.out.println(route_details);
//    }



}
