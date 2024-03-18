package ro.ccar;

import java.io.*;
import java.util.*;

public class Locations {

    public static Map<Integer, KLocation> locations = new HashMap();

    static {

        Scanner scanner = null;

        // Read locations
        try {
            scanner = new Scanner(new FileReader("locations_big.txt"));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                int locIndex = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                locations.put(locIndex, new KLocation(locIndex, description));
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if(scanner != null) {
                scanner.close();
            }
        }

        // Now read the exits
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int dirIndex = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                KLocation location = locations.get(dirIndex);
                location.addExit(direction, destination);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }
}
