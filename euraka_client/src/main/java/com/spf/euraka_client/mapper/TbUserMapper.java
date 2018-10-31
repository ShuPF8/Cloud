package com.spf.euraka_client.mapper;

import com.spf.euraka_client.model.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShuPF
 * @since 2018-10-30
 */
public interface TbUserMapper extends BaseMapper<TbUser> {

    TbUser queryUserByName(String name);

}
