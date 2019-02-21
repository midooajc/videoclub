package formation.sopra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.entity.BluRay;
import formation.sopra.entity.Dvd;
import formation.sopra.repository.ArticleRepository;



@Service
public class ConsoleApplicationService implements CommandLineRunner {

	@Autowired
	ArticleRepository myArtRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Dvd dvd1 = new Dvd();
		BluRay bd1 = new BluRay();
		myArtRepo.save(dvd1);
		myArtRepo.save(bd1);
		
		
		
		System.out.println(myArtRepo.findById(1L).get().getClass().getName());
//		List<User> users = myUserRepository.findAll();
//		for(User user : users) {
//			user.setPassword(myPasswordEncoder.encode("toto"));
//			myUserRepository.save(user);
//		}
	}

}
