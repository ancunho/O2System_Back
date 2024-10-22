package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.Customer;
import com.github.pagehelper.PageInfo;

/**
 * @author : Cunho
 * @date : 2020/3/25
 */
public interface CustomerService {


    /**
     * 고객리스트 반환
     * @return
     */
    ServerResponse<PageInfo> customerList();

    /**
     * id와 고객이름만 반환
     * 리스트로 반환
     * @return
     */
    ServerResponse getCustomerListOnlyIDAndName();


    /**
     * customerId로 고객상세 정보 조회
     * @param customerId
     * @return
     */
    ServerResponse detail(Integer customerId);

    /**
     * 고객정보 신규추가
     * @param customer
     * @return
     */
    ServerResponse create(Customer customer);

    /**
     * 고객정보 수정
     * 해당 고객 등록한자 혹은 관리자만 수정가능
     * @param customer
     * @return
     */
    ServerResponse update(Customer customer);

    /**
     * 아이디로 고객정보 조회
     * @param customerId
     * @return
     */
    Customer getCustomerById(Integer customerId);

    /**
     * 고객명 중복체크
     * @param str
     * @param type
     * @return
     */
    ServerResponse<String> checkCustomerName(String str, String type);

    /**
     * 고객코드 중북체크
     * @param str
     * @param type
     * @return
     */
    ServerResponse<String> checkCustomerCode(String str, String type);

    /**
     * 고객명으로 연관된 프로젝트 리스트 가져오기
     * projectbaseinfo -> PROJECT_CUSTOMERNAME
     * @param customerId
     * @return
     */
    ServerResponse selectProjectListByCustomerId(Integer customerId);

}
