<template>
  <div class="app-container">
    <el-steps :align-center="true" :active="2" finish-status="success">
      <el-step title="Base Info"></el-step>
      <el-step title="Course Outline"></el-step>
      <el-step title="Publish"></el-step>
    </el-steps>

    <el-card class="box-card" style="margin-left: 200px">
      <div slot="header" class="clearfix">
        <span>Course Info</span>
      </div>

      <el-form ref="form" :model="course" label-width="100px" label-position="left">
        <el-form-item label="Title">
          <el-input v-model="course.title" disabled></el-input>
        </el-form-item>
        <el-form-item label="Cover">
          <el-image
            style="width: 100px; height: 100px"
            :src="course.cover"
            fit="fit">
          </el-image>
        </el-form-item>
        <el-form-item label="Sort">
          <span style="margin-right: 15px">{{course.firstLabel}}</span>
          <span>{{course.secondLabel}}</span>
        </el-form-item>
        <el-form-item label="Teacher">
              <span>
                {{course.teacherName}}
              </span>
        </el-form-item>
        <el-form-item label="Total Time">
          <el-input-number :min="0" v-model="course.lessonNum" disabled></el-input-number>
        </el-form-item>
        <el-form-item label="Price">
          <el-input v-model="course.price" disabled></el-input>
        </el-form-item>
        <el-form-item label="Description">
          <el-input type="textarea" v-model="course.description" disabled></el-input>
        </el-form-item>
      </el-form>
    </el-card>

    <el-card class="box-card" style="margin-left: 200px; margin-top: 10px">
      <div slot="header" class="clearfix">
        <span>Chapter Info</span>
      </div>

      <el-tree
        :data="chapters"
        node-key="id"
        default-expand-all
        :props="defaultProps"
        :expand-on-click-node="false">
            <span class="custom-tree-node"
                  slot-scope="{ node, data }">
              <span v-if="node.level === 1"
                    class="span1"
                    style="font-size: 20px; font-weight: bold;">{{ node.label }}</span>
              <span v-else-if="node.level === 2"
                    style="font-size: 14px">{{ node.label }}</span>
            </span>
      </el-tree>

    </el-card>

    <el-form label-width="200px" style="margin-top: 10px" class="text item">
      <el-form-item>
        <el-button @click="back">Back</el-button>
        <el-button @click="handlePublish"
                   style="float:right; margin-right: 200px">
          Publish !
        </el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
  import course from "../../../api/course_manage/course";
  import chapter from "../../../api/course_manage/chapter";

  export default {
    data() {
      return {
        course: {
          id: '', // 唯一标识
          title: '', // 标题
          lessonNum: 0, // 课时
          price: 0, // 价格
          description: '', // 描述信息
          teacherId: '', // 讲师id
          cover: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', // 封面
          typeId: '', // 一级分类id
          subjectId: '', // 二级分类id
          firstLabel: '', // 一级分类名称
          secondLabel: '', // 二级分类名称
          teacherName: '', // 讲师名称
          status: 0 // 发布状态
        },
        chapters: [], // 章节列表
        defaultProps: { // 参数
          children: 'children',
          label: 'title'
        }
      };
    },
    created() {
      // 从缓存中读取数据
      const course = localStorage.getItem("course");
      const chapters = localStorage.getItem("chapters");
      if (!course) {
        // 缓存中没有course数据，跳转inset页面进行填写
        this.$router.push({path: '/course_manage/insert'});
        return;
      }
      if (!chapters) {
        // 缓存中没有chapters数据，跳转chapter页面填写
        this.$router.push({path: '/course_manage/chapter'});
        return;
      }
      // 进行转换
      this.course = JSON.parse(course);
      this.chapters = JSON.parse(chapters);
    },
    methods: {
      /**
       * 发布课程信息
       */
      handlePublish() {
        // 将发布状态更新
        this.course.status = 1;
        // 调用接口
        course.insertCourse(this.course).then(res => {
          this.$message.success(res.message);
          const id = res.data;
          // 将章节和小节的课程id进行赋值
          this.chapters.forEach(c => {
            c.courseId = id;
            c.children.forEach(v => {
              v.courseId = id;
            });
            chapter.insertChapter(c).then(res => {
            }).catch(err => {
              this.$message.error(err);
            });
          });
        }).catch(err => {
          this.$message.error(err);
        });
        // 跳转到管理页面
        this.$router.push({path: '/course_manage/management'});
      },
      /**
       * 回退
       */
      back() {
        this.$router.push({path: '/course_manage/chapter'});
      }
    }
  }
</script>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 1050px;
  }
  .el-form-item .el-form-item {
    margin-bottom: 20px;
  }

  .span1 {
    font-family: 'Microsoft YaHei', 'WenQuanYi Micro Hei', 'sans-serif';
  }
</style>

