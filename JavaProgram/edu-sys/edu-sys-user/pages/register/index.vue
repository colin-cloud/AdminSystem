<template>
  <div class="main">
    <div class="title">
      <a href="/login">登录</a>
      <span>·</span>
      <a class="active" href="/register">注册</a>
    </div>

    <div class="sign-up-container">
      <el-form ref="userForm" :model="member">

        <el-form-item class="input-prepend restyle"
                      prop="nickname"
                      :rules="[{ required: true, message: '请输入你的昵称', trigger: 'blur' }]">
          <div>
            <el-input type="text" placeholder="你的昵称" v-model="member.nickname"/>
            <i class="iconfont icon-user"/>
          </div>
        </el-form-item>

        <el-form-item class="input-prepend restyle no-radius"
                      prop="mobile"
                      :rules="[{ required: true, message: '请输入手机号码', trigger: 'blur' }
                      ,{validator: checkPhone, trigger: 'blur'}]">
          <div>
            <el-input type="text" placeholder="手机号" v-model="member.mobile"/>
            <i class="iconfont icon-phone"/>
          </div>
        </el-form-item>

        <el-form-item class="input-prepend restyle no-radius"
                      prop="code"
                      :rules="[{ required: true, message: '请输入验证码', trigger: 'blur' }]">
          <div style="width: 100%;display: block;float: left;position: relative">
            <el-input type="text"
                      placeholder="验证码"
                      v-model="member.code"/>
            <i class="iconfont icon-phone"/>
          </div>
          <div class="btn" style="position:absolute;right: 0;top: 6px;width: 40%;">
            <a href="javascript:"
               type="button"
               ref="codeButton"
               @click="getCodeFun"
               :value="codeTest"
               :disabled="!sending"
               style="border: none;">{{codeTest}}</a>
          </div>
        </el-form-item>

        <el-form-item class="input-prepend"
                      prop="password"
                      :rules="[{ required: true, message: '请输入密码', trigger: 'blur' }]">
          <div>
            <el-input type="password" show-password
                      placeholder="设置密码" v-model="member.password"/>
            <i class="iconfont icon-password"/>
          </div>
        </el-form-item>

        <div class="btn">
          <input type="button" class="sign-up-button" value="注册" @click="submitRegister('userForm')">
        </div>
        <p class="sign-up-msg">
          点击 “注册” 即表示您同意并愿意遵守简书
          <br>
          <a target="_blank" href="http://www.jianshu.com/p/c44d171298ce">用户协议</a>
          和
          <a target="_blank" href="http://www.jianshu.com/p/2ov8x3">隐私政策</a> 。
        </p>
      </el-form>
      <!-- 更多注册方式 -->
      <div class="more-sign">
        <h6>社交帐号直接注册</h6>
        <ul>
          <li><a id="weixin" class="weixin"
                 target="_blank" href="http://huaan.free.idcfengye.com/api/ucenter/wx/login"><i
            class="iconfont icon-weixin"/></a></li>
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

  export default {
    layout: 'sign',
    data() {
      return {
        member: {
          mobile: '',
          code: '',
          nickname: '',
          password: ''
        },
        sending: true,      //是否发送验证码
        second: 60,        //倒计时间
        codeTest: '获取验证码'
      }
    },
    methods: {
      timeDown() {
        let res = setInterval(() => {
          this.second--;
          this.codeTest = this.second;
          if (this.second < 1) {
            clearInterval(res);
            this.second = 60;
            this.$refs['codeButton'].pointerEvents = 'auto';
            this.sending = true;
            this.codeTest = '获取验证码';
          }
        }, 1000); // 每一秒执行一次
      },
      getCodeFun() {
        if (!this.sending) {
          return false;
        }
        if (!this.checkPhone('' , this.member.mobile, (val) => {
          return typeof (val) === 'undefined';
        })) {
          return false;
        }
        user.getCodeFun(this.member.mobile).then(res => {
          // 已发送，等待时间再发送
          this.$refs['codeButton'].pointerEvents = 'none';
          this.sending = false;
          this.timeDown();
        });
        return false;
      },
      submitRegister(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            user.register(this.member).then(res => {
              if (res.data.flag) {
                // 成功
                this.$message.success(res.data.message);
                this.$router.push({path: '/login'})
              } else {
                this.$message.error(res.data.message);
              }
            }).catch(err => {
              this.$message.error(err);
            });
          } else {
            this.$message.error("请填写信息");
          }
        });

      },
      checkPhone (rule, value, callback) {
        //debugger
        if (!(/^1[34578]\d{9}$/.test(value))) {
          return callback(new Error('手机号码格式不正确'))
        }
        return callback()
      }
    }
  }
</script>
