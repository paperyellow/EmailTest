package site.mtcoding.emailtest.domian.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "insert into users (username, password, email, emailConfirm) values(:username, :password, :email, :emailConfirm)", nativeQuery = true)
    void join(String username, String password, String email, String emailConfirm);

    @Query(value = "select * from users where username = :username and password = :password", nativeQuery = true)
    Users mLogin(String username, String password);

    @Query(value = "select * from users where username = :username and emailConfirm = :emailConfirm", nativeQuery = true)
    Users mCheck(@Param("username") String username, @Param("emailConfirm") String emailConfirm);

    @Query(value = "update users set emailConfirm = 'Y' where username = :username", nativeQuery = true)
    void mUpdate(@Param("username") String username);

}
