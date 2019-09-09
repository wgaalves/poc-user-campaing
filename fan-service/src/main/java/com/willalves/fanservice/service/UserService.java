package com.willalves.fanservice.service;

import com.willalves.fanservice.exception.RecordNotFoundException;
import com.willalves.fanservice.model.User;
import com.willalves.fanservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    private SequenceGeneratorService sequenceGeneratorService;

    public User save(User user) throws Exception {
        if(!userRepository.existsByEmail(user.getEmail())){
            user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
            return userRepository.save(user);
        }

        throw new Exception("Usuario já consta em nossa base de dados");

    }

    public User update(User user) {
        if(!userRepository.existsById(user.getId())){
            user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
            return userRepository.save(user);
        }

        throw new RecordNotFoundException("Usuario não consta em nossa base de dados");
    }

    public Optional<User> findById(Long id){
        if(!userRepository.existsById(id)){
            return userRepository.findById(id);
        }

        throw new RecordNotFoundException("Usuario não consta em nossa base de dados");
    }

    public void delete(Long id){
        userRepository.deleteById(id);

    }
}
