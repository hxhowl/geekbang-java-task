package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hxhowl
 * @since 2021/3/2
 */
public class UserServiceImpl implements UserService{
    private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    /**
     * 通用处理方式
     */
    private static Consumer<Throwable> COMMON_EXCEPTION_HANDLER = e -> logger.log(Level.SEVERE, e.getMessage());

    private final DatabaseUserRepository databaseUserRepository;

    private static Connection connection;

    public UserServiceImpl() throws Exception{
        String databaseURL = "jdbc:derby:/db/user-platform;create=true";
        connection = DriverManager.getConnection(databaseURL);
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        dbConnectionManager.setConnection(connection);
        this.databaseUserRepository =
                new DatabaseUserRepository(dbConnectionManager);
    }

    @Override
    public boolean register(User user) {
        databaseUserRepository.save(user);
        return false;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return databaseUserRepository.getByNameAndPassword(name, password);
    }

}
