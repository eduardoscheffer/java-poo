import jdbc.dao.projetoJdbcDao.model.dao.DaoFactory;
import jdbc.dao.projetoJdbcDao.model.dao.SellerDao;
import jdbc.dao.projetoJdbcDao.model.entities.Seller;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=====TEST 1 - FIND BY ID=====");

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        /*
        Connected to the PostgreSQL server successfully on schema public
        =====TEST 1 - FIND BY ID=====
        Seller {id=3, name='Alex Grey', email='alex@gmail.com', birthDate=1988-01-15, baseSalary=2200.0, department=Department {id=1, name='DepName'}}
        * */

        sc.close();

    }



}