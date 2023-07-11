<template>
  <div class="app-container">
    <!--表单-->
    <el-form :inline="true" class="demo-form-inline">

      <el-form-item label="日期">
        <el-date-picker
          v-model="date"
          type="date"
          placeholder="选择要统计的日期"
          value-format="yyyy-MM-dd" />
      </el-form-item>

      <el-button
        :disabled="btnDisabled"
        type="primary"
        @click="create">生成数据</el-button>
    </el-form>
  </div>
</template>

<script>

  import staticApi from "../../../api/static_analysis/static";

  export default {
    data() {
      return {
        btnDisabled: true,
        date: ''
      }
    },
    watch: {
      date(oldValue, newValue) {
        this.btnDisabled = !newValue;
      }
    },
    methods: {
      create() {
        if (date) {
          staticApi.countDailyRegisters(date).then(res => {
            this.$message.success("生成数据成功");
            this.$router.push({path: '/static_analysis/data'})
          })
        }
      }
    }
  }
</script>

<style scoped>

</style>
