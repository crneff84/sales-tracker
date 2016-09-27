import java.util.List;
import org.sql2o.*;

public class Accessory extends Product {
  private static final String DATABASE_TYPE = "accessory";

  public Accessory(String name, int price, String description, int quantity, int categoryId) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.quantity = quantity;
    this.categoryId = categoryId;
    type = DATABASE_TYPE;
  }

  public static List<Accessory> all() {
    String sql = "SELECT * FROM products WHERE type = 'accessory';";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Accessory.class);
    }
  }

  public static Accessory find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM products WHERE id = :id";
      Accessory accessory = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(Accessory.class);
      return accessory;
    }
  }

}
