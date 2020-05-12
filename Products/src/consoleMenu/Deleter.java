package consoleMenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deleter {

    protected static final List<String> list = new ArrayList<>();

    private final static String file = "src\\Base\\base.txt";

    protected static void DeleteProduct() throws Exception {
        list.clear();
        ReadFile(); //add lines to array(list)
        Delist();//delete line from list
        FileWriter writer = new FileWriter(file, false);
        String line;
        for (String s : list) {
            line = s;
            writer.append(line).append("\n");
        }
        writer.flush();
//        writer.close();
    }

    protected static void ReadFile() throws Exception {
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
//        reader.close();
//        scanner.close();
    }

    private static void Delist() throws Exception {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println("What product would you like to delete from base?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        short deleteNumber = Short.parseShort(reader.readLine());
        list.remove(deleteNumber - 1);
//        reader.close();
    }

    protected static void ShowList() throws Exception {
        Deleter.list.clear();
        Deleter.ReadFile();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
