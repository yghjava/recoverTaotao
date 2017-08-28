package cn.itcast.mbatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.mbatis.bean.EasyUIResult;
import cn.itcast.mybatis.mapper.NewUserMapper;
import cn.itcast.mybatis.pojo.User;

/**
 * User service
 * 
 * @author yuangh
 *
 * @company erongdu
 *
 * @data 2017年8月28日
 */
@Service
public class NewUserService {

	@Autowired
	private NewUserMapper userMapper;

	/**
	 * Find User by page and rows. Page is current page rows is the records in each
	 * page
	 * 
	 * @param page
	 *            The current page
	 * @param rows
	 *            The records of each page
	 * @return A {@link EasyUIResult} object with data and records
	 */
	public EasyUIResult queryUserList(Integer page, Integer rows) {
		/**
		 * User page helper to complement page
		 */
		PageHelper.startPage(page, rows);
		Example example = new Example(User.class);
		example.setOrderByClause("created DESC");
		List<User> userList = this.userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		EasyUIResult easyUIResult = new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
		return easyUIResult;
	}

	/**
	 * Finding user by id
	 * 
	 * @param id
	 *            The id of user,it is also primary key in database
	 * @return If the id is in database,a use object will be returned,otherwise a
	 *         <code>null</code> will be returned
	 */
	public User queryUserById(Long id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

}
