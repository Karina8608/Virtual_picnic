
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File inputTxt = new File("input.txt");
        FileInputStream inputStream = new FileInputStream(inputTxt);
        byte[] buffer = new byte[1024];
        int bytesRead;
        String multifruit = "";
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            multifruit = multifruit + new String(buffer, 0, bytesRead);
        }
        inputStream.close();
        // убираем лишние пробелы
        multifruit = multifruit.replaceAll("\\s+", " ");
        String[] fructArr = multifruit.split(" ");
        System.out.println(Arrays.toString(fructArr));
        // количество слов в файле
        System.out.println("Всего в файле " + fructArr.length + " слов");
        int max = 0;
        int sec = 0;
        for (int i = 0; i < fructArr.length; i++) {
            if (fructArr[i].length() > max) {
                max = i;
            }
            if (fructArr[i].length() == fructArr[max].length()) {
                sec = i;
            }
        }
        System.out.println("Самое длинное слово " + fructArr[max] + " " + fructArr[max].length() + " символов");
        System.out.println("Тоже длинное слово " + fructArr[sec] + " " + fructArr[sec].length() + " символов");
        // считаем фрукты
        Map<String, Integer> basket = new HashMap<>();
        Set<String> unique = new HashSet<>(List.of(fructArr));
        for (String key : unique) {
            basket.put(key, Collections.frequency(List.of(fructArr), key));
        }
        System.out.println(basket);
    }
}

