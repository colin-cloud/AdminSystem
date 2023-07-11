<template>
  <div id="aCoursesList" class="bg-fa of">
    <!-- /课程详情 开始 -->
    <section class="container">
      <section class="path-wrap txtOf hLh30">
        <a href="#" title class="c-999 fsize14">首页</a>
        \
        <a href="#" title class="c-999 fsize14">课程列表</a>
        \
        <span class="c-333 fsize14">{{course.title}}</span>
      </section>
      <div>

        <!-- 课程封面 -->
        <article class="c-v-pic-wrap" style="height: 357px;">
          <section class="p-h-video-box" id="videoPlay">
            <img :src="course.cover"
                 style="width: 100%; height: 100%"
                 :alt="course.title" class="dis c-v-pic">
          </section>
        </article>
        <!-- 课程封面 -->

        <!-- 课程基本信息 -->
        <aside class="c-attr-wrap">
          <section class="ml20 mr15">
            <h2 class="hLh30 txtOf mt15">
              <span class="c-fff fsize24">{{course.title}}</span>
              <b class="c-yellow"
                 style="font-size:14px; font-weight: 300; margin-left: 5px">
                {{isBought ? '已购买' : ''}}</b>
            </h2>
            <section class="c-attr-jg">
              <span class="c-fff">价格：</span>
              <b class="c-yellow" style="font-size:24px;">￥{{course.price}}</b>
            </section>
            <section class="c-attr-mt c-attr-undis">
              <span class="c-fff fsize14">主讲： {{course.teacherName}}&nbsp;&nbsp;&nbsp;</span>
            </section>
            <section class="c-attr-mt of">
              <span class="ml10 vam">
                <em class="icon18 scIcon"></em>
                <a class="vam"
                   :class="isStar ? 'c-fff' : 'c-orange'"
                   @click="updateCourse"
                   title="收藏" href="#" >收藏</a>
              </span>
            </section>
            <section class="c-attr-mt">
              <a href="#" :title="freeOrBuy(course.price)"
                 v-if="Number(course.price) === 0 || isBought"
                 @click="toPlayer"
                 class="comm-btn c-btn-3">立即观看</a>
              <a href="#" :title="freeOrBuy(course.price)"
                 v-else
                 @click="createOrder"
                 class="comm-btn c-btn-3">前往支付</a>
            </section>
          </section>
        </aside>
        <!-- 课程基本信息 -->

        <!-- 课程信息 售卖等 开始-->
        <aside class="thr-attr-box">
          <ol class="thr-attr-ol">
            <li>
              <p>&nbsp;</p>
              <aside>
                <span class="c-fff f-fM">购买数</span>
                <br>
                <h6 class="c-fff f-fM mt10">{{course.saleCount}}</h6>
              </aside>
            </li>
            <li>
              <p>&nbsp;</p>
              <aside>
                <span class="c-fff f-fM">课时数</span>
                <br>
                <h6 class="c-fff f-fM mt10">{{course.lessonNum}}</h6>
              </aside>
            </li>
            <li>
              <p>&nbsp;</p>
              <aside>
                <span class="c-fff f-fM">浏览数</span>
                <br>
                <h6 class="c-fff f-fM mt10">{{course.viewCount}}</h6>
              </aside>
            </li>
          </ol>
        </aside>
        <!-- 课程信息 售卖等 结束-->

        <div class="clear"></div>
      </div>

      <!-- 课程封面介绍 -->
      <div class="mt20 c-infor-box">
        <article class="fl col-7">

          <section class="mr30">
            <!-- todo -->
            <div class="i-box">

              <div>
                <section id="c-i-tabTitle" class="c-infor-tabTitle c-tab-title">
                  <a name="c-i" class="current" title="课程详情">课程详情</a>
                </section>
              </div>

              <!-- 中间部分 -->
              <article class="ml10 mr10 pt20">
                <div>
                  <h6 class="c-i-content c-infor-title">
                    <span>课程介绍</span>
                  </h6>
                  <div class="course-txt-body-wrap">
                    <section class="course-txt-body">
                      <p v-html="course.description">
                      </p>
                    </section>
                  </div>
                </div>
                <!-- /课程介绍 -->
                <!-- 视频部分 -->
                <div class="mt50">
                  <h6 class="c-g-content c-infor-title">
                    <span>课程大纲</span>
                  </h6>
                  <section class="mt20">
                    <div class="lh-menu-wrap">
                      <menu id="lh-menu" class="lh-menu mt10 mr10">
                        <ul>
                          <!-- 文件目录 -->
                          <li class="lh-menu-stair" v-for="chapter in chapters" :key="chapter.id">
                            <a href="javascript: void(0)" :title="chapter.title" class="current-1">
                              <em class="lh-menu-i-1 icon18 mr10"></em>{{chapter.title}}
                            </a>
                            <ol class="lh-menu-ol" style="display: block;">
                              <li class="lh-menu-second ml30"
                                  v-for="(video, index) in chapter.children" :key="video.id">
                                <a :href="'/course/player/' + video.videoSourceId"
                                   @click="index !== 0 ? toPlayerOrPay : ()=>{}"
                                   target="_blank">
                                  <span class="fr" v-if="index === 0">
                                    <i class="free-icon vam mr10">免费试听</i>
                                  </span>
                                  <em class="lh-menu-i-2 icon16 mr5">&nbsp;</em>{{video.title}}
                                </a>
                              </li>
                            </ol>
                          </li>
                        </ul>
                      </menu>
                    </div>
                  </section>
                </div>
                <!-- 视频部分 -->
                <!-- /课程大纲 -->
              </article>
              <!-- 中间部分 -->

            </div>
          </section>
        </article>

        <!-- 讲师信息开始 -->
        <aside class="fl col-3">
          <div class="i-box">
            <div>
              <section class="c-infor-tabTitle c-tab-title">
                <a title href="javascript:void(0)">主讲讲师</a>
              </section>
              <section class="stud-act-list">
                <ul style="height: auto;">
                  <li>
                    <div class="u-face">
                      <a href="#">
                        <img :src="teacher.avatar" width="50" height="50" alt>
                      </a>
                    </div>
                    <section class="hLh30 txtOf">
                      <a class="c-333 fsize16 fl" href="#">{{teacher.name}}</a>
                    </section>
                    <section class="hLh20 txtOf">
                      <span class="c-999">{{teacher.career}}</span>
                    </section>
                  </li>
                </ul>
              </section>
            </div>
          </div>
        </aside>
        <!-- 讲师信息结束 -->

        <div class="clear"></div>

        <!-- 评论开始 -->
        <article class="fl col-7">
          <section class="mr30">
            <div class="i-box">
              <div>
                <section class="c-infor-tabTitle c-tab-title" style="height: 36px">
                  <a name="c-i" class="current" title="评论"
                     style="margin-right: 0; margin-left: 10px; padding: 0">
                    评论
                  </a>
                  <span
                    style="font-size: 14px;margin: 0 36px 0 6px;font-weight: normal;color: #9499a0">
                    {{commentsData.total}}
                  </span>
                  <span>
                    <el-button type="text"
                               @click="sort0($event)"
                               :class="sort === 0 ? 'color-black' : 'color-grey'"
                               style="margin-left: 20px; font-weight: 400; font-size: 16px">最热</el-button>
                    <span style="margin: 0 12px;">|</span>
                    <el-button type="text"
                               @click="sort1($event)"
                               :class="sort === 1 ? 'color-black' : 'color-grey'"
                               style="margin: 0; font-weight: 400; font-size: 16px">最新</el-button>
                  </span>

                </section>
              </div>
              <article class="ml10 mr10 pt20 stud-act-list">
                <ul style="height: auto;">
                  <li>
                    <div class="u-face">
                      <a href="#">
                        <img :src="userInfo.avatar" width="50" height="50">
                      </a>
                    </div>
                    <section style="position: relative;flex: 1;">
                      <el-input style="width: 85%"
                                v-model="comment.content"
                                :placeholder="userInfo.id ? '勇敢滴少年啊快去创造热评~' : ''"></el-input>
                      <div v-if="!userInfo.id" class="disable-mask">
                        <div class="no-login-mask">
                          <span
                            style="font-weight: 400;
                             font-family: PingFang SC, HarmonyOS_Regular, Helvetica Neue, Microsoft YaHei, sans-serif;">请先</span>
                          <el-button type="primary"
                                     @click="toLogin"
                                     style="padding: 4px 9px;margin: 0 3px; font-size: 12px; color: #fff">
                            登录
                          </el-button>
                          <span>后发表评论 (・ω・)</span>
                        </div>
                      </div>
                      <el-button type="primary"
                                 @click="publish"
                                 :disabled="disabled"
                                 :loading="loading">发布</el-button>
                    </section>
                  </li>
                  <li
                    v-for="comment in commentsData.records"
                    :key="comment.id">
                    <div class="u-face">
                      <a href="#">
                        <img :src="comment.avatar" width="50" height="50">
                      </a>
                    </div>
                    <section class="hLh30 txtOf">
                      <a class="c-333 fsize16 fl"
                         style="font-size: 14px;text-decoration: none"
                         href="#">{{comment.nickname}}</a>
                    </section>
                    <section class="hLh20 txtOf">
                      <span class="c-999" style="font-size: 16px">{{comment.content}}</span>
                    </section>
                  </li>
                </ul>
              </article>
            </div>
            <!-- 公共分页 开始 -->
            <div>
              <div class="paging">
                <a href="#" title="首页" @click="pageComments(1, sort)">首</a>
                <a href="#" title="前一页" @click="pageComments(commentsData.current - 1, sort)"
                   :class="commentsData.current === 1 ? 'disable' : 'enable'">&lt;</a>
                <a v-for="index in commentsData.pages"
                   :key="index" href="#"
                   @click="pageComments(index, sort)"
                   :style="index === commentsData.current ? 'border-color: #68cb9b;color: #68cb9b;' : ''"
                   :title="`第${index}页`">{{index}}</a>
                <a href="#" title="后一页" @click="pageComments(commentsData.current + 1, sort)"
                   :class="commentsData.current === commentsData.pages ? 'disable' : 'enable'">&gt;</a>
                <a href="#" title="末页" @click="pageComments(commentsData.pages, sort)">末</a>
                <div class="clear"></div>
              </div>
            </div>
            <!-- 公共分页 结束 -->
          </section>
        </article>
        <!-- 评论结束 -->
      </div>
      <!--封面介绍结束 -->

    </section>
    <!-- 课程详情 结束 -->

  </div>
