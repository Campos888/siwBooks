package merialdoProject.repository;

import org.springframework.data.repository.CrudRepository;

import merialdoProject.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}