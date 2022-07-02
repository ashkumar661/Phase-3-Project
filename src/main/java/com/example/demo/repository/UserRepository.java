package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select pojo from User pojo where pojo.userName=?1")
	public User findByUser(String userName);
	
	@Query("select pojo from User pojo where pojo.password=?1")
	public User findByPassword(String userPassword);
	
	@Query("select pojo.id from User pojo where pojo.userName=?1")
	public int findByUserName(String userName);
	
	@Query("select user from User user where id<>4")
	List<User> findAllUsers();
}
