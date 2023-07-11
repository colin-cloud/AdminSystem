<template>
  <div class="cart py-container">
    <!--主内容-->
    <div class="checkout py-container  pay">
      <div class="checkout-tit">
        <h4 class="fl tit-txt"><span class="success-icon"></span>
          <span class="success-info">订单提交成功，请您及时付款！订单号：{{pay.out_trade_no}}</span>
        </h4>
        <span class="fr"><em class="sui-lead">应付金额：</em>
          <em class="orange money">￥{{pay.total_fee / 100}}</em></span>
        <div class="clearfix"></div>
      </div>
      <div class="checkout-steps">
        <div class="fl weixin">微信支付</div>
        <div class="fl sao">
          <p class="red">请使用微信扫一扫。</p>
          <div class="fl code">
            <qriously
              style="margin-left: 200px; margin-top: 50px;"
              v-if="pay.code_url" :value="pay.code_url" :size="400"/>
          </div>

        </div>
        <div class="clearfix"></div>

      </div>
    </div>
  </div>
</template>


<script>
  import order from "../../../api/order";
  import course from "../../../api/course";

  export default {
    data() {
      return {
        pay: {},
        timer: ''
      }
    },
    created() {
      const no = this.$route.params.id;
      order.createWXCode(no).then(res => {
        this.pay = res.data.data;
        console.log(this.pay);
      })
    },
    mounted() {
      this.timer = setInterval(this.getOrderStatus(), 3000);
    },
    methods: {
      getOrderStatus() {
        order.getOrderStatus(this.pay.out_trade_no).then(res => {
          if (res.data.flag) {
            const courseId = this.pay.course_id;
            // 购买成功
            clearInterval(this.timer);
            // 更新销量
            course.updateCourseSaleCount(courseId);
            // 跳转页面
            this.$router.push({path: '/course/' + courseId})
          }
        })
      }
    },
    beforeDestroy() {
      if (this.timer) {
        clearInterval(this.timer);
      }
    }
  }
</script>

<style scoped>

</style>
