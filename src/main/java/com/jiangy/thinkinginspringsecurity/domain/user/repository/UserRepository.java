package com.jiangy.thinkinginspringsecurity.domain.user.repository;

import com.jiangy.thinkinginspringsecurity.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户仓库
 * <p>创建时间: 2025/2/22 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
