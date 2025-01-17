package com.business.management.controller;


import com.business.management.annotation.UserLoginToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.ProjectBaseinfo;
import com.business.management.pojo.ProjectTimeline;
import com.business.management.pojo.User;
import com.business.management.service.*;
import com.business.management.vo.ProjectBaseinfoVO;
import com.business.management.vo.ProjectListVO;
import com.business.management.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : Cunho
 * @date : 2020/4/15
 */
@Slf4j
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectBaseinfoService projectBaseinfoService;

    @Autowired
    private ProjectDetailService projectDetailService;

    /**
     * 프로젝트 기본정보 저장
     * 기본정보 + 고객정보 + 영업담당자정보
     * @param session
     * @param projectBaseinfoVO
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/baseinfo/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse baseinfo_save(HttpSession session, @RequestBody ProjectBaseinfoVO projectBaseinfoVO) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        // 0. Ojbect유효성 검사
        if (projectBaseinfoVO == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        projectBaseinfoVO.setCurrentUser(currentUser);
        // 1. 기본정보 저장
        ServerResponse response = projectBaseinfoService.save(projectBaseinfoVO);
        if (response.isSuccess()) {
            return ServerResponse.createBySuccess(Const.Message.SAVE_OK,response.getData());
        }

        return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
    }

    /**
     * 프로젝트기본정보 수정
     * @param session
     * @param projectBaseinfo
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/baseinfo/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse bseinfo_update(HttpSession session, @RequestBody ProjectBaseinfoVO projectBaseinfo) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectBaseinfoService.update(projectBaseinfo);
    }

    /**
     * 프로젝트 상세정보 저장
     * 제품정보 + 가격정보 + 이력정보 + 타임라인 + 파일정보
     * @param session
     * @param projectVO
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/detail/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse detail_create(HttpSession session, @RequestBody ProjectVO projectVO) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        if (projectVO == null) {
            return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
        }

        ServerResponse response = projectDetailService.save(projectVO);
        if (response.isSuccess()) {
            return ServerResponse.createBySuccessMessage(Const.Message.SAVE_OK);
        }

        return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
    }

    @UserLoginToken
    @RequestMapping(value = "/detail/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse detail_update(HttpSession session, @RequestBody ProjectVO projectVO) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        if (projectVO == null) {
            return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
        }

        ServerResponse response = projectDetailService.update(projectVO);
        if (response.isSuccess()) {
            return ServerResponse.createBySuccessMessage(Const.Message.SAVE_OK);
        }

        return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
    }

    /**
     * 프로젝트 리스트 반환
     * @param session
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServerResponse project_list(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        List<ProjectListVO> projectList = projectBaseinfoService.getProjectlist();

        return ServerResponse.createBySuccess(Const.Message.SELECT_OK, projectList);
    }

    @UserLoginToken
    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public ServerResponse project_view(HttpSession session, @RequestParam(value = "projectId") String projectId) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        ProjectVO project = projectDetailService.project_view(projectId);
        if (project == null) {
            return ServerResponse.createByErrorMessage(Const.Message.SELECT_ERROR);
        }

        return ServerResponse.createBySuccess(project);
    }

    @UserLoginToken
    @RequestMapping(value = "/timeline/list", method = RequestMethod.POST)
    public ServerResponse timeline_list(HttpSession session, @RequestParam(value = "projectId") Integer projectId) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectDetailService.timeline_list(projectId);
    }

    /**
     * 타임라인 업데이트
     * @param session
     * @param projectTimeline
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/timeline/update", method = RequestMethod.POST)
    public ServerResponse timeline_update(HttpSession session, @RequestBody ProjectTimeline projectTimeline) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectDetailService.timeline_update(projectTimeline);
    }

    /**
     * 타임라인 새로 생성
     * @param session
     * @param projectTimeline
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/timeline/create", method = RequestMethod.POST)
    public ServerResponse timeline_create(HttpSession session, @RequestBody ProjectTimeline projectTimeline) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectDetailService.timeline_create(projectTimeline);
    }

    /**
     * 타임라인 삭제
     * @param session
     * @param timelineId
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/timeline/delete", method = RequestMethod.POST)
    public ServerResponse timeline_create(HttpSession session, @RequestParam(value = "id") Integer timelineId) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectDetailService.timeline_delete(timelineId);
    }

    @UserLoginToken
    @RequestMapping(value = "/record/by_id")
    public ServerResponse get_recordlist_by_project_id(HttpSession session, @RequestParam(value = "projectId") Integer projectId) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectDetailService.getRecordByProjectId(projectId);
    }


    /**
     * project name check repeat
     * @param session
     * @param projectName
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/check/name", method = RequestMethod.POST)
    public ServerResponse check_project_name_repeat(HttpSession session, @RequestParam(value = "projectName") String projectName) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectBaseinfoService.getProjectCountByName(projectName);
    }




}
