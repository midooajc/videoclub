package formation.sopra.service;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import formation.sopra.entity.User;
import formation.sopra.entity.UserRole;

public class VideoUserDetails implements UserDetails {
	private User user;

	public VideoUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roles = new ArrayList<>();
		for (UserRole userRole : user.getRoles()) {
			roles.add(userRole.getRole().toString());
		}

		return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(roles));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getEnable();
	}

}
