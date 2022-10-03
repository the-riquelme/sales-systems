package controllers;

import java.util.ArrayList;

import models.ProductModel;
import models.PurchaseModel;

public class PurchaseController {

  private CommerceController buyer;
  private ProviderController seller;

  public PurchaseController(CommerceController buyer, ProviderController seller) {
    this.buyer = buyer;
    this.seller = seller;
  }

  public boolean performOperation(ArrayList<ProductModel> products, double coupon) {
    double value = this.calculateValue(products);
    double netValue = this.calculateNetWorth(value, coupon);
    PurchaseModel purchase = new PurchaseModel(value, products, coupon, netValue);

    if (!this.buyer.payPurchasePrice(purchase.getNetValue())) return false;
    if(this.seller.provideProducts(products).size() == 0) return false;


    return true;
  }

  private double calculateValue(ArrayList<ProductModel> products) {
    double totalValue = 0;

    for (ProductModel product : products) {
      totalValue += product.getValue();
    }

    return totalValue;
  }

  private double calculateNetWorth(double value, double coupon) {
    double netWorth = value - coupon;

    if (netWorth < 0)  return 0;

    return netWorth;
  }
  
}
