package com.business.management.controller;

import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;
import com.business.management.vo.ProjectVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author : Cunho
 * @date : 2020/3/25
 */
@RequestMapping(value = "/api/common")
public class CommonController {

//    @RequestMapping(value = "/file/single/upload", method = RequestMethod.POST)
//    public ServerResponse file_upload(HttpSession session, ) {
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getDesc());
//        }
//
//        return ServerResponse.createBySuccessMessage("Save success!");
//    }


}





