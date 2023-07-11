<template>
  <div class="main">
    <div class="title">
      <a class="active" href="/login">登录</a>
      <span>·</span>
      <a href="/register">注册</a>
    </div>

    <div class="sign-up-container">
      <el-form ref="userForm" :model="user">

        <el-form-item class="input-prepend restyle" prop="mobile"
                      :rules="[{ required: true, message: '请输入手机号码', trigger: 'blur' }
                      ,{validator: checkPhone, trigger: 'blur'}]">
          <div>
            <el-input type="text" placeholder="手机号" v-model="user.mobile"/>
            <i class="iconfont icon-phone"/>
          </div>
        </el-form-item>

        <el-form-item class="input-prepend" prop="password"
                      :rules="[{ required: true, message: '请输入密码', trigger: 'blur' }]">
          <div>
            <el-input type="password" show-password placeholder="密码" v-model="user.password"/>
            <i class="iconfont icon-password"/>
          </div>
        </el-form-item>

        <div class="btn">
          <input type="button" class="sign-in-button" value="登录" @click="submitLogin('userForm')">
        </div>
      </el-form>
      <!-- 更多登录方式 -->
      <div class="more-sign">
        <h6>社交帐号登录</h6>
        <ul>
          <li>
            <a id="weixin" class="weixin" target="_blank"
                 href="http://qy.free.idcfengye.com/api/ucenter/weixinLogin/login">
              <i class="iconfont icon-weixin"/>
            </a>
          </li>
          <li><a id="qq" class="qq" target="_blank" href="#"><i class="iconfont icon-qq"/></a></li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script>
  import '~/assets/css/sign.css'
  import '~/assets/css/iconfont.css'
  import user from "../../api/user";
  import cookie from 'js-cookie'

  export default {
    layout: 'sign',
    data() {
      return {
        user: { //封装登录的手机号和密码
          mobile: '',
          password: ''
        },
        loginInfo: {}, //用户信息
        token: ''
      }
    },
    created() {

    },
    methods: {
      submitLogin(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 校验成功，发起登录
            user.login(this.user).then(response => {
              const res = response.data;
              if (res.flag && res.code === 20000) {
                // 登录成功
                this.token = res.data;
                this.$message.success("登录成功");
                cookie.set("user_token", this.token, {domain: 'localhost'});
                // 获取userInfo
                user.getUserInfo(this.token).then(response => {
                  if (response.data.flag && response.data.code === 20000) {
                    this.userInfo = response.data.data;
                    cookie.set("user_info", this.userInfo, {domain: 'localhost'});
                    // 前往首页
                    // this.$router.push({path: '/'});
                    window.location.href = '/';
                  } else {
                    this.$message.error("错误");
                  }
                });

              } else {
                this.$message.error("手机号,密码错误,请重新登陆");
              }
            })
          } else {
            this.$message.error('手机号不符合规范');
            return false;
          }
        });
      },
      checkPhone(rule, value, callback) {
        //debugger
        if (!(/^1[34578]\d{9}$/.test(value))) {
          return callback(new Error('手机号码格式不正确'))
        }
        return callback()
      }
    }
  }
</script>
<style>
  .el-form-item__error {
    z-index: 9999999;
  }
</style>
