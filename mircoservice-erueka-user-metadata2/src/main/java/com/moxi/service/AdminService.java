package com.moxi.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.moxi.model.Admin;

@Mapper
public interface AdminService {

	/*@Select("SELECT * FROM `moxi`.`admin` where userName = #{userName} and password = #{password} and state = 1;")
	Admin findByNameAndPassword(@Param("userName") String userName,@Param("password") String password);*/
	
	/*@Select("SELECT * FROM `moxi`.`admin` where userName = #{arg0} and password = #{arg1} and state = 1;")
	Admin findByNameAndPassword(String userName,String password);*/
	
	@Select("SELECT * FROM `moxi`.`admin` where userName = #{userName} and password = #{password} and state = 1;")
	Admin findByNameAndPassword(Admin admin);
	
	@Insert("INSERT INTO `moxi`.`admin` (`id`, `userName`, `password`, `realName`, `age`, `phoneNumber`, `headPicture`, `addDate`, `updateDate`, `state`) VALUES (null, #{userName}, #{password}, #{realName}, #{age}, #{phoneNumber}, #{headPicture}, now(), now(), 1);")
	int insert(Admin admin);

}
