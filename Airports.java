package ashesi.edu.gh.ICP313;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Airports {
        String airport_id, airport_name, city, country, IATA_code, ICAO_code;
        static HashMap<String, ArrayList> airportHash = new HashMap<>();
//        static HashMap<String, String> airportID_city = new HashMap<>();

        ArrayList <Airports> airport_details = new ArrayList<>();

        /**
         * A database of airlines.
         * Each entry contains the following information:
         * Airport ID,
         * Name,
         * City,
         * Country,
         * IATA code,
         * ICAO code,
         * Latitude,
         * Longitude,
         * Altitude,
         * Timezone,
         * DST (Daylight savings time),
         * Tz database time zone,
         * Type,
         * Source of this data.

         */
        public Airports(String airport_id, String airport_name, String city, String country, String IATA_code) {
            this.airport_id = airport_id;
            this.airport_name = airport_name;
            this.city = city;
            this.country = country;
            this.IATA_code = IATA_code;
        }
        public String getCity(){
            return city;
        }

        public String getCountry(){
            return country;
        }

        static ArrayList<Airports> getAirport_details(String location){
            for (String key: airportHash.keySet()){
                if (location == key){
                    return airportHash.get(location);
                }
            }


            return airportHash.get(location);
    }




        public String toString(){
            return "Airport ID: " + airport_id + " | Airport name: " + airport_name + " | Airport City: " + city + " | Airport Country: " + country + " | IATA code: " + IATA_code + "\n";
        }
// method to read airport information
    public static void airport_data() {
        ArrayList<Airports> airport_details = new ArrayList<>();
        BufferedReader br;
        String line;


        try {

            br = new BufferedReader(new FileReader("airports.csv"));
            while ((line = br.readLine()) != null) {
                String[] airport_info = line.split(",");
                String venue = airport_info[2] + ", " + airport_info[3];
                if (Airports.airportHash.containsKey(venue)){
                    Airports myAirport = new Airports(airport_info[0], airport_info[1], airport_info[2], airport_info[3], airport_info[4]);
                    Airports.airportHash.get(venue).add(myAirport);

                }
                else{
                    ArrayList<Airports> portList = new ArrayList<>();
                    Airports myAirport = new Airports(airport_info[0], airport_info[1], airport_info[2], airport_info[3], airport_info[4]);
                    portList.add(myAirport);
                    Airports.airportHash.put(venue,portList);
//                    Airports airport = new Airports(airport_info[0], airport_info[1], airport_info[2], airport_info[3], airport_info[4]);
//                    airport_details.add(airport);
//                    airportHash.put(venue, airport_details);



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
//        Airports.airport_data();
////        System.out.println(Airports.airportID_country);
////        System.out.println(Airports.airportID_city);
////        System.out.println(airport_details);
//        System.out.println(airportHash);
////        System.out.println(getAirport_details("Accra, Ghana"));
//
////        System.out.println(airportID_city.get("Papua New Guinea"));
////        System.out.println(airportID_country.get("Papua New Guinea"));
//
//
//
//    }



        }





