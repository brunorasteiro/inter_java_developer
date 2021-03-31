import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linesQtt;

        while (!"0".equals((linesQtt = br.readLine()))) {
            List<String> words = readNextNLines(br, linesQtt);
            words.stream().sorted().collect(Collectors.toList());

            if (isABadSet(words)) { System.out.println("Conjunto Ruim"); }
            else { System.out.println("Conjunto Bom"); }
        }
    }

    private static boolean isABadSet(List<String> words) {
        boolean badSet = false;
        for (int i = 0; i < words.size()-1; i++) {
            if (words.get(i+1).startsWith(words.get(i))) {
                badSet = true;
                break;
            }
        }
        return badSet;
    }

    private static List<String> readNextNLines(BufferedReader br, String linesQtt) throws IOException {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(linesQtt); i++){
            words.add(br.readLine());
        }
        return words;
    }
}
