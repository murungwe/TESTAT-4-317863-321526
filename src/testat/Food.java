/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testat;

/**
 *
 * @author Jen
 */
public class Food {

    private int foodID, quantity;
    private String name, type;

    public int getfoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;

    }

    @Override
    public String toString() {
        String summary = "FoodID: " + this.getfoodID() + " - " + this.getType() + this.getName() + " has a current quantity of " + this.getQuantity() + " units. ";

        return summary;
    }
}
