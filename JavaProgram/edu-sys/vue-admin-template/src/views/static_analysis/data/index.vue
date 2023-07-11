<template>
  <div class="app-container">
    <!-- 模糊查询表单 -->
    <el-form :inline="true" :model="statistic" class="demo-form-inline">

      <el-form-item label="Option">
        <el-select v-model="statistic.type" placeholder="option">
          <el-option label="注册人数" value="register_num"></el-option>
          <el-option label="登录人数" value="login_num"></el-option>
          <el-option label="视频播放人数" value="video_view_num"></el-option>
          <el-option label="课程购买量" value="course_num"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-date-picker
          v-model="statistic.begin"
          type="datetime"
          style="cursor: pointer"
          align="right"
          format="yyyy-MM-dd"
          placeholder="begin"
        >
        </el-date-picker>
      </el-form-item>

      <el-form-item>
        <el-date-picker
          v-model="statistic.end"
          type="datetime"
          style="cursor: pointer"
          align="right"
          format="yyyy-MM-dd"
          placeholder="end"
        >
        </el-date-picker>
      </el-form-item>

      <el-form-item>
        <el-button icon="el-icon-search" type="primary"
                   :disabled="btnDisabled" @click="queryData">Query
        </el-button>
        <el-button icon="el-icon-refresh-right" type="info" @click="onClear">Clear</el-button>
      </el-form-item>
    </el-form>

    <div class="chart-container">
      <div id="chart" class="chart" style="height: 500px; width: 100%"></div>
    </div>
  </div>

</template>

<script>
  import * as echarts from 'echarts';
  import staticApi from "../../../api/static_analysis/static";

  export default {
    data() {
      return {
        statistic: {}, // 统计数据
        chart: {}, // 图表
        btnDisabled: true,
        statistics: {} // 回传数据
      }
    },
    created() {

    },
    watch: {
      statistic: {
        deep: true,
        handler(oldVal, newVal) {
          if (newVal.type && newVal.begin) {
            this.btnDisabled = false;
          }
        }
      }
    },
    methods: {
      showChart() {
        // 基于准备好的dom，初始化echarts实例
        this.chart = echarts.init(document.getElementById('chart'));

        // 指定图表的配置项和数据
        let option = {
          title: {
            text: this.statistic.type.toUpperCase(),
          },
          // x轴是类目轴（离散数据）,必须通过data设置类目数据
          xAxis: {
            type: 'category',
            data: this.statistics.dates
          },
          // y轴是数据轴（连续数据）
          yAxis: {
            type: 'value'
          },
          // 系列列表。每个系列通过 type 决定自己的图表类型
          series: [{
            // 系列中的数据内容数组
            data: this.statistics.data,
            // 折线图
            type: 'line'
          }],
          //x坐标轴触发提示
          tooltip: {
            trigger: 'axis'
          },
          //区域缩放
          dataZoom: [{
            show: true,
            height: 30,
            xAxisIndex: [
              0
            ],
            bottom: 30,
            start: 10,
            end: 80,
            handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
            handleSize: '110%',
            handleStyle: {
              color: '#d3dee5'

            },
            textStyle: {
              color: '#fff'
            },
            borderColor: '#90979c'
          },
            {
              type: 'inside',
              show: true,
              height: 15,
              start: 1,
              end: 35
            }],
        };

        this.chart.setOption(option);
      },
      queryData() {
        staticApi.getDataByType(this.statistic).then(res => {
          this.statistics.dates = res.data.dates;
          this.statistics.data = res.data.data;
          this.showChart();
        })
      },
      onClear() {
        this.statistic = {};
      },
    }
  }
</script>

<style scoped>

</style>
