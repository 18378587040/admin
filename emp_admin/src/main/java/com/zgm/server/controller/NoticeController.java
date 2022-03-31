package com.zgm.server.controller;


import com.zgm.server.pojo.Jobtitle;
import com.zgm.server.pojo.Notice;
import com.zgm.server.pojo.Result;
import com.zgm.server.service.INoticeService;
import com.zgm.server.vo.ConditionVO;
import com.zgm.server.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统通知表 前端控制器
 * </p>
 *
 * @author ming
 * @since 2022-03-14
 */
@Api(tags = "系统通知模块")
@RestController
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    /**
     * 查询通知
     * @param conditionVO
     * @return
     */
    @ApiOperation(value = "查询通知")
    @GetMapping("/admin/notice")
    public PageResult<Notice> listNotice(ConditionVO conditionVO) {
        return noticeService.listNotice(conditionVO);
    }

    /**
     * 保存或更新通知
     * @return
     */
    @ApiOperation(value = "保存或更新通知")
    @PostMapping("/admin/notice")
    public Result saveOrUpdateNotice(@RequestBody Notice notice) {
        noticeService.saveOrUpdateNotice(notice);
        return Result.success("");
    }

    /**
     * 删除通知
     * @return
     */
    @ApiOperation(value = "删除通知")
    @DeleteMapping("/admin/notice")
    public Result deleteNotice(@RequestBody List<Integer> noticeIdList) {
        noticeService.deleteNotice(noticeIdList);
        return Result.success("");
    }

}
