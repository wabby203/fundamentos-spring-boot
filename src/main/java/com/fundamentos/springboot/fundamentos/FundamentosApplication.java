package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepocitory;
import com.fundamentos.springboot.fundamentos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pojo.UserPojo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

/*private final Log logger = LogFactory.getLog(FundamentosApplication.class);*/
/*	@Autowired */
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepocitory userRepocitory;
	private UserService userService;

	/*con el qualifer podemos escoger entre las dependencias que queremos llamar en este caso es componentImplement y componentTwoImplement
	* siempre se genera el contructur y se agregan las interfases de las dependencias que estemos usando  */
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties
	, UserPojo userPojo, UserRepocitory userRepocitory, UserService userService)
	{
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties =myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepocitory = userRepocitory;
		this.userService = userService;

	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnt ();
		saveUsersInDB();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();
	}

	private void 	saveWithErrorTransactional()
	{
		User test2 = new User("Test1Transactional", "Test1Transactional@domain.com", LocalDate.of(2021,10,20));
		User test3 = new User("Test2Transactional", "Test2Transactional@domain.com", LocalDate.of(2021,10,20));
		User test4 = new User("Test3Transactional", "Test3Transactional@domain.com", LocalDate.of(2021,10,20));
		User test1 = new User("Test4Transactional", "Test4Transactional@domain.com", LocalDate.of(2021,10,20));
		List<User> users = Arrays.asList(test1, test2, test3, test4);

		try{
			userService.saveTransactional(users);
		}catch (Exception e){
			log.error("Esta es una excepcion dentro del metodo transational" + e);
		}
		userService.getAllUsers()
				.stream()
				.forEach(user -> log.info("Este es el usuario dentro del metodo Transational :" + user));

	}
	private void getInformationJpqlFromUser()
	{
	/*	log.info("el email elegido es: "+
				userRepocitory.findByUserEmail("wabb@domain.com").orElseThrow(()-> new RuntimeException("No se encontro el usuario")));*/

		/*Ejemplo para ordenar a partir de un parametro enviado haciendo uso de jpql*/
	/*	userRepocitory.findAndSort("Ga", Sort.by("id").descending())
				.stream()
				.forEach(user->log.info("usuario con metodo sort "+user));

		userRepocitory.findByName("Gaby")
				.stream()
				.forEach(user->log.info("usuario con query metod " + user));
		log.info("usuario con query metod con findByEmailAndName "+userRepocitory.findByEmailAndName("wabb@domain.com", "Gaby")
				.orElseThrow(()-> new RuntimeException("usuario no encontrado con el "))); */

		/*Uso de Query methods con Or, and, OrderBy, Between, Sort*/
		/*userRepocitory.findByNameLike("%G%")
				.stream()
				.forEach(user->log.info("usuario findby-nameLike " + user));

		userRepocitory.findByNameOrEmail(null, "wabb@domain.com")
				.stream()
				.forEach(user->log.info("usuario findby-nameOrEmail " + user));/*

		/*Uso de Query methods que encuentre informacion a partir de un intervalo de fecha que tenemos mapeada en la endtidad*/
		userRepocitory.findByBirthdayBetween(LocalDate.of(2021, 3, 20), LocalDate.of(2021,10,20))
				.stream()
				.forEach(user->log.info("usuario con intervalo de fechas "+user));

		/*Uso de Query methods para ordenar los datos que estamos tmanejando*/
		userRepocitory.findByNameLikeOrderByIdDesc("%Gaby%")
				.stream()
				.forEach(user->log.info("usuario encontrado con like y ordenado " + user));

		/*Uso de JPQL con named parameters*/
	/*	log.info("El usuario a partir del name parameter es: "+userRepocitory.getAllByBirthdayAndEmail(LocalDate.of(2021, 3, 20), "wabb@domain.com")
				.orElseThrow(()->new RuntimeException("no se encontro el usuario a partir de named parameter ")));*/

	}
	private void saveUsersInDB()
	{
		User user1 = new User("Gaby", "wabb@domain.com", LocalDate.of(2021, 3, 20));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
		User user10 = new User("Gaby", "wabby@domain.com", LocalDate.of(2021, 3, 20));

		List<User> listUsers  = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);

		userRepocitory.saveAll(listUsers);
		//List.stream().forEach(userRepocitory::save);
	}
	private void ejemplosAnt ()
	{
		/*esta parte se usa como el ejecutador de los metodos de las diferentes dependencias */
		componentDependency.saludadar(); /* este metodo es un llamado desde diferenrtes dependencias*/
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPwd() + " - " + userPojo.getAge());
		log.info("log tipo info ");
	}
}
