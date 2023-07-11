<template>
  <div class="app-container">

    <!-- 模糊查询表单 -->
    <el-form :inline="true" :model="query" class="demo-form-inline">

      <el-form-item label="Name">
        <el-input v-model="query.name" placeholder="name"></el-input>
      </el-form-item>

      <el-form-item label="Level">
        <el-select v-model="query.level" placeholder="level">
          <el-option label="高级讲师" value="1"></el-option>
          <el-option label="首席讲师" value="2"></el-option>
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

      <el-table-column align="center" label="Name">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>

      <el-table-column align="center" label="Avatar">
        <template slot-scope="scope">
          <el-image
            style="width: 80px; height: 80px"
            :src="scope.row.avatar"
            fit="contain"
            :preview-src-list="imgList">
          </el-image>
        </template>
      </el-table-column>

      <el-table-column align="center" label="Career" width="300">
        <template slot-scope="scope">
          <span>{{ scope.row.career }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center"
                       label="Intro" width="300">
        <template slot-scope="scope">
          <el-popover
            placement="top-start"
            title="Introduction"
            width="400"
            trigger="hover"
            :content="scope.row.intro">
            <el-button slot="reference">{{scope.row.intro.substr(0, 10) + "..."}}</el-button>
          </el-popover>
        </template>
      </el-table-column>

      <el-table-column align="center" class-name="status-col"
                       label="Level" width="110">
        <template slot-scope="scope">
          <el-tag :type="scope.row.level === 1 ? 'info' : 'danger'">
            {{ scope.row.level === 1 ? '高级讲师' : '首席讲师'}}
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
          <router-link :to="'/teacher_manage/edit/' + scope.row.id">
            <el-button type="primary" icon="el-icon-edit"
                       circle v-on:click="handleEdit(scope.row)">
            </el-button>
          </router-link>
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
  </div>


</template>

<script>
  import teacher from '@/api/teacher_manage/teacher'
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
        imgList: [], // 头像地址
        dialogVisible: false, // 对话框可视化
        form: {} // 当前讲师
      }
    },
    methods: {
      // 请求分页功能
      page() {
        teacher.page(this.pageSize, this.pageNum, this.query).then(res => {
          this.total = res.data.total;
          this.formData = res.data.records;
          this.pages = res.data.pages;
          for (let i = 0; i < this.formData.length; i++) {
            this.imgList[i] = this.formData[i].avatar;
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
      // 编辑当前讲师
      handleEdit(data) {
        // 显示对话框
        this.dialogVisible = true;
        // 将当前的讲师进行赋值
        this.form = data;
      },
      // 删除当前讲师
      handleDelete(id) {
        teacher.removeTeacher(id).then(res => {
          this.$message.success('删除成功~');
          this.page();
        }).catch(err => {
          console.log(err);
        });
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
        teacher.updateTeacher(this.form).then(res => {
          this.$message.success("更新讲师成功~");
          // 关闭对话框
          this.dialogVisible = false;
        }).catch(err => {
          this.$message.error("更新讲师失败~");
        })
      }
    },
    created() {
      this.page();
    },
    mounted() {
    }
  }
</script>

<style scoped>
  .block {
    margin-top: 20px;
  }
  .demo-form-inline {
    padding: 20px;
  }
</style>
