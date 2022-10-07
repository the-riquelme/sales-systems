package controllers;

import java.util.ArrayList;

import models.ProductModel;
import models.PurchaseModel;

public class PurchaseController {

  private CommerceController buyerCommerce;
  private ProviderController sellerProvider;

  private CommerceController seller;
  private CustomerController buyer;

  public PurchaseController(CommerceController buyer, ProviderController seller) {
    this.buyerCommerce = buyer;
    this.sellerProvider = seller;
  }

  public PurchaseController(CustomerController buyer, CommerceController seller) {
    this.buyer = buyer;
    this.seller = seller;
  }

  public boolean performOperationCommerceProvider(ArrayList<ProductModel> products, double coupon) {
    double value = this.calculateValue(products);
    double netValue = this.calculateNetWorth(value, coupon);
    PurchaseModel purchase = new PurchaseModel(value, products, coupon, netValue);

    if (!this.buyerCommerce.payPurchasePrice(purchase.getNetValue())) return false;
    if(this.sellerProvider.provideProducts(products).size() == 0) return false;

    this.sellerProvider.receivePayment(purchase.getNetValue());
    this.buyerCommerce.receiveProducts(products);

    return true;
  }

  public boolean performOperationCustomer(ArrayList<ProductModel> products, double coupon) {
    double value = this.calculateValue(products);
    double netValue = this.calculateNetWorth(value, coupon);
    PurchaseModel purchase = new PurchaseModel(value, products, coupon, netValue);

    if (!this.buyer.payPurchasePrice(purchase.getNetValue())) return false;
    if(this.seller.provideProducts(products).size() == 0) return false;

    this.seller.receivePayment(purchase.getNetValue());
    this.buyer.receiveProducts(products);

    return true;
  }

  protected double calculateValue(ArrayList<ProductModel> products) {
    double totalValue = 0;

    for (ProductModel product : products) {
      totalValue += product.getValue();
    }

    return totalValue;
  }

  protected double calculateNetWorth(double value, double coupon) {
    double netWorth = value - coupon;

    if (netWorth < 0)  return 0;

    return netWorth;
  }
  
}
