import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public abstract class Product {
  public int id;
  public String name;
  public int price;
  public String description;
  public int quantity;
  public int categoryId;
  public String type;

  public static final int MIN_PRODUCT_QUANTITY = 0;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
  public String getDescription() {
    return description;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getCategoryId() {
    return categoryId;
  }

  @Override
  public boolean equals(Object otherProduct) {
    if(!(otherProduct instanceof Product)) {
      return false;
    } else {
      Product newProduct = (Product) otherProduct;
      return this.getName().equals(newProduct.getName()) &&
             this.getPrice() == newProduct.getPrice() &&
             this.getDescription().equals(newProduct.getDescription()) &&
             this.getQuantity() == newProduct.getQuantity() &&
             this.getCategoryId() == newProduct.getCategoryId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO products (name, price, description, quantity, categoryId, type) VALUES (:name, :price, :description, :quantity, :categoryId, :type)";
      this.id = (int) con.createQuery(sql, true)
                         .addParameter("name", name)
                         .addParameter("price", price)
                         .addParameter("description", description)
                         .addParameter("quantity", quantity)
                         .addParameter("categoryId", categoryId)
                         .addParameter("type", type)
                         .executeUpdate()
                         .getKey();
    }
  }

  public static Product find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM products WHERE id = :id";
      return con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(Product.class);
    }
  }

}
