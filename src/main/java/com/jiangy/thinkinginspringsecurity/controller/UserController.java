package com.jiangy.thinkinginspringsecurity.controller;

import com.jiangy.thinkinginspringsecurity.domain.user.entity.User;
import com.jiangy.thinkinginspringsecurity.domain.user.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>创建时间: 2025/2/22 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@Tag(name = "用户")
@Validated
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public void post(@Validated @RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
