package consoleMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {

    protected static void Draw() {
        for (int i = 0; i < 45; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void Start() throws Exception {
        ShowMainMenu();
        Choose();
    }

    private static void ShowMainMenu() {
        Draw();
        System.out.println("1.Add product to base" +
                "\n2.Delete product from base" +
                "\n3.Set product" +
                "\n4.Show all products");
    }

    private static void Choose() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte num = Byte.parseByte(reader.readLine());
        switch (num) {
            case 1:
                Draw();
                Adder.AddProductToBase();
                Start();
                break;
            case 2:
                Draw();
                Deleter.DeleteProduct();
                Draw();
                Start();
                break;
            case 3:
                Draw();
                Setter.SetProduct();
                Start();
                break;
            case 4:
                Deleter.ReadFile();
                Draw();
                Deleter.ShowList();
                Start();
                break;
            default:
                System.out.println("Choose correct number");
                Start();
                break;
        }
//            reader.close();
    }
}

