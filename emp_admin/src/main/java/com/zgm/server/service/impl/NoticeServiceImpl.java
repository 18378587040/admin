package com.zgm.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zgm.server.pojo.Jobtitle;
import com.zgm.server.pojo.Notice;
import com.zgm.server.mapper.NoticeMapper;
import com.zgm.server.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgm.server.utils.PageUtils;
import com.zgm.server.vo.ConditionVO;
import com.zgm.server.vo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统通知表 服务实现类
 * </p>
 *
 * @author ming
 * @since 2022-03-14
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public void deleteNotice(List<Integer> noticeIdList) {
        noticeMapper.deleteBatchIds(noticeIdList);
    }

    @Override
    public void saveOrUpdateNotice(Notice notice) {
        this.saveOrUpdate(notice);
    }

    @Override
    public PageResult<Notice> listNotice(ConditionVO conditionVO) {
        List<Notice> noticeList = noticeMapper.listNotice(PageUtils.getLimitCurrent(), PageUtils.getSize(), conditionVO);
        // 查询总量
        Integer count = noticeMapper.selectCount(new LambdaQueryWrapper<Notice>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Notice::getName, conditionVO.getKeywords()));
        return new PageResult<>(noticeList, count);
    }

    @Override
    public List<Notice> getHomeNotice() {
        return noticeMapper.selectList(new LambdaQueryWrapper<Notice>().orderByDesc(Notice::getId).last("limit 3"));
    }
}
