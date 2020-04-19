package com.business.management.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.business.management.annotation.PassToken;
import com.business.management.annotation.UserLoginToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.ProjectBaseinfo;
import com.business.management.pojo.ProjectRecord;
import com.business.management.pojo.User;
import com.business.management.service.*;
import com.business.management.util.Box;
import com.business.management.util.HttpUtility;
import com.business.management.util.ValueUtil;
import com.business.management.vo.ProjectBaseinfoVO;
import com.business.management.vo.ProjectListVO;
import com.business.management.vo.ProjectVO;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//    @UserLoginToken
    @PassToken
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
            return ServerResponse.createBySuccessMessage(Const.Message.SAVE_OK);
        }

        return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
    }

    /**
     * 프로젝트기본정보 수정
     * @param session
     * @param projectBaseinfo
     * @return
     */
    @PassToken
    @RequestMapping(value = "/baseinfo/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse bseinfo_update(HttpSession session, @RequestBody ProjectBaseinfo projectBaseinfo) {
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
//    @UserLoginToken
    @PassToken
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

    @PassToken
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
    @PassToken
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ServerResponse project_list(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        List<ProjectListVO> projectList = projectBaseinfoService.getProjectlist();
        if (projectList == null) {
            return ServerResponse.createByErrorMessage(Const.Message.SELECT_ERROR);
        }

        Map<String, Object> returnMap = new HashMap<>();
        currentUser.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        returnMap.put("currentUser", currentUser);
        returnMap.put("projectList", projectList);

        return ServerResponse.createBySuccess(Const.Message.SELECT_OK, returnMap);
    }

    @PassToken
    @RequestMapping(value = "/view", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse project_view(HttpSession session, @RequestParam(value = "id") String projectId) {
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

    @RequestMapping(value = "/timeline/list", method = RequestMethod.POST)
    public ServerResponse timeline_list(HttpSession session, @RequestParam(value = "projectId") String projectId) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectDetailService.timeline_list(projectId);
    }

    /**
     * project name check repeat
     * @param session
     * @param projectName
     * @return
     */
    @PassToken
    @RequestMapping(value = "/check/name", method = RequestMethod.POST)
    public ServerResponse check_project_name_repeat(HttpSession session, @RequestParam(value = "projectName") String projectName) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return projectBaseinfoService.getProjectCountByName(projectName);
    }




}
