package com.example.terrissedu.mapper;

import com.example.terrissedu.entity.StudentMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Mapper
public interface StudentMemberMapper extends BaseMapper<StudentMember> {

    Long countDailyUsers(String date);

    Integer countDailyRegisters(String date);
}
