package controllers;

import java.util.ArrayList;

import models.ProductModel;
import models.ProviderModel;

public class ProviderController {

  private ProviderModel provider;

  public ProviderController(String name) {
    this.provider = new ProviderModel(name);
  }

  public ArrayList<ProductModel> provideProducts(ArrayList<ProductModel> requestedProducts) {
    return this.provider.getProductsInInventory(requestedProducts);
  }

}
