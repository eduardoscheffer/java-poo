import jdbc.dao.projetoJdbcDao.model.dao.DaoFactory;
import jdbc.dao.projetoJdbcDao.model.dao.SellerDao;
import jdbc.dao.projetoJdbcDao.model.entities.Department;
import jdbc.dao.projetoJdbcDao.model.entities.Seller;

import java.time.LocalDate;
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
        System.out.println();

        System.out.println("=====TEST 3 - seller findAll=====");
        List<Seller> findAllSellers = sellerDao.findAll();
        System.out.println(findAllSellers);

        /*
        =====TEST 2 - seller findAll=====
        [Seller {id=3, name='Alex Grey', email='alex@gmail.com', birthDate=1988-01-15, baseSalary=2200.0, department=Department {id=1, name='DepName'}},
        Seller {id=6, name='Alex Pink', email='bob@gmail.com', birthDate=1997-03-04, baseSalary=3000.0, department=Department {id=2, name='DepName'}},
        Seller {id=1, name='Bob Brown', email='bob@gmail.com', birthDate=1998-04-21, baseSalary=1000.0, department=Department {id=1, name='DepName'}},
        Seller {id=5, name='Donald Blue', email='donald@gmail.com', birthDate=2000-01-09, baseSalary=4000.0, department=Department {id=3, name='DepName'}},
        Seller {id=2, name='Maria Green', email='maria@gmail.com', birthDate=1979-12-31, baseSalary=3500.0, department=Department {id=2, name='DepName'}},
        Seller {id=4, name='Martha Red', email='martha@gmail.com', birthDate=1993-11-30, baseSalary=3000.0, department=Department {id=4, name='DepName'}}]
        */

        System.out.println();
        System.out.println("=====TEST 4 - seller insert=====");
        Seller newSeller = new Seller(null, "Joao", "joao@gmail.com"
                , LocalDate.of(1997, 9, 9)
                , 2500.00, new Department(1, null));
        // sellerDao.insert(newSeller);
        System.out.println("Seller inserted");

        /*
        =====TEST 4 - seller insert=====
        Seller inserted
        */

        System.out.println();
        System.out.println("=====TEST 5 - seller update=====");
        //Seller donaldBlue = sellerDao.findByEmail("donald@gmail.com");
        //donaldBlue.setName("Ragnar");
        //donaldBlue.setEmail("ragnar@gmail.com");
        //sellerDao.update(donaldBlue);
        System.out.println("Updated");
        //donaldBlue = sellerDao.findByEmail("ragnar@gmail.com");
        //System.out.println(donaldBlue);

        /*
        =====TEST 5 - seller update=====
        Updated
        Seller {id=5, name='Ragnar', email='ragnar@gmail.com', birthDate=2000-01-09, baseSalary=4000.0, department=Department {id=3, name='DepName'}}
        */

        System.out.println();

        System.out.println("=====TEST 6 - seller deleteById=====");
        sellerDao.deleteById(7);
        sellerDao.deleteById(10);
        System.out.println("Deleted");

        /*
        =====TEST 6 - seller deleteById=====
        Deleted
        */

        System.out.println();



        sc.close();

    }



}