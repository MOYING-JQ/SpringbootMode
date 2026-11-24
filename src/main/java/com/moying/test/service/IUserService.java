package com.moying.test.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moying.test.entity.PageDto;
import com.moying.test.entity.User;
import com.baomidou.mybatisplus.spring.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author moying
 * @since 2026-11-24
 */
public interface IUserService extends IService<User> {

    User selectUser(Integer id);

    int addUser(User user);

    int deleteUser(Integer id);

    int updateUser(User user);

    Page<User> findByPage(PageDto pageDto);
}