</template>

<script>
  import course from "../../api/course";
  import teacher from "../../api/teacher";
  import order from "../../api/order";
  import comment from "../../api/comment";
  import cookie from 'js-cookie'

  export default {
    data() {
      return {
        course: {}, // 当前课程
        teacher: {}, // 讲师
        chapters: [], //当前课程所有章节
        commentsData: {}, // 评论信息
        sort: 1, // 默认最新
        pageSize: 8,
        pageNum: 1,
        userInfo: {
          avatar: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
        }, //用户信息
        comment: {}, // 评论信息
        loading: false, // 按钮加载
        isStar: false, // 当前用户是否收藏当前课程
        isBought: false
      }
    },
    created() {
      // 获取当前用户信息
      const userStr = cookie.get('user_info');
      if (userStr) {
        this.userInfo = JSON.parse(userStr);
      }
      const id = this.$route.params.id;
      this.getCourseById(id);
      // 更新观看次数
      course.updateCourseViewCount(id);
    },
    computed: {
      // 判断用户是否登录或者评论是否有信息来禁用发布按钮
      disabled() {
        return !(this.userInfo.id && this.comment.content);
      }
    },
    watch: {
      // 监视sort属性来进行页面重新加载
      sort() {
        this.pageComments(1, this.sort);
      }
    },
    methods: {
      // 判断是否购买当前课程
      isBoughtOneCourse(memberId, courseId) {
        order.isBoughtOneCourse(memberId, courseId).then(res => {
          this.isBought = res.data.data;
        }).catch(err => {
          console.log(err);
        })
      },
      /**
       * 1. 通过courseId获取到课程信息 course
       * 2. 通过课程中的teacherId获取到讲师信息 teacher
       * 3. 通过courseId获取当前课程中的评论信息
       * 4. 通过courseId获取章节信息
       * @param id 课程id
       */
      getCourseById(id) {
        course.getCourseById(id).then(res => {
          this.course = res.data.data;
          if (this.userInfo.id) {
            // 当前用户存在，判断是否购买
            this.isBoughtOneCourse(this.userInfo.id, this.course.id);
          }
          //查询讲师
          teacher.getTeacherById(this.course.teacherId).then(res => {
            this.teacher = res.data.data;
          });
          // 获取评论信息
          this.pageComments(1, this.sort);
        });
        course.getChaptersById(id).then(res => {
          this.chapters = res.data.data;
        })
      },
      // 通过price进行按钮的信息切换
      freeOrBuy(price) {
        return Number(price) === 0 ? '立即观看' : '前往支付';
      },
      // 点击前往支付按钮，创建订单并跳转到订单页面
      createOrder() {
        // 判断当前账号是否登录
        if (!this.userInfo.id) {
          // 没有登录
          this.$message.error("您没有登陆, 请先登录~~");
          // 前往登录
          this.toLogin();
          return;
        }
        order.createOrder(this.course.id).then(res => {
          this.$router.push({path: "/order/" + res.data.data});
        });
      },
      // 分页查询当前课程的评论信息
      pageComments(index, sort) {
        comment.pageComments(this.pageSize, index, sort, this.course.id).then(res => {
          this.commentsData = res.data.data;
        });
      },
      // 发布评论
      publish() {
        // 属性初始化
        this.loading = true;
        this.comment.avatar = this.userInfo.avatar;
        this.comment.nickname = this.userInfo.nickname;
        this.comment.courseId = this.course.id;
        this.comment.memberId = this.userInfo.id;
        this.comment.start = 0;
        // 发布信息
        comment.insertComment(this.comment).then(res => {
          // 重新加载信息
          this.pageComments(1, this.sort);
          this.loading = false;
        });
      },
      // 前往登录
      toLogin() {
        this.$router.push({path: '/login'})
      },
      // 点击最热按钮
      sort0(event) {
        this.sort = 0;
        event.target.blur();
      },
      // 点击最新按钮
      sort1(event) {
        this.sort = 1;
        event.target.blur();
      },
      // 当前课程已购买或免费时，点击后跳往视频第一页
      toPlayer() {
        const videoSourceId = this.chapters[0].children[0].videoSourceId;
        this.$router.push({path: '/course/player/' + videoSourceId});
      },
      // 判断是否要收费来进行跳转路由
      toPlayerOrPay() {
        if (Number(this.course.price) !== 0) {
          // 当前课程需要收费
          if (!this.isBought) {
            // 当前课程没有购买
            this.createOrder();
            return;
          }
        }
        // 当前课程已经购买
        this.toPlayer();
      },
      // 收藏功能
      updateCourse() {
        this.isStar = true;
      }
    }
  };
</script>
<style>
  .enable {
    pointer-events: auto;
  }
  .disable {
    pointer-events: none;
    opacity: 0.5;
    background-color: #ebeef5;
  }
  .disable-mask {
    display: flex;
    top: 0;
    left: 0;
    justify-content: center;
    align-items: center;
    z-index: 1;
    width: 85%;
    border-radius: 6px;
    font-size: 12px;
    height: 100%;
    position: absolute;
  }
  .no-login-mask {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 100%;
    cursor: pointer;
  }

  .color-black {
    color: #18191c
  }
  .color-grey {
    color: #9499a0
  }
</style>

