package com.business.management.service.impl;

import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.dao.ConfigMapper;
import com.business.management.pojo.Config;
import com.business.management.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author : Cunho
 * @date : 2020/3/29
 */
@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private ConfigMapper configMapper;


    @Override
    public ServerResponse configList(String CNF_CODE) {
        List<Config> resultList = configMapper.selectConfigListByCode(CNF_CODE);

        if (resultList == null) {
            return ServerResponse.createByErrorMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        return ServerResponse.createBySuccess(resultList);
    }

    @Override
    public ServerResponse insert(Config config) {
        if (config == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        int resultCount = configMapper.insert(config);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("创建成功");
        }
        return ServerResponse.createByErrorMessage("创建失败");
    }

    @Override
    public ServerResponse update(Config config) {
        if (config == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        int resultCount = configMapper.updateByPrimaryKeySelective(config);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }

        return ServerResponse.createByErrorMessage("更新失败");
    }
}
