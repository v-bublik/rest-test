package com.resttest.utils;

import com.resttest.dto.ShortView;
import com.resttest.dto.UserDto;
import com.resttest.model.User;
import com.resttest.repository.DepartmentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvasa on 02.01.2017.
 */
@Component
public class UserUtils {

    private final DepartmentJpaRepository departmentJpaRepository;

    @Autowired
    public UserUtils(DepartmentJpaRepository departmentJpaRepository) {
        this.departmentJpaRepository = departmentJpaRepository;
    }

    public UserDto convertEntityToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setDescription(user.getDescription());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setMiddleName(user.getMiddleName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        dto.setPhone(user.getPhone());
        dto.setRoles(user.getUserRole());
        dto.setDepartment(user.getDepartment().getName());
        return dto;
    }

    public User convertDtoToEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setUserRole(dto.getRoles());
        entity.setDepartment(departmentJpaRepository.getDepartmentByName(dto.getDepartment()));
        entity.setPhone(dto.getPhone());
        entity.setDescription(dto.getDescription());
        entity.setFirstName(dto.getFirstName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public List<UserDto> convertEntitiesToDtos(List<User> entities) {
        List<UserDto> dtos = new ArrayList<>();
        for (User entity : entities) {
            UserDto dto = new UserDto();
            dto.setId(entity.getId());
            dto.setDescription(entity.getDescription());
            dto.setEmail(entity.getEmail());
            dto.setFirstName(entity.getFirstName());
            dto.setMiddleName(entity.getMiddleName());
            dto.setLastName(entity.getLastName());
            dto.setPassword(entity.getPassword());
            dto.setUsername(entity.getUsername());
            dto.setPhone(entity.getPhone());
            dto.setRoles(entity.getUserRole());
            dto.setDepartment(entity.getDepartment().getName());
            dtos.add(dto);
        }
        return dtos;
    }

    public ShortView convertUserToShortView(User user) {
        ShortView shortView = new ShortView();
        shortView.setId(user.getId());
        shortView.setName(user.getUsername());
        return shortView;
    }

    public List<ShortView> convertUsersToShortViews(List<User> entities) {
        List<ShortView> shortViews = new ArrayList<>();
        for (User entity : entities) {
            ShortView shortView = new ShortView();
            shortView.setId(entity.getId());
            shortView.setName(entity.getUsername());
            shortViews.add(shortView);
        }
        return shortViews;
    }

}