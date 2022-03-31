package com.zgm.server.controller;

import com.zgm.server.dto.HomeDepartDTO;
import com.zgm.server.dto.HomePositionDTO;
import com.zgm.server.mapper.*;
import com.zgm.server.pojo.Notice;
import com.zgm.server.service.INoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "首页模块")
@RestController
public class HomeController {

    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private TransdepartMapper transdepartMapper;
    @Autowired
    private TranssalaryMapper transsalaryMapper;
    @Autowired
    private INoticeService noticeService;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private DepartMapper departMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询通知（后5条）
     * @return
     */
    @ApiOperation(value = "查询通知（后5条）")
    @GetMapping("/home/notice")
    public List<Notice> getHomeNotice() {
        return noticeService.getHomeNotice();
    }

    /**
     * 首页员工信息
     */
    @ApiOperation(value = "首页员工信息")
    @GetMapping("/home/info")
    public Map getHomeEmpInfo() {
        HashMap<String, Integer> empInfo = new HashMap<>();
        empInfo.put("homeEmployees", employeeMapper.selectCount(null));
        empInfo.put("homeDeparts", departMapper.selectCount(null));
        empInfo.put("homeLeaves", leaveMapper.selectCount(null));
        empInfo.put("homeNotices", noticeMapper.selectCount(null));
        return empInfo;
    }

    /**
     * 首页员工职位统计
     */
    @ApiOperation(value = "首页员工职位统计")
    @GetMapping("/home/position")
    public  List<HomePositionDTO> getHomeEmpPosition() {
        List<HomePositionDTO> homePosition = employeeMapper.getHomePosition();
        return homePosition;
    }

    /**
     * 首页员工申请总览
     */
    @ApiOperation(value = "首页员工申请总览")
    @GetMapping("/home/approve")
    public  List<Map> getHomeEmpApprove() {
        List<Map> homeApprove = new ArrayList<>();
        HashMap<String, Object> leaveApprove = new HashMap<>();
        leaveApprove.put("name", "请假申请");
        leaveApprove.put("value", leaveMapper.selectCount(null));
        HashMap<String, Object> departApprove = new HashMap<>();
        departApprove.put("name", "部门调动");
        departApprove.put("value", transdepartMapper.selectCount(null));
        HashMap<String, Object> salaryApprove = new HashMap<>();
        salaryApprove.put("name", "调薪申请");
        salaryApprove.put("value", transsalaryMapper.selectCount(null));
        homeApprove.add(leaveApprove);
        homeApprove.add(departApprove);
        homeApprove.add(salaryApprove);
        return homeApprove;
    }

    /**
     * 首页员工部门统计
     */
    @ApiOperation(value = "首页员工部门统计")
    @GetMapping("/home/depart")
    public  List<HomeDepartDTO> getHomeEmpDepart() {
        List<HomeDepartDTO> homeDepart = employeeMapper.getHomeEmpDepart();
        return homeDepart;
    }
}
