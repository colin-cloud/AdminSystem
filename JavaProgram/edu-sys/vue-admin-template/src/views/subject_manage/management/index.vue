<template>
  <div class="app-container">
    <el-input v-model="filterText" placeholder="Filter keyword" style="margin-bottom:30px;"/>

    <el-tree
      ref="tree2"
      :data="data"
      :props="defaultProps"
      :filter-node-method="filterNode"
      class="filter-tree"
      default-expand-all
    />

  </div>
</template>

<script>
  import subject from "../../../api/subject_manage/subject";
  export default {

    data() {
      return {
        filterText: '', // 过滤条件
        data: [], // 课程分类数据
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      }
    },
    watch: {
      // 监视filterText并过滤
      filterText(val) {
        this.$refs.tree2.filter(val)
      }
    },
    created() {
      // 获取所有的课程
      this.getAllSubjects();
    },
    methods: {
      // 过滤条件
      filterNode(value, data) {
        if (!value) return true;
        return data.label.toLowerCase().indexOf(value.toLowerCase()) !== -1
      },
      // 获取所有课程
      getAllSubjects() {
        subject.getAllSubjects().then(res => {
          this.data = res.data;
        }).catch(err => {
          this.$message.error("请求错误");
        })
      }
    }
  }
</script>

<style>
  .el-tree-node__content {
    height: 40px;
  }
</style>

