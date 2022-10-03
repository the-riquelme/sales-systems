package models;

import java.util.ArrayList;

public class ProviderModel {

  private String name;
  private double revenue;
  private ArrayList<ProductModel> inventory;

  public ProviderModel(String name) {
    this.revenue = 0; // * valor padrao momentaneo
    this.name = name;
    this.inventory = new ArrayList<>();
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
    
    if (count == products.size()) return products;
    return new ArrayList<>();
  }

}
