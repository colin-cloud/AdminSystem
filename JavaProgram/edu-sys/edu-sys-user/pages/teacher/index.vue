<template>
  <div id="aCoursesList" class="bg-fa of">
    <!-- 讲师列表 开始 -->
    <section class="container">
      <header class="comm-title all-teacher-title">
        <h2 class="fl tac">
          <span class="c-333">全部讲师</span>
        </h2>
        <section class="c-tab-title">
          <a id="subjectAll" title="全部" href="#">全部</a>
          <!-- <c:forEach var="subject" items="${subjectList }">
                            <a id="${subject.subjectId}" title="${subject.subjectName }" href="javascript:void(0)" οnclick="submitForm(${subject.subjectId})">${subject.subjectName }</a>
          </c:forEach>-->
        </section>
      </header>
      <section class="c-sort-box unBr">
        <div>
          <!-- /无数据提示 开始-->
          <section class="no-data-wrap" v-if="pageData.pages === 0">
            <em class="icon30 no-data-ico">&nbsp;</em>
            <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
          </section>
          <!-- /无数据提示 结束-->
          <article class="i-teacher-list">
            <ul class="of">
              <li v-for="teacher in pageData.records" :key="teacher.id">
                <section class="i-teach-wrap" style="height: 328px">
                  <div class="i-teach-pic">
                    <a :href="`/teacher/${teacher.id}`" :title="teacher.name" target="_blank">
                      <img :src="teacher.avatar" alt style="margin: 0 auto">
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a :href="`/teacher/${teacher.id}`" :title="teacher.name"
                       target="_blank" class="fsize18 c-666">{{teacher.name}}</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">{{teacher.intro}}</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">{{teacher.career}}</p>
                  </div>
                </section>
              </li>
            </ul>
            <div class="clear"></div>
          </article>
        </div>
        <!-- 公共分页 开始 -->
        <div>
          <div class="paging">
            <!-- undisable这个class是否存在，取决于数据属性hasPrevious -->
            <a href="#" title="首页" @click="pageTeachers(1)">首</a>
            <a href="#" title="前一页" @click="pageTeachers(pageData.current - 1)"
               :class="pageData.current === 1 ? 'disable' : 'enable'">&lt;</a>
            <a v-for="index in pageData.pages"
               :key="index" href="#"
               @click="pageTeachers(index)"
               :style="index === pageData.current ? 'border-color: #68cb9b;color: #68cb9b;' : ''"
               :title="`第${index}页`">{{index}}</a>
            <a href="#" title="后一页" @click="pageTeachers(pageData.current + 1)"
               :class="pageData.current === pageData.pages ? 'disable' : 'enable'">&gt;</a>
            <a href="#" title="末页" @click="pageTeachers(pageData.pages)">末</a>
            <div class="clear"></div>
          </div>
        </div>
        <!-- 公共分页 结束 -->
      </section>
    </section>
    <!-- /讲师列表 结束 -->
  </div>
</template>
<script>

  import teacher from "../../api/teacher";

  export default {
    data() {
      return {
        pageSize: 8,
        pageData: {}
      }
    },
    created() {
      this.pageTeachers(1);
    },
    methods: {
      pageTeachers(cur) {
        teacher.pageTeachers(this.pageSize, cur).then(res => {
          this.pageData = res.data.data;
        })
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
</style>
