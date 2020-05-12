package consoleMenu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Setter {
    private static String line;

    protected static void SetProduct() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deleter.ShowList();
        System.out.println("What product would you like to change?");
        short productNumber = (short) (Short.parseShort(reader.readLine()) - 1);
        line = Deleter.list.get(productNumber);
        Choose();
        Deleter.list.set(productNumber, line);
        changeBase();
//        reader.close();
    }


    private static void Choose() throws Exception {
        System.out.println("1.Name" +
                "\n2.Weight(not working)" +
                "\n3.Color(not working)" +
                "\n4.Cost(not working)" +
                "\n5.Days(not working)");
        System.out.println("Choose what would you like to change: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        switch (Integer.parseInt(reader.readLine())) {
            case 1:
                setName();
            case 2:
            case 3:
            case 4:
            case 5:
        }
      //  reader.close();
    }

    private static void setName() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder(line);
        int nameIndex = line.indexOf("| Name: ");
        nameIndex = nameIndex + 8;
        int nextIndex = line.indexOf("| Weight:");
        nextIndex = nextIndex - 1;
        stringBuilder.delete(nameIndex, nextIndex);
        System.out.println("New name: ");
        stringBuilder.insert(nameIndex, reader.readLine());
        line = String.valueOf(stringBuilder);
//        reader.close();
    }

    public static void changeBase() {
        try {
            FileWriter writer = new FileWriter("src\\Base\\base.txt");
            BufferedWriter out = new BufferedWriter(writer);
            out.write("");
            for (String s : Deleter.list) {
                writer.append(s).append("\n");
            }
            writer.close();
            out.close();
        } catch (Exception e) {
            System.out.println("Error in file clear: " + e.getMessage());
        }
    }
}
