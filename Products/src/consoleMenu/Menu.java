package consoleMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void Start() throws Exception {
        ShowMainMenu();
        Choose();
        reader.close();
    }

    private static void ShowMainMenu() {
        System.out.println("1.Add product to base" +
                "\n2.Delete product from base" +
                "\n3.Set product" +
                "\n4.Show all products");
    }

    private static void Choose() throws Exception {
        byte num = Byte.parseByte(reader.readLine());
        switch (num) {
            case 1:
                Adder.AddProductToBase();
                break;
            case 2:
                Deleter.DeleteProduct();
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Choose correct number");
                Choose();
                break;
        }
    }
}

