package com.spf.euraka_client.service;

import com.spf.euraka_client.model.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ShuPF
 * @since 2018-10-30
 */
public interface TbUserService extends IService<TbUser> {

    TbUser findByUser(String name);

}
