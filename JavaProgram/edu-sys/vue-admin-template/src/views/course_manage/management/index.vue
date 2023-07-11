<template>
  <div class="app-container">
    <!-- 模糊查询表单 -->
    <el-form :inline="true" :model="query" class="demo-form-inline">

      <el-form-item label="Title">
        <el-input v-model="query.title" placeholder="name"></el-input>
      </el-form-item>

      <el-form-item label="FirstLabel">
        <el-select v-model="query.typeId" placeholder="level">
          <el-option
            v-for="item in subjects"
            :key="item.id"
            :label="item.label"
            :value="item.id"
            >
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-date-picker
          v-model="query.begin"
          type="datetime"
          align="right"
          placeholder="begin"
          default-time="00:00:00">
        </el-date-picker>
      </el-form-item>

      <el-form-item>
        <el-date-picker
          v-model="query.end"
          type="datetime"
          align="right"
          placeholder="end"
          default-time="00:00:00">
        </el-date-picker>
      </el-form-item>

      <el-form-item>
        <el-button icon="el-icon-search" type="primary" @click="onSubmit">Query</el-button>
        <el-button icon="el-icon-refresh-right" type="info" @click="onClear">Clear</el-button>
      </el-form-item>
    </el-form>

    <!-- 表格数据 -->
    <el-table
      v-loading="loading"
      :data="formData"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="ID" width="95">
        <template slot-scope="scope">
          {{ (pageNum - 1) * pageSize + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column align="center" label="Title">
        <template slot-scope="scope">
          {{ scope.row.title }}
        </template>
      </el-table-column>

      <el-table-column align="center" label="Cover" width="200">
        <template slot-scope="scope">
          <el-image
            style="width: 80px; height: 80px"
            :src="scope.row.cover"
            fit="contain"
            :preview-src-list="imgList">
          </el-image>
        </template>
      </el-table-column>

      <el-table-column align="center" label="Teacher" width="100">
        <template slot-scope="scope">
          <span>{{ scope.row.teacherName }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center"
                       label="Description" width="300">
          <template slot-scope="scope">
            <el-popover
              placement="top-start"
              title="Description"
              width="400"
              trigger="hover"
              :content="scope.row.description | filtersText"
            >
              <el-button slot="reference">{{scope.row.description | filtersText | filterSub}}</el-button>
            </el-popover>
          </template>
      </el-table-column>

      <el-table-column align="center" class-name="status-col"
                       label="FirstLevel" width="110">
        <template slot-scope="scope">
          <el-tag type="primary">
            {{ scope.row.firstLabel}}
          </el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" class-name="status-col"
                       label="SecondLevel" width="110">
        <template slot-scope="scope">
          <el-tag type="info">
            {{ scope.row.secondLabel}}
          </el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="Display_time" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time"/>
          <span>{{ scope.row.createTime }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="Operation" width="200">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit"
                     circle v-on:click="handleEdit(scope.row)">
          </el-button>
          <el-popconfirm
            confirm-button-text='确定'
            cancel-button-text='我再想想'
            icon="el-icon-info"
            icon-color="red"
            title="确定删除吗？"
            @onConfirm="handleDelete(scope.row.id)"
          >
            <el-button type="danger" icon="el-icon-delete"
                       style="margin-left: 8px"
                       slot="reference" circle
            ></el-button>
          </el-popconfirm>

        </template>
      </el-table-column>

    </el-table>
    <!-- 分页功能 -->
    <div class="block">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[3, 5, 8, 15]"
        :page-size="pageSize"
        style="text-align: center"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>

    <el-dialog top="5vh" width="1000px"
               title="Course Info" :visible.sync="dialogVisible">
      <el-form :model="form" label-position="left" :label-width="formLabelWidth">
        <el-form-item label="Title">
          <el-input v-model="form.title"></el-input>
        </el-form-item>

        <el-form-item label="Cover">
          <el-upload
            class="avatar-uploader"
            action="http://192.168.223.132:9001/edu-oss/ossFile/upload"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
            <img v-if="form.cover" :src="form.cover" class="avatar" alt="上传失败">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>

        <el-form-item label="Sort">
          <el-select v-model="form.typeId"
                     @change="handleChangeFirst"
                     placeholder="请选择课程分类" filterable>
            <el-option
              v-for="item in subjects"
              :key="item.id"
              :label="item.label"
              :value="item.id">
            </el-option>
          </el-select>
          <el-select v-model="form.subjectId" :disabled="disabled"
                     placeholder="请选择课程分类" filterable>
            <el-option
              v-for="item in subs"
              :key="item.id"
              :label="item.label"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="Teacher">

          <el-select v-model="form.teacherId"
                     placeholder="请选择讲师" filterable>
            <el-option
              v-for="item in teachers"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>

        </el-form-item>

        <el-form-item label="Total Time">
          <el-input-number :min="0" v-model="form.lessonNum"></el-input-number>
        </el-form-item>

        <el-form-item label="Price">
          <el-input v-model="form.price"></el-input>
        </el-form-item>

        <el-form-item label="Description">
          <vue-tinymce
            style="width: 85%;"
            v-model="form.description"
            :setting="setting" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button style="margin-right: 10px" @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSave">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
  import course from "../../../api/course_manage/course";
  import teacher from "../../../api/teacher_manage/teacher";
  import subject from "../../../api/subject_manage/subject";
  export default {
    data() {
      return {
        loading: true, // 页面加载
        pageSize: 5, // 当前页内容量
        pageNum: 1, // 当前页码
        query: {}, // 模糊查询对象
        formData: [], // 返回的结果
        total: 0, // 总记录数
        pages: 0, // 总页数
        imgList: [], // 封面地址
        dialogVisible: false, // 对话框可视化
        form: {}, // 当前课程信息
        formLabelWidth: '120px',
        content: "<p>html content</p>",
        setting: {
          height: 500
        },
        teachers: [], // 数据库中的讲师
        subjects: [], // 一级分类
        subs: [], // 二级分类
        disabled: true, // 二级分类可用
      }
    },
    filters: {
      filtersText(val) { // 要判断一下,如果是空就返回空字符串,不然会报错
        if (val != null && val !== '') {
          let reg = /[\u4e00-\u9fa5]/g;
          let names = val.match(reg);
          if (names)
            val = names.join('');
          else
            console.log(val);
          return val;
        } else return '';
      },
      filterSub(val) {
        if (val == null || val === '' || val.length < 10) {
          return val;
        } else {
          return val.substr(0, 10) + '...';
        }
      }
    },
    methods: {
      /**
       * 获取所有的讲师
       */
      getAllTeachers() {
        teacher.getAllTeachers().then(res => {
          this.teachers = res.data;
        }).catch(err => {
          this.$message.error(err);
        })
      },
      /**
       * 获取所有的一级分类
       */
      getAllSubjects() {
        subject.getAllSubjects().then(res => {
          this.subjects = res.data;
        }).catch(err => {
          this.$message.error(err);
        });
      },
      // 请求分页功能
      page() {
        course.page(this.pageSize, this.pageNum, this.query).then(res => {
          this.total = res.data.total;
          this.formData = res.data.records;
          this.pages = res.data.pages;
          for (let i = 0; i < this.formData.length; i++) {
            this.imgList[i] = this.formData[i].cover;
          }
          this.loading = false;
        }).catch(error => {
          console.error(error);
        })
      },
      // 页面变化
      handleSizeChange(pageSize) {
        this.loading = true;
        this.pageSize = pageSize;
        this.page();
      },
      // 当前页码变化
      handleCurrentChange(pageNum) {
        this.loading = true;
        this.pageNum = pageNum;
        this.page();
      },
      // 编辑当前课程
      handleEdit(data) {
        // 显示对话框
        this.dialogVisible = true;
        // 将当前的讲师进行赋值
        this.form = data;
        // 判断当前表单是否有二级标题
        if (this.form.subjectId) {
          this.disabled = false;
          // 将二级标题进行赋值
          const index = this.subjects.findIndex(sub => {
            return sub.id === this.form.typeId;
          });
          this.subs = this.subjects[index].children;
        }
      },
      // 删除当前课程
      handleDelete(id) {
        console.log(id)
        course.removeCourse(id).then(res => {
          this.$message.success('删除成功~');
          this.page();
        }).catch(err => {
          console.log(err);
        });
        this.page();
      },
      // 模糊查询
      onSubmit() {
        this.page();
      },
      // 清空查询条件
      onClear() {
        this.loading = true;
        this.query = {};
        this.page();
      },
      // 关闭对话框前
      handleClose() {
        this.dialogVisible = false;
      },
      // 成功上传头像
      handleAvatarSuccess() {},
      // 上传头像前的准备工作
      beforeAvatarUpload() {},
      // 更新当前信息
      onSave() {
        course.updateCourse(this.form).then(res => {
          this.$message.success("更新课程成功~");
          // 关闭对话框
          this.dialogVisible = false;
        }).catch(err => {
          this.$message.error("更新课程失败~");
        })
      },
      handleChangeFirst() {

      },
      handleHtml($event){
        console.log($event.target)
      }
    },
    created() {
      // 获取所有的讲师
      this.getAllTeachers();
      // 获取课程分类
      this.getAllSubjects();

      this.page();
    },
    mounted() {
    }
  }
</script>
<style>
  .block {
    margin-top: 20px;
  }
  .demo-form-inline {
    padding: 20px;
  }
</style>

