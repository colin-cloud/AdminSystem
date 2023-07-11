<template>

  <div class="app-container">

    <el-steps :align-center="true" :active="0" finish-status="success">
      <el-step title="Base Info"></el-step>
      <el-step title="Course Outline"></el-step>
      <el-step title="Publish"></el-step>
    </el-steps>

    <el-form ref="form" :model="form" label-width="200px" label-position="left" >

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
                   @change="handleChangeSecond"
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
                   @change="handleChangeTeacher"
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
<!--        <el-input style="width: 85%" v-model="form.description" :rows="10" type="textarea"></el-input>-->
        <vue-tinymce
          style="width: 85%;"
          v-model="form.description"
          :setting="setting" />
      </el-form-item>

      <el-form-item>
        <el-button @click="next"
                   style="float:right; margin-right: 200px">Next
        </el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>

  import course from "../../../api/course_manage/course";
  import teacher from '../../../api/teacher_manage/teacher';
  import subject from "../../../api/subject_manage/subject";

  // 窗口关闭，清除缓存
  window.onunload = function () {
    localStorage.clear();
  };

  // 实例
  export default {
    data() {
      return {
        form: {
          id: '', // 唯一标识
          title: '', // 标题
          lessonNum: 0, // 课时
          price: 0, // 价格
          description: '', // 描述信息
          teacherId: '', // 讲师id
          cover: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', // 封面
          typeId: '', // 一级分类id
          subjectId: '', // 二级分类id
          firstLabel: '', // 一级分类
          secondLabel: '', // 二级分类
          teacherName: '' // 讲师名字
        },
        teachers: [], // 数据库中的讲师
        subjects: [], // 一级分类
        subs: [], // 二级分类
        disabled: true, // 二级分类可用
        select: '', // 一级分类记录
        content: "<p>html content</p>",
        setting: {
          height: 500
        }
      }
    },
    created() {
      // 获取所有的讲师
      this.getAllTeachers();
      // 获取课程分类
      this.getAllSubjects();
      // 从缓存中读取数据
      let course = localStorage.getItem("course");
      if (course) {
        this.form = JSON.parse(course);
      }
    },
    beforeRouteEnter (to, from, next) {
      let flag = false;
      if (from) {
        // 判断从哪来的路径
        const urls = ['/course_manage/insert', '/course_manage/chapter', '/course_manage/publish'];
        urls.forEach(url => {
          if (url === from.path) {
            flag = true;
          }
        });
      }
      if (!flag) {
        // 如果不是从上面的路径来的就清除缓存信息
        localStorage.removeItem("course");
        localStorage.removeItem("chapters");
      }
      //放行
      next();
    },
    watch: {
      // 监控一级分类值
      subjects: {
        handler(lastVal, newVal) {
          // 读取form中的一级分类是否存在，存在即设定二级分类值
          if (this.form.typeId && this.form.typeId.length > 0) {
            this.disabled = false;
            let res = this.subjects.filter((sub) => {
              return sub.id === this.form.typeId;
            });
            this.subs = res[0].children;
            this.select = this.form.typeId;
          }
        }
      },
      // 监控form表单值
      form: {
        deep: true,
        handler(lastVal, newVal) {
          // 读取form中的一级分类是否存在，存在即设定二级分类值
          if (!newVal.typeId || newVal.typeId.length === 0) {
            return;
          }
          let res = this.subjects.filter((sub) => {
            return sub.id === newVal.typeId;
          });
          if (this.select !== newVal.typeId) {
            this.form.subjectId = '';
          }
          if (this.subjects.length > 0) {
            this.subs = res[0].children;
            this.disabled = false;
            this.select = newVal.typeId;
          }
        }
      }
    },
    methods: {
      /**
       * 进行路由跳转和存储数据
       */
      next() {
        // 将当前信息保存到本地缓存中
        localStorage.setItem("course", JSON.stringify(this.form));
        this.$router.push({
          path: '/course_manage/chapter'
        });
      },
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
       * 上传文件成功后
       * @param res
       */
      handleAvatarSuccess(res) {
        // 赋值得到的图片地址
        this.form.cover = res.data;
      },
      /**
       * 上传文件之前的操作
       */
      beforeAvatarUpload() {},
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
      /**
       * 更新一级分类名称
       * @param val
       */
      handleChangeFirst(val) {
        const index = this.subjects.findIndex(sub => {
          return sub.id === val;
        });
        this.form.firstLabel = this.subjects[index].label;
      },
      /**
       * 更新二级分类名称
       * @param val
       */
      handleChangeSecond(val) {
        const index = this.subs.findIndex(sub => {
          return sub.id === val;
        });
        this.form.secondLabel = this.subs[index].label;
      },
      /**
       * 更新讲师姓名
       * @param val
       */
      handleChangeTeacher(val) {
        const index = this.teachers.findIndex(sub => {
          return sub.id === val;
        });
        this.form.teacherName = this.teachers[index].name;
      }
    },
  }
</script>

<style>
  .el-input {
    width: 85%;
  }
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 100px;
    height: 100px;
    display: block;
  }
</style>

