package com.snva.learnerdromeappw.learnerdrome;

import com.snva.learnerdromeappw.learnerdrome.model.dbmodel.Role;
import com.snva.learnerdromeappw.learnerdrome.model.dbmodel.User;
import com.snva.learnerdromeappw.learnerdrome.repository.RoleRepository;
import com.snva.learnerdromeappw.learnerdrome.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class LearnerdromeApplication  {

	public static void main(String[] args) {
		SpringApplication.run(LearnerdromeApplication.class, args);
	}


	@Bean
	CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository) {
		return args -> {

			Role adminRole= roleRepository.findByRoleName("Admin");
			if (adminRole==null){
				adminRole= new Role();
				adminRole.setRoleName("Admin");
				roleRepository.save(adminRole);
			}
			Role learnerRole= roleRepository.findByRoleName("Learner");
			if (learnerRole==null){
				learnerRole = new Role();
				learnerRole.setRoleName("Learner");
				roleRepository.save(learnerRole);

			}
			Role instructorRole= roleRepository.findByRoleName("Instructor");
			if (instructorRole==null){
				instructorRole = new Role();
				instructorRole.setRoleName("Instructor");
				roleRepository.save(instructorRole);
			}

			List<Role> dheerajRoles= new ArrayList<>();
			dheerajRoles.add(adminRole);
			dheerajRoles.add(learnerRole);
			dheerajRoles.add(instructorRole);
			// create a user
			User dheeraj = userRepository.findByEmail("dheeraj@snva.com");
			if (dheeraj==null){
				dheeraj = new User();
				dheeraj.setFirstName("Dheeraj");
				dheeraj.setEmail("dheeraj@snva.com");
				dheeraj.setContact("+11111111");
				dheeraj.setLastName("Singh");
				dheeraj.setProfilePicture("fjddakfjlakdjfldka");
				dheeraj.setRoles(dheerajRoles);
			}
			userRepository.save(dheeraj);

		};
	}
}

