package com.kenny.app.rest.Repo;

import com.kenny.app.rest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
