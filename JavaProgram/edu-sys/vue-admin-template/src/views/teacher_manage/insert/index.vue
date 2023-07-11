<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">

      <el-form-item label="Name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>

      <el-form-item label="Career">
        <el-input v-model="form.career"></el-input>
      </el-form-item>

      <el-form-item label="Introduction">
        <el-input v-model="form.intro" :rows="10" type="textarea"></el-input>
      </el-form-item>

      <el-form-item label="Level">
        <el-select v-model="form.level" placeholder="请选择讲师头衔">
          <el-option label="高级讲师" :value="1"></el-option>
          <el-option label="首席讲师" :value="2"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="Sort">
        <el-input-number v-model="form.sort" controls-position="right" :min="0"></el-input-number>
      </el-form-item>

      <el-form-item label="Avatar">
        <el-upload
          class="avatar-uploader"
          action="http://192.168.223.132:9001/edu-oss/ossFile/upload"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="form.avatar" :src="form.avatar" class="avatar" alt="上传失败">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">Save</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
  import teacher from "@/api/teacher_manage/teacher";

  export default {
    data() {
      return {
        form: {
          name: '',
          career: '',
          intro: '',
          level: 1,
          sort: 0,
          avatar: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
        }
      }
    },
    watch: { // 监听
      $route(to, from) {
        // 路由发生变化
      }
    },
    methods: {
      onSubmit() {
        if (this.form.id) {
          // 更新
          teacher.updateTeacher(this.form).then(res => {
            this.$message.success("修改成功");
            // 路由跳转
            this.$router.push({
              path: '/teacher_manage/management'
            });
          }).catch(err => {
            this.$message.error("添加失败");
          });
        } else {
          // 添加
          teacher.insertTeacher(this.form).then(res => {
            this.$message.success("添加成功");
            // 路由跳转
            this.$router.push({
              path: '/teacher_manage/management'
            });
          }).catch(err => {
            this.$message.error("添加失败");
          });
        }
      },
      handleAvatarSuccess(res) {
        this.form.avatar = res.data;
      },
      beforeAvatarUpload() {},
      getTeacherById(id) {
        teacher.getTeacherById(id).then(res => {
          this.form = res.data;
        });
      }
    },
    created() {
      if (this.$route.params && this.$route.params.id) {
        this.getTeacherById(this.$route.params.id);
      }
    }
  }
</script>

<style scoped>
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
