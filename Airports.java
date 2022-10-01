package ashesi.edu.gh.ICP313;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Airports {
        String airport_id, airport_name, city, country, IATA_code, ICAO_code;
        static HashMap<String, String> airportID_country = new HashMap<>();
        static HashMap<String, String> airportID_city = new HashMap<>();

        static ArrayList <Airports> airport_details = new ArrayList<>();

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

        public String toString(){
            return "Airport ID: " + airport_id + " Airport name: " + airport_name + " Airport City: " + city + " Airport Country: " + country + " IATA code: " + IATA_code;
        }

        public static void airport_data() {
            BufferedReader br;
            String line;
            try {
                br = new BufferedReader(new FileReader("airports.csv"));
                while ((line = br.readLine()) != null) {
                    String[] airport_info = line.split(",");
                    Airports airport = new Airports(airport_info[0], airport_info[1], airport_info[2], airport_info[3], airport_info[4]);
                    airportID_country.put(airport.country, airport.airport_id);
                    airportID_city.put(airport.city, airport.airport_id);

                }
            } catch (FileNotFoundException fe) {
                System.out.println("File not found");
                System.exit(0);
            } catch (IOException io) {
                System.out.println("Error reading file: " + io);
            }


        }
    public static void main(String[] args) {
        Airports.airport_data();
//        System.out.println(Airports.airportID_country);
//        System.out.println(Airports.airportID_city);
        System.out.println(airport_details);
//        System.out.println(airportID_city.get("Papua New Guinea"));
//        System.out.println(airportID_country.get("Papua New Guinea"));



    }



        }





