import java.util.List;
import org.sql2o.*;

public class JeanStuff extends Product {
  private static final String DATABASE_TYPE = "jeanstuff";

  public JeanStuff(String name, int price, String description, int quantity, int categoryId) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.quantity = quantity;
    this.categoryId = categoryId;
    type = DATABASE_TYPE;
  }

  public static List<JeanStuff> all() {
    String sql = "SELECT * FROM products WHERE type = 'jeanstuff';";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(JeanStuff.class);
    }
  }

  public static JeanStuff find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM products WHERE id = :id";
      JeanStuff accessory = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(JeanStuff.class);
      return accessory;
    }
  }

}
