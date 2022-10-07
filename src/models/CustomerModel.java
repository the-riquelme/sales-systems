package models;

import java.util.ArrayList;

public class CustomerModel {
  private double wallet;
  private String name;
  private ArrayList<ProductModel> purchases;

  public CustomerModel(String name, double value) {
    this.name = name;
    this.wallet = value;
    this.purchases = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public double getWallet() {
    return wallet;
  }

  public void setWallet(double value) {
    this.wallet = value;
  }

  public void setPurchases(ProductModel productModel) {
    this.purchases.add(productModel);
  }

  public ArrayList<ProductModel> getPurchases() {
    return this.purchases;
  }
}
