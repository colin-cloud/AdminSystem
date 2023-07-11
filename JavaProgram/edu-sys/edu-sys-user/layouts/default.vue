<template>
  <div class="in-wrap">
    <!-- 公共头引入 -->
    <header id="header">
      <section class="container">
        <h1 id="logo">
          <a href="/" title="在线教育">
            <img src="~/assets/img/logo.jpg" width="100%" alt="在线教育">
          </a>
        </h1>
        <div class="h-r-nsl">
          <ul class="nav">
            <router-link to="/" tag="li" active-class="current" exact>
              <a>首页</a>
            </router-link>
            <router-link to="/course" tag="li" active-class="current">
              <a>课程</a>
            </router-link>
            <router-link to="/teacher" tag="li" active-class="current">
              <a>名师</a>
            </router-link>
            <router-link to="/article" tag="li" active-class="current">
              <a>文章</a>
            </router-link>
            <router-link to="/qa" tag="li" active-class="current">
              <a>问答</a>
            </router-link>
          </ul>
          <!-- / nav -->
          <ul class="h-r-login">
            <li v-if="!userInfo.id" id="no-login">
              <a href="/login" title="登录">
                <em class="icon18 login-icon">&nbsp;</em>
                <span class="vam ml5">登录</span>
              </a>
              |
              <a href="/register" title="注册">
                <span class="vam ml5">注册</span>
              </a>
            </li>
            <li v-if="userInfo.id" class="mr10" id="is-login-one">
              <a href="#" title="消息" id="headerMsgCountId">
                <em class="icon18 news-icon">&nbsp;</em>
              </a>
              <q class="red-point" style="display: none">&nbsp;</q>
            </li>
            <li v-if="userInfo.id" class="h-r-user" id="is-login-two">
              <a href="#" title>
                <img
                  :src="userInfo.avatar"
                  width="30"
                  height="30"
                  class="vam picImg"
                  alt
                >
                <span class="vam disIb" id="userName">{{userInfo.nickname}}</span>
              </a>
              <a href="javascript:void(0)" title="退出" @click="exit" class="ml5">退出</a>
            </li>
            <!-- /未登录显示第1 li；登录后显示第2，3 li -->
          </ul>
          <aside class="h-r-search">
            <form action="#" method="post">
              <label class="h-r-s-box">
                <input type="text" placeholder="输入你想学的课程" :name="queryCourse.title" value>
                <button type="submit" class="s-btn" @click="pageCourse">
                  <em class="icon18">&nbsp;</em>
                </button>
              </label>
            </form>
          </aside>
        </div>
        <aside class="mw-nav-btn">
          <div class="mw-nav-icon"></div>
        </aside>
        <div class="clear"></div>
      </section>
    </header>
    <!-- /公共头引入 -->

    <nuxt/>

    <!-- 公共底引入 -->
    <footer id="footer">
      <section class="container">
        <div class>
          <h4 class="hLh30">
            <span class="fsize18 f-fM c-999">友情链接</span>
          </h4>
          <ul class="of flink-list">
            <li>
              <a href="https://github.com/colin-cloud/AdminSystem"
                 title="Github" target="_blank">Github</a>
            </li>
          </ul>
          <div class="clear"></div>
        </div>
        <div class="b-foot">
          <section class="fl col-7">
            <section class="mr20">
              <section class="b-f-link">
                <a href="#" title="关于我们" target="_blank">关于我们</a>|
                <a href="#" title="联系我们" target="_blank">联系我们</a>|
                <a href="#" title="帮助中心" target="_blank">帮助中心</a>|
                <a href="#" title="资源下载" target="_blank">资源下载</a>|
                <span>服务热线：124-56225675(武汉) 0078-95294525(鄂州)</span>
                <span>Email：2422706963@qq.com</span>
              </section>
              <section class="b-f-link mt10">
                <span>©2023课程版权均归Terriss所有 汉ICP备19055252号</span>
              </section>
            </section>
          </section>
          <aside class="fl col-3 tac mt15">
            <section class="gf-tx">
              <span>
                <img src="~/assets/img/wx-icon.png" alt>
              </span>
            </section>
            <section class="gf-tx">
              <span>
                <img src="~/assets/img/wb-icon.png" alt>
              </span>
            </section>
          </aside>
          <div class="clear"></div>
        </div>
      </section>
    </footer>
    <!-- /公共底引入 -->
  </div>
</template>
<script>
  import "~/assets/css/reset.css";
  import "~/assets/css/theme.css";
  import "~/assets/css/global.css";
  import "~/assets/css/web.css";
  import cookie from 'js-cookie';
  import course from "../api/course";
  import user from "../api/user";
  import '~/assets/css/base.css'
  import '~/assets/css/activity_tab.css'
  import '~/assets/css/bottom_rec.css'
  import '~/assets/css/nice_select.css'
  import '~/assets/css/order.css'
  import '~/assets/css/swiper-3.3.1.min.css'
  import "~/assets/css/pages-weixinpay.css"


  export default {
    data() {
      return {
        userInfo: {}, // 用户信息
        queryCourse: {
          title: ''
        } // 查询信息
      }
    },
    created() {
      // 从路径中获取token -- ?token=
      if (this.$route.query && this.$route.query.token) {
        const token = this.$route.query.token;
        // 要先设置token
        cookie.set("user_token", token, {domain: 'localhost'});
        // 根据token将用户信息得到
        user.getUserInfo(token).then(res => {
          console.log(res);
          if (res.data.flag && res.data.code === 20000) {
            this.userInfo = res.data.data;
            // 将信息存入cookie中
            cookie.set("user_info", this.userInfo, {domain: 'localhost'});
            // 前往首页
            // this.$router.push({path: '/'});
            window.location.href = '/';
          } else {
            this.$message.error("错误");
          }
        })
      } else {
        // 判断cookie中是否有user信息
        if (cookie.get('user_info')) {
          // 存在信息
          this.userInfo = JSON.parse(cookie.get('user_info'));
        }
      }
    },
    methods: {
      exit() {
        // 将cookie中的token和userInfo清空
        cookie.remove('user_info');
        cookie.remove('user_token');
        window.location.href = '/';
      },
      // 查询课程
      pageCourse() {

      }
    }
  };
</script>
