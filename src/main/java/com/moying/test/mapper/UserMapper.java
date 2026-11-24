package com.moying.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moying.test.entity.PageDto;
import com.moying.test.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author moying
 * @since 2026-11-24
 */
public interface UserMapper extends BaseMapper<User> {

    Page<User> findByPage(Page<User> page, @Param("dto") PageDto pageDto);
}


