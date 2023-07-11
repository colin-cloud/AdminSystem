<template>
  <div class="app-container">

    <el-form label-width="120px" label-position="left">

      <el-form-item label="文件模板">
        <el-button type="info" style="margin-right: 20px" plain disabled>模板详情</el-button>
        <el-link type="primary" :href="url">模板下载</el-link>
      </el-form-item>

      <el-form-item label="待上传文件">
        <el-upload
          ref="upload"
          drag
          :before-upload="beforeUpload"
          :on-success="successUpload"
          :on-progress="progressUpload"
          :on-change="changeUpload"
          :on-remove="removeFile"
          accept=".xlsx"
          :auto-upload="false"
          :multiple="false"
          action="http://192.168.223.132:9001/edu-service/edu-subject/insertSubjectByFile"
          >
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em>
            <div class="el-upload__tip" slot="tip">只能上传一个xlsx文件，且不超过100kb</div>
          </div>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary"
                   :disabled="disabled"
                   :loading="loading"
                   @click="uploadFile">上传文件</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
export default {

  data() {
    return {
      url: 'https://edu-sys-terriss.oss-cn-beijing.aliyuncs.com/template/read.xlsx',
      disabled: true,
      loading: false
    }
  },
  watch: {
  },
  methods: {
    // 限制文件
    beforeUpload(file) {
      const isPNG = /^.xlsx$/.test(file.name.substring(file.name.lastIndexOf('.')));
      const isLt100KB = file.size / 1024  < 100;
      if (!isPNG) {
        this.$message.error("上传图片只能是 XLSX 格式!");
        return false;
      }
      if (!isLt100KB) {
        this.$message.error("上传图片大小不能超过 100KB!");
        return false;
      }
      this.disabled = false;
      return true;
    },
    // 点击上传按钮后触发
    uploadFile() {
      this.disabled = true;
      this.loading = true;
      this.$refs.upload.submit();
    },
    // 上传文件成功
    successUpload() {
      this.loading = false;
      this.$message.success("上传成功");
      // 跳转文件列表中
      this.$router.push({
        path: '/subject_manage/management'
      });
    },
    //文件上传时的钩子
    progressUpload(event, file, fileList) {
      console.log(file);
    },
    //文件状态改变时的钩子，添加文件、上传成功和上传失败时都会被调用
    changeUpload(file, fileList) {
      this.disabled = fileList.length !== 1;
    },
    //从文件列表中删除文件
    removeFile() {
      this.disabled = true;
    }

  }
}
</script>

<style>
  .el-upload .el-upload-dragger {
    width: 1300px;
    height: 180px;
    line-height: 25px;
  }
</style>

