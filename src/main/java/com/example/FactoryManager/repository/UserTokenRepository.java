package com.example.FactoryManager.repository;

import com.example.FactoryManager.entity.UserToken;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,String> {

    @Modifying
    @Transactional
    @Query("UPDATE UserToken ut SET ut.isValid = false WHERE ut.user.id = :userId AND ut.isValid = true")
    void invalidateAllActiveTokensByUserId(@Param("userId") String userId);

    Optional<UserToken> findByToken(String token);


}
