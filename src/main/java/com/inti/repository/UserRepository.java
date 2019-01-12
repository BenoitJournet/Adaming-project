package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.inti.entities.UserManager;

@Repository
public interface UserRepository extends JpaRepository<UserManager, Long>{
	
	@Query("from UserManager WHERE login=:x AND password=:y")
	public UserManager authenticate(@Param("x")String login_user, @Param("y")String password_user);
	
	@Query("from UserManager WHERE login=:x")
	public UserManager findbyname(@Param("x")String login);
	
	@Query("from UserManager WHERE login LIKE CONCAT('%',:s,'%') OR nom_user LIKE CONCAT('%',:s,'%')")
	public List<UserManager> findbyString(@Param("s") String string);

	@Query("from UserManager WHERE user_id=:s")
	public UserManager getOnebyId(@Param("s") long user_id);
	
	@Query("from UserManager WHERE adresse_id=:s")
	public UserManager getOnebyadresse(@Param("s") long adress_id);
	
	
}
