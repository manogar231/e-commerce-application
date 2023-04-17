package com.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.map.entity.User;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Modifying
	@Query(value = "update userinfo set user_status =?1 where userid = ?2 ", nativeQuery = true)
	void updateById(String status, int id);

	User findByUsername(String username);

	User findOneByUsernameAndPassword(String username, String password);

}