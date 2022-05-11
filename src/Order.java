import java.util.ArrayList;

public class Order {
    private String FoodOption;
    private ArrayList<String> Condiments = new ArrayList<String>();
    private double Price;
    private int ID;

    public Order(int id, String food, ArrayList<String> condimentList, double price){

        setFoodOption(food);
        setCondiments(condimentList);
        setPrice(price);
        setID(id);
    }

    public String getFoodOption() {
        return FoodOption;
    }

    public void setFoodOption(String foodOption) {
        FoodOption = foodOption;
    }

    public ArrayList<String> getCondiments() {
        return Condiments;
    }

    public String getCondimentsString(){
        return Condiments.toString();
    }

    public void setCondiments(ArrayList<String> condiments) {
        if (condiments.size() == 1){
            Condiments.add(condiments.get(0));
        }else if (condiments.size() >1){
            for (int i = 0; i< condiments.size(); i++){
                Condiments.add(condiments.get(i));
            }
        }
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getID(){
        return ID;
    }

    public void setID(int id) {ID = id;}
}
