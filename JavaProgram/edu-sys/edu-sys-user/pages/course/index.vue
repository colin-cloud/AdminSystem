<template>
  <div id="aCoursesList" class="bg-fa of">
    <!-- /课程列表 开始 -->
    <section class="container">
      <header class="comm-title">
        <h2 class="fl tac">
          <span class="c-333">全部课程</span>
        </h2>
      </header>
      <section class="c-sort-box">
        <section class="c-s-dl">
          <dl>
            <dt>
              <span class="c-999 fsize14">课程类别</span>
            </dt>
            <dd class="c-s-dl-li">
              <ul class="clearfix">
                <li :class="cur === -1 ? 'current' : ''">
                  <a title="全部" href="#"
                     @click="updateAndPage('全部', -1, -1)">全部</a>
                </li>
                <li v-for="(item, index) in queryList" :key="item.id"
                    :class="index === cur ? 'current' : ''">
                  <a :title="item" href="#"
                     @click="updateAndPage(item, index, item.id)">{{item.label}}</a>
                </li>
              </ul>
            </dd>
            <dd class="c-s-dl-li">
              <ul class="clearfix">
                <li v-for="(item, index) in secondList" :key="item.id"
                    :class="index === secondCur ? 'current' : ''">
                  <a :title="item" href="#"
                     @click="updateSecondAndPage(item, index)">{{item.title}}</a>
                </li>
              </ul>
            </dd>
          </dl>
          <div class="clear"></div>
        </section>
        <div class="js-wrap">
          <section class="fr">
            <span class="c-ccc">
              <i class="c-master f-fM">1</i>/
              <i class="c-666 f-fM">1</i>
            </span>
          </section>
          <section class="fl">
            <ol class="js-tap clearfix">
              <li v-for="(item,index) in list" :key="index"
                  :class="sort === index ? 'current bg-orange' : ''">
                <a :title="item" href="#"
                   style="text-decoration: none"
                   @click="updateAndPageElse(index)">{{item}}</a>
              </li>
            </ol>
          </section>
        </div>

        <div class="mt40">
          <!-- /无数据提示 开始-->
          <section class="no-data-wrap" v-if="pageData.total === 0">
            <em class="icon30 no-data-ico">&nbsp;</em>
            <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
          </section>
          <!-- /无数据提示 结束-->
          <article class="comm-course-list">
            <ul class="of" id="bna">
              <li v-for="course in pageData.records" :key="course.id">
                <div class="cc-l-wrap">
                  <section class="course-img">
                    <img :src="course.cover"
                         class="img-responsive"
                         style="margin: 0 auto; height: 147px"
                         :alt="course.title">
                    <div class="cc-mask">
                      <a :href="`/course/${course.id}`"
                         title="开始学习" class="comm-btn c-btn-1">开始学习</a>
                    </div>
                  </section>
                  <h3 class="hLh30 txtOf mt10">
                    <a :href="`/course/${course.id}`"
                       :title="course.title"
                       class="course-title fsize18 c-333">{{course.title}}</a>
                  </h3>
                  <section class="mt10 hLh20 of">
                    <span class="fr jgTag bg-green">
                      <i class="c-fff fsize12 f-fA">{{freeOrNot(course.price)}}</i>
                    </span>
                    <span class="fl jgAttr c-ccc f-fA">
                      <i class="c-999 f-fA">{{course.saleCount}}人学习</i>
                      |
                      <i class="c-999 f-fA">{{course.viewCount}}评论</i>
                    </span>
                  </section>
                </div>
              </li>
            </ul>
            <div class="clear"></div>
          </article>
        </div>
        <!-- 公共分页 开始 -->
        <div>
          <div class="paging">
            <a href="#" title="首页" @click="pageCourses(1, sort)">首</a>
            <a href="#" title="前一页" @click="pageCourses(pageData.current - 1, sort)"
               :class="pageData.current === 1 ? 'disable' : 'enable'">&lt;</a>
            <a v-for="index in pageData.pages"
               :key="index" href="#"
               @click="pageCourses(index, sort)"
               :style="index === pageData.current ? 'border-color: #68cb9b;color: #68cb9b;' : ''"
               :title="`第${index}页`">{{index}}</a>
            <a href="#" title="后一页" @click="pageCourses(pageData.current + 1, sort)"
               :class="pageData.current === pageData.pages ? 'disable' : 'enable'">&gt;</a>
            <a href="#" title="末页" @click="pageCourses(pageData.pages, sort)">末</a>
            <div class="clear"></div>
          </div>
        </div>
        <!-- 公共分页 结束 -->
      </section>
    </section>
    <!-- /课程列表 结束 -->
  </div>
</template>
<script>
  import course from "../../api/course";

  export default {
    data() {
      return {
        pageSize: 8,
        pageData: {},
        query: {
          title: '',
          teacherName: '',
          firstLabel: ''
        },
        sort: 2, // 排序方式 -下方分类
        queryList: [
          '全部', '数据库', '外语考试', '教师资格证',
          '公务员', '移动开发', '操作系统', '职称英语',
          '英语四级', '英语六级'
        ],
        cur: -1, // 上边的分类
        list: ['关注度', '最新', '价格'],
        secondList: [], // 二级分类
        secondCur: 0
      }
    },
    created() {
      // 请求课程信息 - 根据价格降序
      this.pageCourses(1, this.sort);
      this.getAllSubjects();
    },
    methods: {
      // 判断sort -- 0 关注度 1 最新 2 价格 desc
      pageCourses(cur, sort) {
        course.pageCourses(this.pageSize, cur, this.query, sort).then(res => {
          this.pageData = res.data.data;
        });
      },
      freeOrNot(price) {
        return Number(price) === 0 ? '免费' : '收费';
      },
      updateAndPage(item, index, id) {
        // 将二级分类索引初始化
        this.secondCur = 0;
        // 赋值当前一级分类索引
        this.cur = index;
        // 判断title
        if (index !== -1) {
          this.query.firstLabel = item.label;
          // 将二级分类查询出来
          course.getSecondList(id).then(res => {
            // 通过一级分类和二级分类进行查询
            this.secondList = res.data.data;
            this.query.secondLabel = this.secondList.length === 0 ? '' : this.secondList[0].title;
            this.pageCourses(1, this.sort);
          })
        } else {
          this.query = {};
          this.secondList = [];
          this.pageCourses(1, this.sort);
        }
        return false;
      },
      // 排序查询
      updateAndPageElse(index) {
        this.sort = index;
        this.pageCourses(1, this.sort);
      },
      // 获取所有一级分类
      getAllSubjects() {
        course.getSubjects().then(res => {
          this.queryList = res.data.data;
        })
      },
      // 更新二级分类索引及查询
      updateSecondAndPage(item, index) {
        this.secondCur = index;
        this.query.secondLabel = this.secondList[index].title;
        this.pageCourses(1, this.sort);
      }
    }
  };
</script>

<style>
  .paging > a {
    cursor: pointer;
  }
  .paging > a:hover {
    border-color: #68cb9b;
    color: #68cb9b;
  }
  .enable {
    pointer-events: auto;
  }
  .disable {
    pointer-events: none;
    opacity: 0.5;
    background-color: #ebeef5;
  }
  .js-tap > li > a:hover {
    background-color: #68cb9b;
    color: #ebeef5;
  }
</style>
