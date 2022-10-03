package models;

import java.util.ArrayList;

public class PurchaseModel {
  
  private double value;
  private ArrayList<ProductModel> products;
  private double coupon;
  private double netValue;

  public PurchaseModel(double value, ArrayList<ProductModel> products, double coupon, double netValue) {
    this.value = value;
    this.products = products;
    this.coupon = coupon;
    this.netValue = netValue;
  }

  public double getValue() {
    return value;
  }

  public ArrayList<ProductModel> getProductModels() {
    return products;
  }

  public double getCoupon() {
    return coupon;
  }

  public double getNetValue() {
    return netValue;
  }

}
