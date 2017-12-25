package fi.coursemate;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.coursemate.domain.Course;
import fi.coursemate.domain.CourseRepository;
import fi.coursemate.domain.Student;
import fi.coursemate.domain.StudentRepository;
import fi.coursemate.domain.User;
import fi.coursemate.domain.UserRepository;

/**
 * CourseMate
 * 
 * @author Juha Hinkula
 *
 */
@SpringBootApplication
public class CoursemateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursemateApplication.class, args);
	}
	
	/**
	 * Save students and courses to H2 DB for testing
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(StudentRepository repository, CourseRepository crepository, UserRepository urepository) {
		return (args) -> {
			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user1 = new User("user1", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user3 = new User("user3", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user4 = new User("user4", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user5 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			User user6 = new User("super", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "SUPERUSER");
			urepository.save(user1);
			urepository.save(user2); 
			urepository.save(user3); 
			urepository.save(user4); 
			urepository.save(user5); 
			urepository.save(user6); 
						
			// save students
			repository.save(new Student("A2323", "John", "Johnson", "IT", "john@john.com", user1)); 
			repository.save(new Student("A1123", "Mary", "Robinson", "IT", "mary@robinson.com", user2));
			repository.save(new Student("A3323", "Steve", "Stevens", "IT", "steve.stevent@st.com", user3));
			repository.save(new Student("C4402", "Kate", "Keystone", "Nursery","kate@kate.com", user4));
			repository.save(new Student("B0701", "Diana", "Doll", "Business","diana@doll.com", user5));
		};	
	}
}
