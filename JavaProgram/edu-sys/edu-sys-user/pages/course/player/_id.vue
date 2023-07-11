<template>
  <div>
    <!-- 阿里云视频播放器样式 -->
    <link rel="stylesheet"
          href="https://g.alicdn.com/de/prismplayer/2.8.1/skins/default/aliplayer-min.css" >
    <!-- 阿里云视频播放器脚本 -->
    <script charset="utf-8" type="text/javascript"
            src="https://g.alicdn.com/de/prismplayer/2.8.1/aliplayer-min.js" />

    <!-- 定义播放器dom -->
    <div id="J_prismPlayer" class="prism-player" />
  </div>
</template>


<script>
  import course from "../../../api/course";
  export default {
    layout: 'video',
    data() {
      return {
        vid: '',
        playAuth: ''
      }
    },
    created() {
      const id = this.$route.params.id;
      course.getVideoIdById(id).then(res => {
        console.log(res.data);
        this.vid = id;
        this.playAuth = res.data.data;
        new Aliplayer({
          id: 'J_prismPlayer',
          vid: this.vid, // 视频id
          playauth: this.playAuth, // 播放凭证
          encryptType: '1', // 如果播放加密视频，则需设置encryptType=1，非加密视频无需设置此项
          width: '100%',
          height: '500px'
        }, function(player) {
          console.log('播放器创建成功')
        })
      })
    }

  }
</script>

<style scoped>

</style>
