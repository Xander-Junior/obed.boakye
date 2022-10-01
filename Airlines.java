package ashesi.edu.gh.ICP313;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Airlines {
    String airline_id, airline_name, airline_alias, IATA_code, ICAO_code, callsign, country;

    static HashMap<String, String> airlineID_country = new HashMap<>();





    /**
     * A database of airlines.
     * Each entry contains the following information:
     * Airline ID,
     * Name,
     * Alias,
     * IATA code,
     * ICAO code,
     * Callsign,
     * Country,
     * Active
     */
    public Airlines(String airlineId, String airlineName, String IATAcode, String call_sign, String nation) {
        this.airline_id = airlineId;
        this.airline_name = airlineName;
        this.IATA_code = IATAcode;
        this.callsign = call_sign;
        this.country = nation;
    }

    public String toString(){
        return "Airline ID: " + airline_id + " Airline name: " + airline_name + " Airline Code: " + IATA_code + " Call Sign: " + callsign + " Country: " + country;
    }

    public static void airline_data() {
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("airlines.csv"));
            while ((line = br.readLine()) != null) {
                String[] airline_info = line.split(",");
                Airlines airline = new Airlines(airline_info[0], airline_info[1], airline_info[3], airline_info[5], airline_info[6]);
                airlineID_country.put(airline.country, airline.airline_id);

            }
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException io) {
            System.out.println("Error reading file: " + io);
        }


    }

    public static void main(String[] args) {
        Airlines.airline_data();
        System.out.println(Airlines.airlineID_country);
        System.out.println(airlineID_country.get("Papua New Guinea"));



    }
}


