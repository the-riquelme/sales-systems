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

    //dados ficticios
    this.inventory.add(new ProductModel("Queijo", 5.68, 22));
    this.inventory.add(new ProductModel("Goiabada", 4.10, 32));
  }

  public void setRevenue(double value) {
    this.revenue += value;
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
