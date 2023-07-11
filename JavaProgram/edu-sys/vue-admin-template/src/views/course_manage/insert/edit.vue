<template>
  <div class="app-container">

    <el-steps :align-center="true" :active="active" finish-status="success">
      <el-step title="Base Info"></el-step>
      <el-step title="Course Outline"></el-step>
      <el-step title="Publish"></el-step>
    </el-steps>


    <el-form label-width="200px">
      <el-form-item>
        <el-button @click="next" :disabled="false">上一步</el-button>
        <el-button @click="next" :disabled="disabled"
                   style="float:right; margin-right: 200px">保存并下一步</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      active: 0,
      disabled: false
    };
  },

  methods: {
    next() {
      this.$router.push({path: '/course_manage/insert/chapter/1'});
    },
  }
}
</script>

<style>

</style>

