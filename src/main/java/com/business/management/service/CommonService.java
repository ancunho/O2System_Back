package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.Config;

/**
 * @author : Cunho
 * @date : 2020/3/29
 */
public interface CommonService {

    /**
     * 코드리스트반환
     * @param CNF_CODE
     * @return
     */
    ServerResponse configList(String CNF_CODE);

    /**
     * 신규코드추가
     * @param config
     * @return
     */
    ServerResponse insert(Config config);

    /**
     * update config
     * @param config
     * @return
     */
    ServerResponse update(Config config);
}
