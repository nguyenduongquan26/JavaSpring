package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
	
	MemberRepository repository = new MemberRepository();
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = repository.logOn(username);
		if(member!=null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role:member.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getName()));
			}
			return new User(member.getUsername(), member.getPassword(), true, true, true, true, authorities);
		}
		return null ;
	}

}
