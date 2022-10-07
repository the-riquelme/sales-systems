package controllers;

import java.util.ArrayList;

import models.CustomerModel;
import models.ProductModel;

public class CustomerController {

  private CustomerModel customer;
  
  public CustomerController(String name, double value) {
    this.customer = new CustomerModel(name, value);
  }

  public boolean payPurchasePrice(double valor) {
    double result = this.customer.getWallet() - valor;

    if (result < 0) return false;

    this.customer.setWallet(result);

    return true;
  }

  public void receiveProducts(ArrayList<ProductModel> products) {
    for (ProductModel product : products) {
      this.customer.setPurchases(product);
    }
  }

  public void showPurchases() {
    for (ProductModel product : this.customer.getPurchases()) {
      System.out.println(product.getName() + " " + product.getValue() + " " + product.getQtd());
    }
  }

}
