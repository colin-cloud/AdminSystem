<template>
  <div class="app-container">

    <el-steps :align-center="true" :active="1" finish-status="success">
      <el-step title="Base Info"></el-step>
      <el-step title="Course Outline"></el-step>
      <el-step title="Publish"></el-step>
    </el-steps>

    <el-form label-width="200px" style="margin-top: 10px">

      <el-form-item>
        <el-button type="info"
                   round
                   @click="appendChapter"
        >Append Chapter
        </el-button>
      </el-form-item>

      <el-form-item>
        <div class="block">
          <el-tree
            :data="chapters"
            show-checkbox
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
              <span>
                <el-button
                  v-if="node.level === 1"
                  style="margin-right: 20px"
                  type="text"
                  size="mini"
                  @click="() => append(data)">
                  Append
                </el-button>
                <el-button
                  style="margin-right: 20px"
                  type="text"
                  size="mini"
                  @click="() => update(node, data)">
                  Update
                </el-button>
                <el-popconfirm
                  confirm-button-text='确定'
                  cancel-button-text='我再想想'
                  icon="el-icon-info"
                  icon-color="red"
                  title="确定删除吗？"
                  @onConfirm="() => remove(node, data)"
                >
                 <el-button
                   style="margin-right: 200px"
                   type="text"
                   size="mini"
                   slot="reference"
                   >
                   Delete
                  </el-button>
                </el-popconfirm>
              </span>
            </span>
          </el-tree>
        </div>
      </el-form-item>

      <el-form-item>
        <el-button @click="back">Back</el-button>
        <el-button @click="next"
                   style="float:right; margin-right: 200px">Next
        </el-button>
      </el-form-item>

    </el-form>

    <el-dialog title="Chapter Info" :visible.sync="dialogFormVisible">
      <el-form :model="chapterForm">
        <el-form-item label="Title" :label-width="formLabelWidth">
          <el-input style="width: 680px;" v-model="chapterForm.title" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button style="margin-right: 10px" @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveChapter">确 定</el-button>
      </div>
    </el-dialog>

    <el-dialog title="Video Info" :visible.sync="dialogVideo">
      <el-form :model="videoForm">
        <el-form-item label="Title" :label-width="formLabelWidth">
          <el-input v-model="videoForm.title" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Price" :label-width="formLabelWidth">
          <el-select v-model="videoForm.isFree" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Video" :label-width="formLabelWidth">
          <el-upload
            class="upload-demo"
            drag
            action="http://192.168.223.132:9001/edu-vod/vod/upload"
            :on-success="handleAvatarSuccess"
            :on-remove="handleRemove"
            :before-upload="handleBeforeUpload"
            :file-list="fileList"
            :before-remove="beforeRemove"
            :limit="1"
            >
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">
              将文件拖到此处，或<em>点击上传</em>
              <div class="el-upload__tip" slot="tip">只能上传.mp3/.mp4文件</div>
            </div>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button style="margin-right: 10px" @click="dialogVideo = false">取 消</el-button>
        <el-button type="primary" @click="saveVideo">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>

  import chapter from "../../../api/course_manage/chapter";
  import video from "../../../api/course_manage/video";

  export default {
    data() {
      return {
        flag: false,
        fileList: [],
        updateOp: false, // 是否为更新操作
        treeNode: {}, //向一级标题添加二级标题时的信息
        options: [{ // 选择
          value: 0,
          label: '收费'
        },{
          value: 1,
          label: '免费'
        }],
        videoForm: {}, //小节信息
        dialogVideo: false, // 小节表单可视
        formLabelWidth: '120px',
        dialogFormVisible: false, // 表单可视化
        chapterForm: {}, // 章节添加表单信息
        course: {}, // 课程信息
        chapters: [
          { //章节信息
            id: '',
            title: '第1章：java入门',
            sort: 0,
            children: [
              {
                id: '',
                courseId: '',
                chapterId: '',
                title: '第1节：java简介',
                videoSourceId: '',
                videoOriginalName: '',
                sort: 0,
                playCount: '',
                isFree: 0,
                duration: 0.0,
                status: 0,
                size: ''
              }
            ] // 每个章节中的小节信息
          }
        ],
        defaultProps: {
          children: 'children',
          label: 'title'
        }
      }
    },
    computed: {
      // 章节标题
      chapterTitle() {
        return this.chapterForm.title = '第' +
          (this.chapters.length + 1) + '章：' + this.chapterForm.title;
      },
      // 小节标题
      videoTitle() {
        return this.videoForm.title = '第' +
          (this.treeNode.children.length + 1)
          + '节：' + this.videoForm.title;
      }
    },
    created() {
      // 从缓存中读取数据
      const course = localStorage.getItem("course");
      if (!course) {
        this.$router.push({path: '/course_manage/insert'});
        return;
      }
      this.course = JSON.parse(course);
      const chapters = localStorage.getItem("chapters");
      if (chapters) {
        this.chapters = JSON.parse(chapters);
      }
    },
    methods: {
      /**
       * 点击下一步触发事件，跳转路由
       */
      next() {
        // 将当前信息放入缓存中
        localStorage.setItem("chapters", JSON.stringify(this.chapters));
        this.$router.push({path: '/course_manage/publish'});
      },
      /**
       * 点击上一步出发时间，跳转路由
       */
      back() {
        this.$router.push({path: '/course_manage/insert'});
      },
      /**
       * 根据课程id获取章节信息
       */
      getAllChaptersByCourseID() {
        chapter.getAllChaptersByCourseID(1).then(res => {
          this.chapters = res.data;
        }).catch(err => {
          this.$message.error(err);
        })
      },
      // 向章节中添加结点
      append(data) {
        // 小节表单可视
        this.dialogVideo = true;
        this.updateOp = false;
        this.treeNode = data;
      },
      update(node, data) {
        //将当前节点保存
        this.updateOp = true;
        this.treeNode = node;
        // 判断当前是否是一级标题
        // 数据进行回显
        if (node.level === 1) {
          this.dialogFormVisible = true;
          this.chapterForm = data;
          const index = this.chapterForm.title.indexOf('：');
          this.chapterForm.title = this.chapterForm.title.substr(index + 1);
        } else {
          if (data.videoOriginalName && data.videoOriginalName.length > 0 && this.fileList.length === 0) {
            this.fileList.push({name: data.videoOriginalName});
          }
          this.dialogVideo = true;
          this.videoForm = data;
          const index = this.videoForm.title.indexOf('：');
          this.videoForm.title = this.videoForm.title.substr(index + 1);
        }
      },
      // 移除当前结点
      remove(node, data) {
        console.log(data);
        // 判断当前是否是一级标题
        if (node.level === 1) {
          // 判断是否有子结点
          if (!node.isLeaf) {
            //提示不可删除
            this.$message.error("该章节不可删除，请先删除其中的小节~~");
            return;
          }
        }
        // 获取父结点找到当前结点并删除
        const parent = node.parent;
        const children = parent.data.children || parent.data;
        const index = data.sort;
        children.splice(index, 1);
      },
      // 点击添加按钮
      appendChapter() {
        // 弹出表单
        this.dialogFormVisible = true;
      },
      // 向列表中添加一个一级标题
      saveChapter() {
        // 数据不存在时添加
        if (!this.updateOp) {
          // 对标题进行拼接
          this.chapterForm.title = this.chapterTitle;
          // 添加属性sort进行排序
          this.chapterForm.sort = this.chapters.length;
          // 向数组尾部添加数据
          this.chapters.push(this.chapterForm);
        } else {
          // 获取父结点找到当前结点并删除
          const parent = this.treeNode.parent;
          const children = parent.data.children || parent.data;
          const index = this.chapterForm.sort;
          children[index] = this.chapterForm;
        }
        // 关闭弹窗
        this.dialogFormVisible = false;
        // 将数据清空
        this.chapterForm = {};
      },
      // 向章节中添加一个二级标题
      saveVideo() {
        if (!this.treeNode.children) {
          this.$set(this.treeNode, 'children', []);
        }
        // 默认免费
        if (!this.videoForm.isFree) {
          this.videoForm.isFree = 1;
        }
        // 更改标题
        if (!this.updateOp) {
          this.videoForm.title = this.videoTitle;
          this.treeNode.children.push(this.videoForm);
        }
        // 关闭对话框
        this.dialogVideo = false;
        // 将数据清空
        this.videoForm = {};
      },
      // 视频上传成功
      handleAvatarSuccess(res, file, fileList) {
        this.videoForm.videoSourceId = res.data['videoId'];
        const index = file.name.lastIndexOf('.');
        file.name = res.data['videoName'] + file.name.substr(index);
        this.videoForm.videoOriginalName = file.name;
        this.fileList.push(file);
      },
      // 从文件列表中移除文件时
      handleRemove(file, fileList) {
        if (this.flag) {
          return;
        }
        // 将数据库中和服务器端的文件删除
        video.removeVideoById(this.videoForm.videoSourceId).then(res => {
          this.videoForm.videoOriginalName = '';
          this.videoForm.videoSourceId = '';
          this.fileList = [];
        }).catch(err => {
          this.$message.error(err);
        });
      },
      // 文件上传前
      handleBeforeUpload(file) {
        // 判断当前文件列表中是否有文件
        this.flag = false;
        if (this.fileList.length > 0) {
          // 提示信息
          this.$message.error("只能上传一个视频文件~~");
          this.flag = true;
          return false;
        }
        return true;
      },
      beforeRemove(file, fileList) {
        if (this.flag) {
          return;
        }
        return this.$confirm(`确定移除 ${ file.name }？`);
      }
    }
  }
</script>

<style>
  .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
  }

  .span1 {
    font-family: 'Microsoft YaHei', 'WenQuanYi Micro Hei', 'sans-serif';
  }

  .el-tree-node__content {
    height: 50px;
  }

  .el-upload .el-upload-dragger {
    width: 400px;
    height: 180px;
    line-height: 25px;
  }
</style>

