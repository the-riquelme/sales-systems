package models;

import java.util.ArrayList;

public class CommerceModel {

  private String name;
  private double cash;
  private ArrayList<ProductModel> inventory;

  public CommerceModel(String name) {
    this.name = name;
    this.cash = 3000; // * valor padrao momentaneo
    this.inventory = new ArrayList<>();
  }

  public double getCash() {
    return cash;
  }

  public void setCash(double cash) {
    this.cash = cash;
  }

  public void setInventory(ArrayList<ProductModel> inventory) {
    this.inventory = inventory;
  }
  
}
