import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6; // Length of short code

    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;

    public LinkShortener() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
    }

    // Function to generate a random short code
    private String generateShortCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    // Function to shorten a long URL
    public String shortenURL(String longURL) {
        if (longToShortMap.containsKey(longURL)) {
            return longToShortMap.get(longURL);
        }

        String shortURL;
        do {
            shortURL = generateShortCode();
        } while (shortToLongMap.containsKey(shortURL)); // Handle collisions

        shortToLongMap.put(shortURL, longURL);
        longToShortMap.put(longURL, shortURL);

        return shortURL;
    }

    // Function to expand a short URL to its original form
    public String expandURL(String shortURL) {
        return shortToLongMap.getOrDefault(shortURL, "Short URL not found");
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();

        String longURL = "https://www.example.com/very/long/url/to/test";
        String shortURL = linkShortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortURL);

        String expandedURL = linkShortener.expandURL(shortURL);
        System.out.println("Expanded URL: " + expandedURL);
    }
}