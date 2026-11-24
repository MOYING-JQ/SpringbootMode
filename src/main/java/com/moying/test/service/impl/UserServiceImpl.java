package com.moying.test.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moying.test.entity.PageDto;
import com.moying.test.entity.User;
import com.moying.test.mapper.UserMapper;
import com.moying.test.service.IUserService;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author moying
 * @since 2026-11-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final List<String> ALLOW_SORT = List.of("age","create_time");
    private static final List<String> ALLOW_ORDER = List.of("asc", "desc");


    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUser(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Page<User> findByPage(PageDto pageDto) {

        if (pageDto.getSortField() == null || !ALLOW_SORT.contains(pageDto.getSortField())) {
            pageDto.setSortField("create_time");
        }

        if (pageDto.getSortOrder() == null || !ALLOW_ORDER.contains(pageDto.getSortOrder())) {
            pageDto.setSortOrder("asc");
        }

        long pageNum = pageDto.getCurrent() == null ? 1L : pageDto.getCurrent();
        long pageSize = pageDto.getSize() == null ? 2L : pageDto.getSize();

        if (pageSize < 1){
            pageSize = 2L;
        }
        if (pageNum < 1){
            pageNum = 1L;
        }

        Page<User> page = new Page<>(pageNum,pageSize);
        Page<User> result = userMapper.findByPage(page,pageDto);
        return result;
    }
}
