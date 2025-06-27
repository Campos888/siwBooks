package merialdoProject.utils;


import java.util.Locale;

public class CountryUtils {

    public static String getCountryCodeByNationality(String countryName) {
        if (countryName == null) return "unknown";
        for (String iso : Locale.getISOCountries()) {
            Locale locale = new Locale("", iso);
            if (locale.getDisplayCountry(Locale.ENGLISH).equalsIgnoreCase(countryName.trim())) {

                return iso.toLowerCase();
            }
        }
        return "unknown"; // fallback code
    }
}
