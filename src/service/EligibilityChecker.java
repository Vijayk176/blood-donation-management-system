package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EligibilityChecker {

    // Check if donor is eligible (90-day rule)
    public static boolean isEligible(LocalDate lastDonationDate) {
        if (lastDonationDate == null) return true;
        long days = ChronoUnit.DAYS.between(lastDonationDate, LocalDate.now());
        return days >= 90;
    }
}
