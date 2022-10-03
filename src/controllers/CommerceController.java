package controllers;

import java.util.ArrayList;

import models.CommerceModel;

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

}
