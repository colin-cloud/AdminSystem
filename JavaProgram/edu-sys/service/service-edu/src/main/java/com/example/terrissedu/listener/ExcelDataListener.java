package com.example.terrissedu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.EduSubject;
import com.example.terrissedu.entity.excel.SubjectData;
import com.example.terrissedu.exception.CustomException;
import com.example.terrissedu.service.EduSubjectService;
import com.example.terrissedu.utils.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Terriss
 * @time 2023-07-01 14:53:12
 * @description 读取Excel的监听器
 */

public class ExcelDataListener extends AnalysisEventListener<SubjectData> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelDataListener.class);

    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private EduSubjectService subjectService;

    public ExcelDataListener() { }

    public ExcelDataListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }
    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     * one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context 上下文
     */
    @Override
    public void invoke(SubjectData data, AnalysisContext context) {
        if (data == null) {
            throw new CustomException(ResultCode.ERROR, "无效数据~~");
        }
        exitSubjectAndStore(data);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context 上下文
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 根据data来判断是否有相同的对象在数据库中
     * @param data 对象
     */
    private void exitSubjectAndStore(SubjectData data) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", data.getFirstTitle())
                .eq("pid", 0);
        EduSubject res = subjectService.getOne(wrapper);
        if (res == null) {
            // 创建新的一级标题
            res = new EduSubject(0L, data.getFirstTitle(), 0);
            // 将当前的对象添加进数据库中
            subjectService.save(res);
            // 创建二级标题
            res = new EduSubject(0L, data.getSecondTitle(), 0);
            subjectService.save(res);
            return;
        }
        Long pid = res.getId();
        // 从数据库中查询二级标题

        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", data.getSecondTitle())
                .eq("pid", pid);
        res = subjectService.getOne(queryWrapper);
        if (res == null) {
            res = new EduSubject(pid, data.getSecondTitle(), 0);
            subjectService.save(res);
        }
    }
}
