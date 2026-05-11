package service;

import java.util.*;

public class BloodCompatibility {
    private static final HashMap<String, List<String>> compatibilityMap = new HashMap<>();

    static {
        compatibilityMap.put("A+", Arrays.asList("A+", "A-", "O+", "O-"));
        compatibilityMap.put("A-", Arrays.asList("A-", "O-"));
        compatibilityMap.put("B+", Arrays.asList("B+", "B-", "O+", "O-"));
        compatibilityMap.put("B-", Arrays.asList("B-", "O-"));
        compatibilityMap.put("AB+", Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"));
        compatibilityMap.put("AB-", Arrays.asList("A-", "B-", "AB-", "O-"));
        compatibilityMap.put("O+", Arrays.asList("O+", "O-"));
        compatibilityMap.put("O-", Arrays.asList("O-"));
    }

    public static List<String> getCompatibleDonors(String recipientBlood) {
        return compatibilityMap.getOrDefault(recipientBlood, new ArrayList<>());
    }
}
