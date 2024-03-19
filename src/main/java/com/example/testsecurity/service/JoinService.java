package com.example.testsecurity.service;

import com.example.testsecurity.dto.JoinDto;
import com.example.testsecurity.entity.User;
import com.example.testsecurity.enumType.Role;
import com.example.testsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinUser(JoinDto joinDto) {
        log.info("joinUser()");

        //db에 이미 동일한 username을 가진 회원이 존재하는지 검증.
        if (userRepository.existsByUserId(joinDto.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 username입니다.");
        }

        User user = new User(
                joinDto.getUsername(),
                bCryptPasswordEncoder.encode(joinDto.getPassword()),
                Role.ADMIN);

        User save = userRepository.save(user);
        log.info("join complete, join user id = " + save.getUserId());
    }
}
