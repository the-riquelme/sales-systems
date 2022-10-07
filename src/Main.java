import java.security.Provider;
import java.util.ArrayList;

import models.ProductModel;
import controllers.*;

class Main {

  public static void main(String[] args) {
    ArrayList<ProductModel> products = new ArrayList<>();
    products.add(new ProductModel("Queijo", 5.68, 22));
    products.add(new ProductModel("Goiabada", 4.10, 32));

    ProviderController provider = new ProviderController("Fazenda Minas");
    CommerceController commerce = new CommerceController("Casa Minas");

    PurchaseController purchaseCommerce = new PurchaseController(commerce, provider);
    purchaseCommerce.performOperationCommerceProvider(products, 0);

    CustomerController customer = new CustomerController("Riquelme", 20000);

    PurchaseController purchaseCustomer = new PurchaseController(customer, commerce);
    purchaseCustomer.performOperationCustomer(products, 0);

    customer.showPurchases();
  }
    
}