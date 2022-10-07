package models;

import java.util.ArrayList;

public class CommerceModel {

  private String name;
  private double cash;
  private ArrayList<ProductModel> inventory;

  public CommerceModel(String name) {
    this.name = name;
    this.cash = 30000; // * valor padrao momentaneo
    this.inventory = new ArrayList<>();
  }

  public double getCash() {
    return cash;
  }

  public void setCash(double cash) {
    this.cash = cash;
  }

  public void setInventory(ProductModel productModel) {
    this.inventory.add(productModel);
  }
  
  public ArrayList<ProductModel> getProductsInInventory(ArrayList<ProductModel> products) {
    int count = 0;

    for (int indexProducts = 0; indexProducts < products.size(); indexProducts++) {
      for (int indexProductsInventory = 0; indexProductsInventory < this.inventory.size(); indexProductsInventory++) {
        if (products.get(indexProducts).getName().equals(this.inventory.get(indexProductsInventory).getName())) {
          this.inventory.get(indexProductsInventory).getQtd();
          count++;
          break;
        }
      }
    }
    
    if (count == products.size()) {
      for (int indexProducts = 0; indexProducts < products.size(); indexProducts++) {
        for (int indexProductsInventory = 0; indexProductsInventory < this.inventory.size(); indexProductsInventory++) {
          if (products.get(indexProducts).getName().equals(this.inventory.get(indexProductsInventory).getName())) {
            this.inventory.get(indexProductsInventory).setQtd(this.inventory.get(indexProductsInventory).getQtd() - 1);
            break;
          }
        }
      }
      return products;
    }
    return new ArrayList<>();
  }
  
}
