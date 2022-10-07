package controllers;

import java.util.ArrayList;

import models.CommerceModel;
import models.ProductModel;

public class CommerceController {

  private CommerceModel commerce;

  public CommerceController(String name) {
    this.commerce = new CommerceModel(name);
  }

  public boolean payPurchasePrice(double valor) {
    double result = this.commerce.getCash() - valor;

    if (result < 0) return false;

    this.commerce.setCash(result);

    return true;
  }

  public void receiveProducts(ArrayList<ProductModel> products) {
    for (ProductModel product : products) {
      this.commerce.setInventory(product);
    }
  }

  public ArrayList<ProductModel> provideProducts(ArrayList<ProductModel> requestedProducts) {
    return this.commerce.getProductsInInventory(requestedProducts);
  }

  public void receivePayment(double payment) {
    this.commerce.setCash(payment);
  }

}
