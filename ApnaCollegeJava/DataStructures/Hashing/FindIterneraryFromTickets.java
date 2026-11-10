package DataStructures.Hashing;

import java.util.HashMap;

public class FindIterneraryFromTickets {

    public static String findStart(HashMap<String, String> tickets) {
        HashMap<String, String> reverseMap = new HashMap<>();

        for(String key : tickets.keySet()) {
            // key -> key : val -> tiickets.get(key)
            reverseMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()) {
            if(!reverseMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }
    
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = findStart(tickets);

        while(tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start);

    }
}
