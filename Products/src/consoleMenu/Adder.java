package consoleMenu;

import products.Fruit;
import products.Product;
import products.Vegetable;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Objects;

public class Adder {

    protected static void AddProductToBase() throws Exception {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Fruit" + "\n2.Vegetable");
        byte choose = Byte.parseByte(reader.readLine());

        System.out.println("Name: ");
        String name = reader.readLine();

        System.out.println("Weight: ");
        float weight = Float.parseFloat(reader.readLine());

        System.out.println("Color: ");
        String color = reader.readLine();

        System.out.println("Cost: ");
        float cost = Float.parseFloat(reader.readLine());

        System.out.println("Days: ");
        int date = Integer.parseInt(reader.readLine());

        ReadToBase(Objects.requireNonNull(GetProduct(choose, name, weight, color, cost, date)));

//            reader.close();
    }

    private static Product GetProduct(int choose, String name, float weight, String color, float cost, int date) throws Exception {
        if (choose == 1) {
            return new Fruit(name, weight, color, cost, date);
        } else if (choose == 2) {
            return new Vegetable(name, weight, color, cost, date);
        } else {
            System.out.println("Choose correct number");
            AddProductToBase();
            return null;
        }
    }

    private static void ReadToBase(Product product) throws Exception {
        FileWriter writer = new FileWriter("src\\Base\\base.txt", true);
        writer.append(product.getType().toUpperCase()).
                append(" | Name: ").append(product.getName()).
                append(" | Weight:").append(String.valueOf(product.getWeight())).
                append(" | Color: ").append(product.getColor()).
                append(" | Cost: ").append(String.valueOf(product.getCost())).
                append(" | Days: ").append(String.valueOf(product.getDate())).append("\n");
        writer.flush();
//        writer.close();
    }
}
