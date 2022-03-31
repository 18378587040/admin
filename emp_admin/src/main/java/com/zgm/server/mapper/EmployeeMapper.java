package com.zgm.server.mapper;

import com.zgm.server.dto.HomeDepartDTO;
import com.zgm.server.dto.HomePositionDTO;
import com.zgm.server.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgm.server.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author ming
 * @since 2022-03-10
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 获取所有员工账套
     * @param current
     * @param size
     * @param conditionVO
     * @return
     */
    List<Employee> listEmployeeSalary(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);

    /**
     * 查询员工基本资料
     * @param current
     * @param size
     * @param conditionVO
     * @return
     */
    List<Employee> listEmployees(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 首页员工职位统计
     * @return
     */
    List<HomePositionDTO> getHomePosition();

    /**
     * 首页员工部门统计
     * @return
     */
    List<HomeDepartDTO> getHomeEmpDepart();
}
