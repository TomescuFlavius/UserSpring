package ro.mycode.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.user.model.User;


public interface UserRepository  extends JpaRepository<User,Long> {

}
