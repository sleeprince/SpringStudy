package com.app.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.app.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM `user` WHERE `userEnable` = 1 AND `userNm` = #{userNm} AND `userPwd` = #{userPwd}")
	public Optional<UserDTO> findUser(UserDTO user);
}
