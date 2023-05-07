package be.technifutur.TheCookbook.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedHashSet;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @OneToMany(mappedBy = "user_shoppingList")
    private List<ShoppingList> lists;
    @OneToMany(mappedBy = "user_recipe")
    private List<Recipe> recipes;




    //jwt
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean enabled = true;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new LinkedHashSet<>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map( role -> new SimpleGrantedAuthority("ROLE_"+role) )
                .toList();
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

}