import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Generate random string
        String randomString = getRandomString(200);
        System.out.println("The original random string is:");
        System.out.println(randomString);

        // Define secret word
        String secretWord = "PYTHON";
        System.out.println("The secret word is:");
        System.out.println(secretWord);

        // Determine length of secret word
        int wordLength = secretWord.length();
        System.out.println("The length of the secret word is:");
        System.out.println(wordLength);

        // Select positions in random string for secret word
        Random rand = new Random();
        int[] positions = rand.ints(wordLength, 0, 200).distinct().sorted().toArray();
        System.out.println("The randomly selected positions are:"); // Be aware that this starts at index 0
        for (int pos : positions) {
            System.out.print(pos + " ");
        }
        System.out.println();

        // Replace letters on selected positions with letters of secret word
        StringBuilder randomStringBuilder = new StringBuilder(randomString);
        for (int i = 0; i < wordLength; i++) {
            randomStringBuilder.setCharAt(positions[i], secretWord.charAt(i));
        }
        String newString = randomStringBuilder.toString();

        System.out.println(newString);

        // Format the new string in 5x40 matrix, grouped by 5 letters
        String formattedString = "";
        for (int i = 0; i < 200; i += 5) {
            String row = newString.substring(i, i+5);
            formattedString += row;
            if ((i+1) % 40 == 0) {
                formattedString += "\n";
            } else {
                formattedString += " ";
            }
        }
        System.out.println(formattedString);
    }

    public static String getRandomString(int length) {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(upperCaseLetters.charAt(rand.nextInt(upperCaseLetters.length())));
        }
        return sb.toString();
    }
}
