package controllers;

import java.util.ArrayList;

import models.CommerceModel;

public class CustomerController {
  
  public CustomerController(String name) {
    CommerceModel commerce = new CommerceModel(name);
  }

  public PurchaseController buyProducts(ArrayList<ProductController> products) {}

}
