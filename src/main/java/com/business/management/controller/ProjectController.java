package com.business.management.controller;

import com.business.management.annotation.PassToken;
import com.business.management.annotation.UserLoginToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;
import com.business.management.service.*;
import com.business.management.util.ValueUtil;
import com.business.management.vo.ProjectBaseinfoVO;
import com.business.management.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author : Cunho
 * @date : 2020/4/15
 */
@Slf4j
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

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
    @RequestMapping(value = "/baseinfo/save", method = RequestMethod.POST)
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
     * 프로젝트 상세정보 저장
     * 제품정보 + 가격정보 + 이력정보 + 타임라인 + 파일정보
     * @param session
     * @param projectVO
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/detail/save", method = RequestMethod.POST)
    public ServerResponse detail_save(HttpSession session, @RequestBody ProjectVO projectVO) {
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


}
