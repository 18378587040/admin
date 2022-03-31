package com.zgm.server.service;

import com.zgm.server.pojo.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgm.server.vo.ConditionVO;
import com.zgm.server.vo.PageResult;

import java.util.List;

/**
 * <p>
 * 系统通知表 服务类
 * </p>
 *
 * @author ming
 * @since 2022-03-14
 */
public interface INoticeService extends IService<Notice> {

    /**
     * 删除通知
     * @param noticeIdList
     */
    void deleteNotice(List<Integer> noticeIdList);

    /**
     * 保存或更新通知
     * @param notice
     */
    void saveOrUpdateNotice(Notice notice);

    /**
     * 查询通知
     * @param conditionVO
     * @return
     */
    PageResult<Notice> listNotice(ConditionVO conditionVO);

    /**
     * 查询通知（后七条）
     */
    List<Notice> getHomeNotice();
}
