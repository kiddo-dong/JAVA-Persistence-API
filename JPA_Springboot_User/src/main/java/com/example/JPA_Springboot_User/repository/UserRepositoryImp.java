package com.example.JPA_Springboot_User.repository;

import com.example.JPA_Springboot_User.domain.User;
import com.example.JPA_Springboot_User.domain.UserRequestDTO;
import com.example.JPA_Springboot_User.domain.UserResponseDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserRepositoryImp implements UserRepository{
    // 영속성 컨텍스트 DI
    private final EntityManager em;

    public UserRepositoryImp(EntityManager em) {
        this.em = em;
    }

    // C
    @Override
    public void addUser(UserRequestDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        em.persist(user); // 이제 영속성 컨텍스트에 올림
    }


    // R(List)
    @Override
    public List<UserResponseDto> findAllUser(){
        return em.createQuery(
                "SELECT new com.example.JPA_Springboot_User.domain.UserResponseDto(u.name, u.email) FROM User u",
                UserResponseDto.class
        ).getResultList();
    }
    // R Object
    @Override
    public Optional<UserResponseDto> findUserById(Long id){
        try{
            UserResponseDto userResponseDto = em.createQuery("SELECT new com.example.JPA_Springboot_User.domain.UserResponseDto(u.name, u.email) FROM User u WHERE u.id = :id",
                    UserResponseDto.class
            ).setParameter("id",id).getSingleResult();
            return Optional.of(userResponseDto);
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    // U(put)
    @Override
    public void updateUserById(Long id, UserRequestDTO userRequestDTO){
        User user = em.find(User.class, id);
        if(user != null){
            user.setName(userRequestDTO.getName());
            user.setEmail(userRequestDTO.getEmail());
        }
    }

    // D
    @Override
    public void deleteUserById(Long id){
        User user = em.find(User.class, id);
        if(user != null){
            em.remove(user);
        }
    }

}
