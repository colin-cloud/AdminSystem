package com.example.terrissedu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.EduSubject;
import com.example.terrissedu.entity.dto.Subject;
import com.example.terrissedu.entity.excel.SubjectData;
import com.example.terrissedu.listener.ExcelDataListener;
import com.example.terrissedu.mapper.EduSubjectMapper;
import com.example.terrissedu.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
public class EduSubjectServiceImpl extends
        ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void insertSubjectByFile(MultipartFile file) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            ExcelReader excelReader = EasyExcel.read(inputStream, SubjectData.class,
                    new ExcelDataListener(this)).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
            // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
            excelReader.finish();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Subject> getAllSubjects() {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", 0);
        // 查询结果
        List<EduSubject> eduSubjects = this.list(wrapper);
        // 创建集合存放一级标题
        List<Subject> res = new ArrayList<>(eduSubjects.size());

        for (EduSubject eduSubject : eduSubjects) {
            // 创建一个subject对象
            Subject subject = new Subject(eduSubject.getId(),
                    eduSubject.getTitle(), new ArrayList<>());
            // 根据pid来查询当前一级标题的子标题
            QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("pid", eduSubject.getId());
            List<EduSubject> list = list(queryWrapper);
            // 添加子标题
            for (EduSubject subject0 : list) {
                subject.getChildren().add(new Subject(subject0.getId(), subject0.getTitle()));
            }
            res.add(subject);
        }

        return res;
    }

    @Override
    public CommonResult<List<EduSubject>> getSecondList(Long id) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", id);
        CommonResult<List<EduSubject>> res = new CommonResult<>();
        return res.success().message(ResultMessage.SUBJECT_QUERY_SUCCESS).data(list(wrapper));
    }

}
