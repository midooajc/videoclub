package formation.sopra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.entity.User;
import formation.sopra.repository.UserRepository;

@Service
public class VideoUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt = userRepository.findByUsernameWithRole(username);
		if (opt.isPresent()) {
			return new VideoUserDetails(opt.get());
		}
		throw new UsernameNotFoundException("erreur utilisateur");
	}
}
