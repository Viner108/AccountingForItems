package by.andrukovich.accounting.repository;

import by.andrukovich.accounting.entity.UserHealth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserHealthRepository extends JpaRepository<UserHealth, String>{
}
