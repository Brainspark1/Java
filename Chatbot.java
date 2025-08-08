import java.io.*;
import java.util.*;

public class Chatbot {
    private static final String RESPONSES_FILE = "responses.txt";
    private static final Map<String, List<String>> responses = new HashMap<>();
    private static final List<String> fallbackResponses = Arrays.asList(
            "Tell me more about that.",
            "Why do you think that is?",
            "Interesting, go on...",
            "Hmm, I see.",
            "That's fascinating!");
    private static String userName = "";

    public static void main(String[] args) {
        loadResponses();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bot: Hello! Type 'bye' to quit.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("bye")) {
                System.out.println("Bot: Goodbye" + (userName.isEmpty() ? "!" : ", " + userName + "!"));
                break;
            }

            if (input.equals("delete memory")) {
                deleteMemory();
                System.out.println("Bot: My memory has been erased. I'm starting fresh!");
                continue;
            }

            if (input.startsWith("my name is ")) {
                userName = capitalize(input.substring(11));
                System.out.println("Bot: Nice to meet you, " + userName + "!");
                continue;
            }

            String keyword = findKeyword(input);
            if (keyword != null) {
                List<String> keywordResponses = responses.get(keyword);
                String reply = keywordResponses.get(new Random().nextInt(keywordResponses.size()));
                reply = reply.replace("{name}", userName.isEmpty() ? "friend" : userName);
                System.out.println("Bot: " + reply);
            } else {
                System.out.println("Bot: I don't know how to respond to that. What should I say?");
                String newResponse = scanner.nextLine().trim();
                if (!newResponse.isEmpty()) {
                    responses.put(input, new ArrayList<>(Collections.singletonList(newResponse)));
                    saveResponses();
                    System.out.println("Bot: Got it! I'll remember that for next time.");
                } else {
                    String fallback = fallbackResponses.get(new Random().nextInt(fallbackResponses.size()));
                    System.out.println("Bot: " + fallback);
                }
            }
        }
        scanner.close();
    }

    private static String findKeyword(String input) {
        for (String keyword : responses.keySet()) {
            if (input.contains(keyword)) {
                return keyword;
            }
        }
        return null;
    }

    private static void loadResponses() {
        File file = new File(RESPONSES_FILE);
        if (!file.exists()) {
            responses.put("hello", new ArrayList<>(Arrays.asList("Hi!", "Hello!", "Hey there!")));
            responses.put("how are you", new ArrayList<>(
                    Arrays.asList("I'm doing great, {name}!", "All good here!", "Better now that you're here.")));
            responses.put("weather", new ArrayList<>(
                    Arrays.asList("It's sunny today.", "Looks like rain is coming.", "Perfect day for coding.")));
            saveResponses();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String keyword = parts[0];
                    List<String> keywordResponses = Arrays.asList(parts[1].split("\\|"));
                    responses.put(keyword, new ArrayList<>(keywordResponses));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading responses: " + e.getMessage());
        }
    }

    private static void loadDefaultResponses() {
        responses.clear();
        responses.put("hello", new ArrayList<>(Arrays.asList("Hi!", "Hello!", "Hey there!")));
        responses.put("how are you", new ArrayList<>(
                Arrays.asList("I'm doing great, {name}!", "All good here!", "Better now that you're here.")));
        responses.put("weather", new ArrayList<>(
                Arrays.asList("It's sunny today.", "Looks like rain is coming.", "Perfect day for coding.")));
    }

    private static void saveResponses() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RESPONSES_FILE))) {
            for (Map.Entry<String, List<String>> entry : responses.entrySet()) {
                writer.println(entry.getKey() + "=" + String.join("|", entry.getValue()));
            }
        } catch (IOException e) {
            System.out.println("Error saving responses: " + e.getMessage());
        }
    }

    private static String capitalize(String str) {
        if (str.isEmpty())
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void deleteMemory() {
        File file = new File(RESPONSES_FILE);
        if (file.exists()) {
            file.delete();
        }
        loadDefaultResponses();
        saveResponses();
    }
}