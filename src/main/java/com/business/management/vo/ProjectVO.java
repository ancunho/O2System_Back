package com.business.management.vo;

import com.business.management.pojo.*;
import lombok.Data;

import java.util.List;

/**
 * 프로젝트 VO
 * @author : Cunho
 * @date : 2020/3/27
 */
@Data
public class ProjectVO {

    private User currentUser;

    // 프로젝트 기본정보
    private ProjectBaseinfo projectBaseinfo;

    // PJ -> 영업담당자정보
//    private List<ProjectSalesman> projectSalesmanList;

    // PJ -> 고객정보
    private Customer customer;

    // PJ -> 제품정보(다수가능)
    private ProjectProduct projectProduct;

    // PJ -> 가격정보
    private ProjectPrice projectPrice;

    // PJ -> 이력정보
    private ProjectRecord projectRecord;

    // PJ -> 이력정보(다수가능)
    private List<ProjectRecord> projectRecordList;

    // PJ -> timeline
    private ProjectTimeline projectTimeline;

    // PJ -> timeline(다수가능)
    private List<ProjectTimeline> projectTimelineList;

    // PJ -> 파일정보
    private List<ProjectFileinfo> projectFileinfoList;

    private String responseMsg;
    private String responseStatus;



}
