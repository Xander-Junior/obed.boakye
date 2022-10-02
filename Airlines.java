package ashesi.edu.gh.ICP313;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

//method to read airline information
public class Airlines {
    String airline_id, airline_name, airline_alias, IATA_code, ICAO_code, callsign, country;
    static HashMap<String, String> airlineName_IATA = new HashMap<>();
    static HashMap<String, ArrayList> airlineHash = new HashMap<>();
    static ArrayList<Airlines> airline_details = new ArrayList<>();



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
                airline_details.add(airline);
                if (airline_info[3] != null) {
                    airlineName_IATA.put(airline_info[0], airline_info[3]);
                }


            }
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException io) {
            System.out.println("Error reading file: " + io);
        }


    }




    public static void main(String[] args) {
        airline_data();
        System.out.println(airline_details.get(0));
        Airlines name = airline_details.get(0);




        System.out.println(airlineName_IATA.get("Russia"));


    }
}