<template>
    <div class="home">
        <el-container style="height: 100%">
            <el-aside :width="sizeWidth + 'px'"
                      style="background-color: rgb(238, 241, 246);
                 height: 100%; box-shadow: 2px 0 6px rgba(0 ,21 ,41, 0.35)">
                <el-menu :default-openeds="['1', '3']"
                         style="min-height: 100%; overflow-x: hidden"
                         background-color="rgb(48, 65, 86)"
                         text-color="#fff"
                         active-text-color="#ffd04b"
                         :collapse-transition="false"
                         :collapse="isCollapse"
                >
                    <div style="height: 60px; line-height: 60px; text-align: center">
                        <img src="../assets/logo.png" alt="Vue的logo"
                             style="width: 20px; position:relative; top: 4px">
                        <b style="color: white; margin-left: 5px" v-show="logoTextShow">后台管理系统</b>
                    </div>
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-message"></i>
                            <span slot="title">导航一</span>
                        </template>
                        <el-menu-item-group>
                            <template slot="title">分组一</template>
                            <el-menu-item index="1-1">选项1</el-menu-item>
                            <el-menu-item index="1-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="1-3">选项3</el-menu-item>
                        </el-menu-item-group>
                        <el-submenu index="1-4">
                            <template slot="title">选项4</template>
                            <el-menu-item index="1-4-1">选项4-1</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span slot="title">导航二</span>
                        </template>
                        <el-menu-item-group>
                            <template slot="title">分组一</template>
                            <el-menu-item index="2-1">选项1</el-menu-item>
                            <el-menu-item index="2-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="2-3">选项3</el-menu-item>
                        </el-menu-item-group>
                        <el-submenu index="2-4">
                            <template slot="title">选项4</template>
                            <el-menu-item index="2-4-1">选项4-1</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title">
                            <i class="el-icon-setting"></i>
                            <span slot="title">导航三</span>
                        </template>
                        <el-menu-item-group>
                            <template slot="title">分组一</template>
                            <el-menu-item index="3-1">选项1</el-menu-item>
                            <el-menu-item index="3-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="3-3">选项3</el-menu-item>
                        </el-menu-item-group>
                        <el-submenu index="3-4">
                            <template slot="title">选项4</template>
                            <el-menu-item index="3-4-1">选项4-1</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-container>
                <el-header>
                    <div style="flex: 1; font-size: 20px; text-align: left">
                        <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
                    </div>
                    <el-dropdown style="width: 200px; cursor: pointer">
                        <span>王小虎</span>
                        <i class="el-icon-arrow-down" style="margin-right: 15px; margin-left: 10px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>个人信息</el-dropdown-item>
                            <el-dropdown-item>退出</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </el-header>

                <el-main>

                    <div style="margin: 10px 0 30px 0">
                        <el-breadcrumb separator-class="el-icon-arrow-right">
                            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                            <el-breadcrumb-item>活动管理</el-breadcrumb-item>
                            <el-breadcrumb-item>活动列表</el-breadcrumb-item>
                            <el-breadcrumb-item>活动详情</el-breadcrumb-item>
                        </el-breadcrumb>
                    </div>

                    <div style="padding: 10px 0;">
                        <el-input style="width: 200px" suffix-icon="el-icon-search"
                                  placeholder="请输入名称" v-model="username"></el-input>
                        <el-input style="width: 200px" suffix-icon="el-icon-position"
                                  placeholder="请输入地址" v-model="address"></el-input>
                        <el-button class="ml-5" @click="load">搜索</el-button>
                        <el-button class="ml-5" @click="reset">重置</el-button>
                    </div>

                    <div style="margin: 10px 0;">
                        <el-button type="primary" @click="handleInsert">
                            新增 <i class="el-icon-circle-plus-outline"></i>
                        </el-button>
                        <el-popconfirm
                                class="ml-5"
                                confirm-button-text='确定'
                                cancel-button-text='我再想想'
                                icon="el-icon-info"
                                icon-color="red"
                                title="确定删除吗？"
                                @confirm="handleDeleteBatch"
                        >
                            <el-button type="danger"
                                       slot="reference">
                                批量删除 <i class="el-icon-remove-outline"></i>
                            </el-button>
                        </el-popconfirm>
                        <el-button class="ml-5">
                            导入 <i class="el-icon-bottom"></i>
                        </el-button>
                        <el-button>
                            导出 <i class="el-icon-top"></i>
                        </el-button>
                    </div>

                    <el-table :data="tableData" border stripe
                              @selection-change="handleSelectionChange">>
                        <el-table-column
                                type="selection"
                                width="55">
                        </el-table-column>
                        <el-table-column prop="id" label="ID" width="100">
                        </el-table-column>
                        <el-table-column prop="username" label="用户名" width="120">
                        </el-table-column>
                        <el-table-column prop="sex" label="性别" width="100">
                        </el-table-column>
                        <el-table-column prop="createTime" label="创建日期" width="300">
                        </el-table-column>
                        <el-table-column prop="address" label="地址" width="600   ">
                        </el-table-column>
                        <el-table-column label="操作">
                            <template slot-scope="scope">
                                <el-button type="warning"
                                           @click="handleEdit(scope.row)">
                                    编辑 <i class="el-icon-edit"></i></el-button>
                                <el-popconfirm
                                        class="ml-5"
                                        confirm-button-text='确定'
                                        cancel-button-text='我再想想'
                                        icon="el-icon-info"
                                        icon-color="red"
                                        title="确定删除吗？"
                                        @confirm="handleDelete(scope.row.id)"
                                >

                                    <el-button type="danger"
                                               slot="reference">
                                        删除 <i class="el-icon-remove-outline"></i></el-button>
                                </el-popconfirm>
                            </template>
                        </el-table-column>
                    </el-table>

                    <div style="padding: 10px 0">
                        <el-pagination
                                @size-change="handleSizeChange"
                                @current-change="handleCurrentChange"
                                :current-page="pageNum"
                                :page-sizes="[5, 10, 15, 20]"
                                :page-size="pageSize"
                                layout="total, sizes, prev, pager, next, jumper"
                                :total="total">
                        </el-pagination>
                    </div>


                    <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%">
                        <el-form :model="form" label-width="100px" size="30">
                            <el-form-item label="用户名" :label-width="formLabelWidth">
                                <el-input v-model="form.username" autocomplete="off"
                                ></el-input>
                            </el-form-item>
                            <el-form-item label="性别" :label-width="formLabelWidth">
                                <el-input v-model="form.sex" autocomplete="off"
                                ></el-input>
                            </el-form-item>
                            <el-form-item label="地址" :label-width="formLabelWidth">
                                <el-input v-model="form.address" autocomplete="off"
                                ></el-input>
                            </el-form-item>
                        </el-form>

                        <div slot="footer" class="dialog-footer">
                            <el-button @click="dialogFormVisible = false">取 消</el-button>
                            <el-button type="primary" @click="insertOrUpdate">确 定</el-button>
                        </div>
                    </el-dialog>

                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>

    export default {
        name: 'HomeView',
        data() {
            return {
                //数据
                tableData: [],
                //状态的图标状态
                collapseBtnClass: 'el-icon-s-fold',
                //当前是否处于伸展状态
                isCollapse: false,
                //logo出的宽度大小
                sizeWidth: 200,
                //显示logo旁边的文字
                logoTextShow: true,
                //查询的总条数
                total: 0,
                //查询的当前页码
                pageNum: 1,
                //每页的条数
                pageSize: 10,
                //模糊查询
                username: '',
                address: '',
                //表单数据
                form: {},
                //表单可视
                dialogFormVisible: false,
                //输入框宽度
                formLabelWidth: '120px',
                //选择框数组
                multipleSelection: []
            }
        },
        //创建前加载一次数据
        created() {
            /*  请求分页查询数据
                fetch("http://localhost:9090/user/page?pageNum=" + this.pageNum + "&pageSize=" + this.pageSize)
                    .then(res => res.json().then(res => {
                    this.tableData = res.data;
                    this.total = res.total;
                }));
             */
            this.load();
        },
        methods: {
            /**
             * 1. 点击收缩按钮触发
             * 2. 将侧边栏进行收缩
             */
            collapse() {
                //将属性进行取反
                this.isCollapse = !this.isCollapse;
                if (this.isCollapse) {
                    //导航条为收缩状态
                    this.sizeWidth = 64;
                    this.collapseBtnClass = 'el-icon-s-unfold';
                    this.logoTextShow = false;
                } else {
                    //当航条为伸展状态
                    this.sizeWidth = 200;
                    this.collapseBtnClass = 'el-icon-s-fold';
                    this.logoTextShow = true;
                }
            },
            /**
             * 请求分页查询数据
             */
            load() {
                // fetchApi请求后端数据
                /*
                fetch("http://localhost:9090/user/page?pageNum=" + this.pageNum + "&pageSize=" + this.pageSize +
                "&username=" + this.username + "&address=" + this.address)
                    .then(res => res.json().then(res => {
                        // this.tableData = res.data;
                        //mybatis - plus
                        this.tableData = res.records;
                        this.total = res.total;
                    }));
                 */
                // axios请求数据
                this.request.get("/user/page", {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize,
                        username: this.username,
                        address: this.address
                    }
                }).then((res) => {

                    this.tableData = res.records;
                    this.total = res.total;
                })
            },
            /**
             * 改变当前数据量显示
             * @param pageSize 当前的一页显示的数据量
             */
            handleSizeChange(pageSize) {
                //修改数据
                this.pageSize = pageSize;
                //重新加载
                this.load();
            },
            /**
             * 改变当前页码的显示数据
             * @param pageNum 当前显示的页码
             */
            handleCurrentChange(pageNum) {
                //修改页码
                this.pageNum = pageNum;
                //重新加载数据
                this.load();
            },
            /**
             * 进行模糊查询时重置输入内容
             */
            reset() {
                this.username = '';
                this.address = '';
                this.load();
            },
            /**
             * 处理添加数据
             */
            handleInsert() {
                //使对话框显示
                this.dialogFormVisible = true;
                //将上一次的内容清空
                this.form = {};
            },
            /**
             * 添加数据或者更新数据
             */
            insertOrUpdate() {
                //发送请求
                this.request.post("/user", this.form)
                    .then((res) => {
                        if (res) {
                            this.$message.success("保存成功");
                            this.dialogFormVisible = false;
                            this.load();
                        } else {
                            this.$message.success("保存失败");
                        }
                    });
            },
            /**
             * 对数据进行编辑
             * @param data 当前行的数据
             */
            handleEdit(data) {
                //将当前行的数据放入对话框中
                this.form = data;
                //使对话框显示
                this.dialogFormVisible = true;
            },
            /**
             * 对数据进行删除
             * @param id 当前用户的id值
             */
            handleDelete(id) {
                //发送请求
                this.request.delete("/user/" + id).then((res) => {
                    if (res) {
                        this.$message.success("删除成功");
                        this.load();
                    } else {
                        this.$message.success("删除失败");
                    }
                });
            },
            /**
             * 批量处理删除数据请求
             */
            handleDeleteBatch() {
                //将得到的数据进行处理得到id数组
                let ids = this.multipleSelection.map(v => v.id);
                //发送请求
                this.request.post("/user/del/batch", ids).then((res) => {
                    if (res) {
                        this.$message.success("删除成功");
                        this.load();
                    } else {
                        this.$message.success("删除失败");
                    }
                });
            },
            /**
             * 将选中的数据进行保存
             * @param val 选中的数据
             */
            handleSelectionChange(val) {
                this.multipleSelection = val;
            }
        }
    };
</script>

<style>
    .home {
        height: 100vh;
    }

    .el-header {
        color: #333;
        line-height: 60px;
        border-bottom: 1px solid #ccc;
        text-align: right;
        display: flex;
    }

    .el-aside {
        color: #333;
    }
</style>