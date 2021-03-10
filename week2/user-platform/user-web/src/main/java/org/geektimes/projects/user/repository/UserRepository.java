package org.geektimes.projects.user.repository;

import org.geektimes.projects.user.domain.User;

import java.util.Collection;

/**
 * 用户存储仓库
 *
 * @author hxhowl
 * @since 2021/3/9
 */
public interface UserRepository {

    boolean save(User user);

    boolean deleteById(Long userId);

    boolean update(User user);

    User getById(Long userId);

    User getByNameAndPassword(String userName, String password);

    Collection<User> getAll();

    User getByName(String name);
}
