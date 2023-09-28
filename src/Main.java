import jdbc.dao.projetoJdbcDao.model.dao.DaoFactory;
import jdbc.dao.projetoJdbcDao.model.dao.SellerDao;
import jdbc.dao.projetoJdbcDao.model.entities.Department;
import jdbc.dao.projetoJdbcDao.model.entities.Seller;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=====TEST 1 - seller findById=====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        /*
        Connected to the PostgreSQL server successfully on schema public
        =====TEST 1 - FIND BY ID=====
        Seller {id=3, name='Alex Grey', email='alex@gmail.com', birthDate=1988-01-15, baseSalary=2200.0, department=Department {id=1, name='DepName'}}
        * */
        System.out.println();

        System.out.println("=====TEST 2 - seller findByDepartment=====");
        Department department = new Department(2, null);
        List<Seller> sellersByDepartment = sellerDao.findByDepartment(department);
        System.out.println(sellersByDepartment);

        /*
         =====TEST 2 - seller findByDepartment=====
        [Seller {id=6, name='Alex Pink', email='bob@gmail.com', birthDate=1997-03-04, baseSalary=3000.0, department=Department {id=2, name='DepName'}},
        Seller {id=2, name='Maria Green', email='maria@gmail.com', birthDate=1979-12-31, baseSalary=3500.0, department=Department {id=2, name='DepName'}}]
        */



        sc.close();

    }



}