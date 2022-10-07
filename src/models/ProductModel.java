package models;

public class ProductModel {

  private String name;
  private double value;
  private int qtd;

  public ProductModel(String name, double value, int qtd) {
    this.name = name;
    this.value = value;
    this.qtd = qtd;
  }

  public String getName() {
    return name;
  }

  public double getValue() {
    return value;
  }

  public int getQtd() {
    return qtd;
  }

  public void setQtd(int qtd) {
    this.qtd = qtd;
  }
  
}
