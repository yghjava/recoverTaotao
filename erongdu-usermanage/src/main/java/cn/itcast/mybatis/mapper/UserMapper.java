package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

/**
 * A user mapper
 * 
 * @author yuangh
 *
 * @company erongdu
 *
 * @data 2017年8月28日
 */
public interface UserMapper {

	public List<User> findUserList();
}
