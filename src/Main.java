import jdbc.dao.projetoJdbcDao.model.entities.Department;
import jdbc.dao.projetoJdbcDao.model.entities.Seller;

import java.time.LocalDate;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        Seller seller = new Seller(1, "Joao", "joao@gmail.com",
                LocalDate.of(1997, 9, 9),
                2000.00, new Department(1, "Books"));

        System.out.println(seller);

        sc.close();

    }



}