package tp.appJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tp.appJpa.entity.Employe;
import tp.appJpa.repository.RepositoryEmploye;
import tp.appJpa.repository.RepositoryEmployeJpa;

import java.util.List;

@SpringBootApplication
public class AppJpaApplication {

	public static void main(String[] args) {

		/*
		ATTENTION: avec Spring moderne (SpringBoot) , la configuration JPA
		n'est pas recherchée dans META-INF/persistence.xml
		mais plutôt dans application.properties ou application.yml
		 */
		ApplicationContext contexteSpring = SpringApplication.run(AppJpaApplication.class, args);

		//RepositoryEmploye repositoryEmploye = contexteSpring.getBean(RepositoryEmploye.class);
		RepositoryEmploye repositoryEmploye = (RepositoryEmploye) contexteSpring.getBean("repositoryEmployeJpa");

		Employe emp1 = new Employe(null,"prenomQuiVabien","NomQuiVaBien");
		repositoryEmploye.insertNew(emp1);
		List<Employe> employes = repositoryEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
	}

}
