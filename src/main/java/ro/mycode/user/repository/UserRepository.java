package ro.mycode.user.repository;

import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.mycode.user.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    @Query ("select  u from User u where lower(u.username)=lower(:name)")
    Optional<User> findUserByNameIgnoringCaseJPQL(@Param("name") String name);

    Optional<User> findUserByEmailAndUsername(@Param("email") String email, @Param("username") String username);

}
