package com.example.User_Order_CRUD.user.repository;

import com.example.User_Order_CRUD.user.domain.User;
import com.example.User_Order_CRUD.user.domain.UserRequestDto;
import com.example.User_Order_CRUD.user.domain.UserResponseDto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Repository
@Transactional
public class UserRepositoryimp implements UserRepository{
    private final EntityManager em;

    @Autowired
    public UserRepositoryimp(EntityManager em) {
        this.em = em;
    }

    // 트랜잭션으로 데이터 보호
    // CRUD
    // C
    @Override
    public void CreateUser(UserRequestDto requestDto){
        User user = new User();
        user.setName(requestDto.getName());
        em.persist(user);
    }

    // R(Object)
    @Override
    public UserResponseDto findIdByUser(Long id){
        String jpql = "SELECT new com.example.User_Order_CRUD.user.domain.UserResponseDto(u.name)  FROM User u WHERE  u.id = :id";
        return em.createQuery(jpql, UserResponseDto.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    // R(Optional List)
    @Override
    public List<UserResponseDto> findAllUser(){
        String jpql = "SELECT new com.example.User_Order_CRUD.user.domain.UserResponseDto(u.name)" +
                "FROM User u";
        return  em.createQuery(jpql, UserResponseDto.class)
                .getResultList();
    }

    @Override
    public User finduser(Long userId) {
        return em.find(User.class, userId);
    }

    // U
    @Override
    public void updateUserById(Long id, UserRequestDto requestDto){
        User user = em.find(User.class, id);
        if(user != null){
            user.setName(requestDto.getName());
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
