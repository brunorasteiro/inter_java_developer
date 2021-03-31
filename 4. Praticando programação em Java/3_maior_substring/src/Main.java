import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    static String stringOne;
    static String stringTwo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!Objects.isNull(stringOne = br.readLine())) {
            stringTwo = br.readLine();

            System.out.println(extractHigherSubstringLenght());
        }
    }

    private static int extractHigherSubstringLenght() {
        int higherSubstringLenght = 0;
        for (int i = 0; i < stringOne.length(); i++) {
            for (int j = 0; j < stringTwo.length(); j++){
                Integer substringSize = 0;
                if (stringOne.charAt(i) == stringTwo.charAt(j)) {
                    substringSize++;
                    for (int k = 1; k < stringOne.length(); k++) {
                        try {
                            if (stringOne.charAt(i+k) == stringTwo.charAt(j+k)) { substringSize++; }
                            else { break; }
                        } catch (IndexOutOfBoundsException e) { break; }
                    }
                    if (substringSize > higherSubstringLenght) {
                        higherSubstringLenght = substringSize;
                    }
                }
            }
        }
        return higherSubstringLenght;
    }
}
