package products;

public abstract class Product {

    private String type = getClass().getSimpleName();
    private float weight;
    private String color;
    private float cost;
    private String name;

    //zmienna date pokazuje termin ważnosci produktu, if date<7 => productIsGood
    private int date;


    public Product(String name, float weight, String color, float cost, int date) throws Exception {
        if (name.length() == 0 || weight <= 0 || color.length() == 0 || cost <= 0) {
            throw new Exception();
        }
        if (date > 7) {
           throw new Exception("Product is out of date!");
        }
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.cost = cost;
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        try {
            if (weight > 0) {
                this.weight = weight;
            } else throw new Exception();
        } catch (Exception e) {
            System.out.println("Error, weight can't be less than 0");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        try {
            if (color.length() != 0) {
                this.color = color;
            } else throw new Exception();
        } catch (Exception e) {
            System.out.println("Error, color must be written");
        }
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        try {
            if (cost > 0) {
                this.cost = cost;
            } else throw new Exception();
        } catch (Exception e) {
            System.out.println("Error, cost must be greater than 0");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            if (name.length() != 0) {
                this.name = name;
            } else throw new Exception();
        } catch (Exception e) {
            System.out.println("Error, color must be written");
        }
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        try {
            if (date < 7) {
                this.date = date;
            } else throw new Exception();
        } catch (Exception e) {
            System.out.println("Error, product time to throw away");
        }
    }

    public String getType() {
        return type;
    }
}
