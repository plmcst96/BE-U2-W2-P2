package cristinapalmisani.BEU2W2P2.services;

import cristinapalmisani.BEU2W2P2.entities.User;
import cristinapalmisani.BEU2W2P2.exception.BadRequestException;
import cristinapalmisani.BEU2W2P2.exception.NotFoundException;
import cristinapalmisani.BEU2W2P2.payloads.user.UserRequestDTO;
import cristinapalmisani.BEU2W2P2.repositories.UserRepositoryDAO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepositoryDAO userRepositoryDAO;

    public User save(UserRequestDTO body){
        userRepositoryDAO.findByUsername(body.username()).ifPresent(a -> {
            throw new BadRequestException("Username " + a.getUsername() + " already exists");
        });
        userRepositoryDAO.findByEmail(body.email()).ifPresent(a -> {
            throw new BadRequestException("User with email " + a.getEmail() + " already exists");
        });
        User user = new User();
        user.setUsername(body.username());
        user.setName(body.name());
        user.setSurname(body.surname());
        user.setEmail(body.email());
        return userRepositoryDAO.save(user);
    }

    public Page<User> getUsers(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return userRepositoryDAO.findAll(pageable);
    }

    public User findById(UUID id) throws NotFoundException {
        return userRepositoryDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) throws NotFoundException {
        User user = userRepositoryDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        userRepositoryDAO.delete(user);
    }

    public User findByIdAndUpdate(UUID id, UserRequestDTO body) throws NotFoundException {
        User u = userRepositoryDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        u.setName(body.name());
        u.setSurname(body.surname());
        u.setEmail(body.email());
        return userRepositoryDAO.save(u);
    }
}