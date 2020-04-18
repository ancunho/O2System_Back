package com.business.management.service.impl;

import com.business.management.ManagementApplication;
import com.business.management.dao.ProjectBaseinfoMapper;
import com.business.management.vo.ProjectListVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ManagementApplication.class)
public class ProjectBaseinfoServiceImplTest {

    @Autowired
    private ProjectBaseinfoMapper projectBaseinfoMapper;

    @Test
    public void list() {

        List<ProjectListVO> projectList = projectBaseinfoMapper.getProjetList();

        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getProjectSalesMan() != null) {
                System.out.println(">>>>>" + projectList.get(i).getProjectSalesMan());
            }
            System.out.println(projectList.get(i).toString());
        }

    }
}