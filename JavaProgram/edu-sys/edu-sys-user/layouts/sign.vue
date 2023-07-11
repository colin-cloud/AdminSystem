<template>
    <div class="sign">
      <!-- 标题 -->
      <div class="logo">
        <img src="~/assets/img/logo.jpg" alt="logo">
      </div>
      <!--表单-->
      <nuxt/>
    </div>
</template>

<script>
  export default {}
</script>

<style scoped>
  .sign {
    background-image: url(assets/img/gril.jpg);
    background-repeat: no-repeat;
    background-position: center;
    background-color: rgba(255,255,255,0.8);
    width: 100%;
    height: 915px;
    background-size:cover;
    position:absolute;
    left: 0;
    right: 0;
    opacity: 0.8;
  }
  .logo img {
    opacity: 0.6;
  }
</style>
