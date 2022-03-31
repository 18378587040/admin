package com.zgm.server.mapper;

import com.zgm.server.pojo.Jobtitle;
import com.zgm.server.pojo.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgm.server.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统通知表 Mapper 接口
 * </p>
 *
 * @author ming
 * @since 2022-03-14
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 查询通知
     * @param current
     * @param size
     * @param conditionVO
     * @return
     */
    List<Notice> listNotice(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);
}
