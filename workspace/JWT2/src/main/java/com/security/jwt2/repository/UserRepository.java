package com.security.jwt2.repository;

import com.security.jwt2.domain.entity.User;
import com.security.jwt2.domain.entity.UserAuthority;
import com.security.jwt2.domain.enumType.Authority;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager entityManager;

    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public Optional<User> findById(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        return Optional.ofNullable(entityManager.find(User.class, userId));
    }

    public Optional<User> findByLoginId(String loginId) {
        if (loginId == null) {
            throw new IllegalArgumentException("회원 로그인id누락");
        }
        String query = "SELECT u FROM User u WHERE u.loginId =:loginId";

        List<User> userList = entityManager.createQuery(query, User.class)
                .setParameter("loginId", loginId)
                .getResultList();

        return userList.stream().findAny();
    }

    public UserAuthority saveDefaultUserAuthority(User user) {
        UserAuthority authority = new UserAuthority();
        authority.setUser(user);
        authority.setAuthority(Authority.USER);
        entityManager.persist(authority);
        return authority;
    }


}
