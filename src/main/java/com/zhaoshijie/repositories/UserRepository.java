package com.zhaoshijie.repositories;

import com.zhaoshijie.domain.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Demo class
 *
 * @author Zhao Shijie
 * @date 2019/08/12
 */
public interface UserRepository extends JpaRepository<User, String> {
}
