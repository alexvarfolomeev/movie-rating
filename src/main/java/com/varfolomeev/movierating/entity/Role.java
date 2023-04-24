package com.varfolomeev.movierating.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "name")
@Setter
@JsonIgnoreProperties({"users"})
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    public Role(String name) {
        this.name = name;
    }
    @Override
    public String getAuthority() {
        return this.getName();
    }
}
