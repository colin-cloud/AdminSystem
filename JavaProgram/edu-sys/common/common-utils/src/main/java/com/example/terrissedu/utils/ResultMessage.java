package com.example.terrissedu.utils;

public interface ResultMessage {

    // 教师模块
    String LIST_TEACHERS_SUCCESS = "返回教师列表成功";
    String LIST_TEACHERS_ERROR= "返回教师列表失败";
    String PAGE_TEACHERS_SUCCESS = "返回教师分页列表成功";
    String PAGE_TEACHERS_ERROR= "返回教师分页列表失败";
    String INSERT_TEACHERS_SUCCESS = "添加教师成功";
    String INSERT_TEACHERS_ERROR= "添加教师失败";
    String UPDATE_TEACHER_ERROR= "更新教师失败";
    String UPDATE_TEACHER_SUCCESS = "更新教师成功";
    String DELETE_TEACHER_SUCCESS = "删除指定教师成功";
    String DELETE_TEACHER_ERROR = "删除指定教师失败";
    String DELETE_TEACHERS_BATCH_SUCCESS = "批量删除教师成功";
    String DELETE_TEACHERS_BATCH_ERROR = "批量删除教师失败";

    // 课程模块
    String LIST_COURSES_SUCCESS = "返回课程列表成功";
    String LIST_COURSES_ERROR= "返回课程列表失败";
    String PAGE_COURSES_SUCCESS = "返回课程分页列表成功";
    String PAGE_COURSES_ERROR= "返回课程分页列表失败";
    String INSERT_COURSES_SUCCESS = "添加课程成功";
    String INSERT_COURSES_ERROR= "添加课程失败";
    String UPDATE_COURSE_ERROR= "更新课程信息失败";
    String UPDATE_COURSE_SUCCESS = "更新课程信息成功";
    String DELETE_COURSE_SUCCESS = "删除指定课程成功";
    String DELETE_COURSE_ERROR = "删除指定课程失败";
    String DELETE_COURSES_BATCH_SUCCESS = "批量删除课程成功";
    String DELETE_COURSES_BATCH_ERROR = "批量删除课程失败";

    // 章节模块
    String LIST_CHAPTERS_SUCCESS = "返回章节列表成功";
    String LIST_CHAPTERS_ERROR= "返回章节列表失败";
    String PAGE_CHAPTERS_SUCCESS = "返回章节分页列表成功";
    String PAGE_CHAPTERS_ERROR= "返回章节分页列表失败";
    String INSERT_CHAPTER_SUCCESS = "添加章节成功";
    String INSERT_CHAPTER_ERROR= "添加章节失败";
    String UPDATE_CHAPTER_ERROR= "更新章节信息失败";
    String UPDATE_CHAPTER_SUCCESS = "更新章节信息成功";
    String DELETE_CHAPTER_SUCCESS = "删除指定章节成功";
    String DELETE_CHAPTER_ERROR = "删除指定章节失败";
    String DELETE_CHAPTERS_BATCH_SUCCESS = "批量删除章节成功";
    String DELETE_CHAPTERS_BATCH_ERROR = "批量删除章节失败";

    // 小节模块
    String LIST_VIDEOS_SUCCESS = "返回小节列表成功";
    String LIST_VIDEOS_ERROR= "返回小节列表失败";
    String PAGE_VIDEOS_SUCCESS = "返回小节分页列表成功";
    String PAGE_VIDEOS_ERROR= "返回小节分页列表失败";
    String INSERT_VIDEO_SUCCESS = "添加小节成功";
    String INSERT_VIDEO_ERROR= "添加小节失败";
    String UPDATE_VIDEO_ERROR= "更新小节信息失败";
    String UPDATE_VIDEO_SUCCESS = "更新小节信息成功";
    String DELETE_VIDEO_SUCCESS = "删除指定小节成功";
    String DELETE_VIDEO_ERROR = "删除指定小节失败";
    String DELETE_VIDEOS_BATCH_SUCCESS = "批量删除小节成功";
    String DELETE_VIDEOS_BATCH_ERROR = "批量删除小节失败";

    // Banner模块
    String LIST_BANNERS_SUCCESS = "返回banner列表成功";
    String LIST_BANNERS_ERROR= "返回banner列表失败";
    String PAGE_BANNERS_SUCCESS = "返回banner分页列表成功";
    String PAGE_BANNERS_ERROR= "返回banner分页列表失败";
    String INSERT_BANNERS_SUCCESS = "添加banner成功";
    String INSERT_BANNERS_ERROR= "添加banner失败";
    String UPDATE_BANNER_ERROR= "更新banner失败";
    String UPDATE_BANNER_SUCCESS = "更新banner成功";
    String DELETE_BANNER_SUCCESS = "删除指定banner成功";
    String DELETE_BANNER_ERROR = "删除指定banner失败";
    String DELETE_BANNERS_BATCH_SUCCESS = "批量删除banner成功";
    String DELETE_BANNERS_BATCH_ERROR = "批量删除banner失败";


    // 用户模块
    String USER_LOGIN_SUCCESS = "用户登录成功";
    String USER_LOGIN_ERROR= "用户名密码错误";
    String USER_EXIT_ERROR = "用户名已存在,不可再注册";
    String CODE_VERIFY_ERROR = "验证码错误,请重新验证!!!";
    String USER_REGISTER_SUCCESS = "用户注册成功";
    String USER_REGISTER_ERROR= "用户注册错误";
    String TOKEN_EXPIRE = "token失效,请重新登录";
    String GET_USER_SUCCESS = "根据token获取用户信息成功";

    // 上传文件模块
    String UPLOAD_AVATAR_SUCCESS = "上传头像成功";
    String UPLOAD_AVATAR_ERROR = "上传头像失败";

    // 控制excel表格写入数据库
    String EXCEL_WRITE_SUCCESS = "写入成功";
    String EXCEL_WRITE_ERROR = "写入失败";

    // 课程模块
    String SUBJECT_QUERY_SUCCESS = "课程查询成功";
    String SUBJECT_QUERY_ERROR = "课程查询失败";

    // 上传文件模块
    String UPLOAD_VOD_SUCCESS = "上传视频成功";
    String UPLOAD_VOD_ERROR = "上传视频失败";
    String PLAY_AUTH_VOD_GET_SUCCESS = "获取凭证成功";
    String PLAY_AUTH_VOD_GET_ERROR = "获取凭证失败";

    // 短信模块
    String SEND_MESSAGE_SUCCESS = "发送信息成功";
    String SEND_MESSAGE_ERROR = "发送信息失败";

    // 订单模块
    String SELECT_ORDER_SUCCESS = "获取订单成功";
    String SELECT_ORDER_ERROR = "获取订单失败";

    // 评论模块
    String PAGE_COMMENT_SUCCESS = "评论分页成功";
    String PAGE_COMMENT_ERROR = "评论分页失败";
    String INSERT_COMMENT_SUCCESS = "添加评论成功";
    String INSERT_COMMENT_ERROR= "添加评论失败";
    String DELETE_COMMENT_SUCCESS = "删除指定评论成功";
    String DELETE_COMMENT_ERROR = "删除指定评论失败";

    // 支付模块
    String CREATE_CODE_SUCCESS = "生成二维码成功";
    String CREATE_CODE_ERROR = "生成二维码失败";
    String QUERY_STATUS_SUCCESS = "查询订单状态成功";
    String QUERY_STATUS_ERROR = "查询订单状态失败";
    String LOG_EXIST = "订单日志存在";
    String LOG_NOT_EXIST = "订单日志不存在";
}
