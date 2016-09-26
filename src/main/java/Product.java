import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Product {
  private int id;
  private String name;
  private int price;
  private String description;
  private int quantity;
  private int categoryId;

  private static final int MIN_PRODUCT_QUANTITY = 0;

  public Product(String name, int price, String description, int quantity, int categoryId) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.quantity = quantity;
    this.categoryId = categoryId;
  }

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
      String sql = "INSERT INTO products (name, price, description, quantity, categoryId) VALUES (:name, :price, :description, :quantity, :categoryId)";
      this.id = (int) con.createQuery(sql, true)
                         .addParameter("name", name)
                         .addParameter("price", price)
                         .addParameter("description", description)
                         .addParameter("quantity", quantity)
                         .addParameter("categoryId", categoryId)
                         .executeUpdate()
                         .getKey();
    }
  }

  public static List<Product> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM products";
      return con.createQuery(sql).executeAndFetch(Product.class);
    }
  }
}
