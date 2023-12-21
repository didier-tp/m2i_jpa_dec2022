package tp.appJpa;

import tp.appJpa.entity.Employe;
import tp.appJpa.repository.RepositoryEmployeJpaSansGeneric;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestSansSpringApp {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("appJpa");
       //NB: appJpa= name du persistent-unit configuré dans META-INF/persistence.xml
        EntityManager entityManager = emf.createEntityManager();
        RepositoryEmployeJpaSansGeneric daoEmployeJpa = new RepositoryEmployeJpaSansGeneric();
        daoEmployeJpa.setEntityManager(entityManager);
        Employe emp1 = new Employe(null,"prenom1","Nom");
        daoEmployeJpa.insertNew(emp1);
        List<Employe> employes = daoEmployeJpa.findAll();
        for(Employe emp : employes) {
            System.out.println(emp);
        }
        entityManager.close();
        emf.close();
    }

}
