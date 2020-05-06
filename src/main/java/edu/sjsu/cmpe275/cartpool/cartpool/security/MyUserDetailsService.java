package edu.sjsu.cmpe275.cartpool.cartpool.security;

import edu.sjsu.cmpe275.cartpool.cartpool.models.User;
import edu.sjsu.cmpe275.cartpool.cartpool.repositories.UserRepository;
import edu.sjsu.cmpe275.cartpool.cartpool.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
//        List<GrantedAuthority> authorities = getAuthorities(user.getRole());
//        boolean active = user.getActive();
//        boolean accountNonExpired = true;
//        boolean credentialsNonExpired = true;
//        boolean accountNonLocked = true;
//        return new org.springframework.security.core.userdetails.User
//                (user.getEmail(),
//                        user.getPassword(), active, accountNonExpired,
//                        credentialsNonExpired, accountNonLocked,
//                        authorities);
        return new JwtUser(user);
    }

//    private static List<GrantedAuthority> getAuthorities(String role) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(role));
//        return authorities;
//    }
}
