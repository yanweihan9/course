<template>
    <div>
        <h4 class="lighter">
            <i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
            <router-link to="/business/course" class="pink"> {{course.name}} </router-link>
        </h4>
        <hr>
        <p>
            <router-link to="/business/course" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-arrow-left"></i>
                返回课程
            </router-link>
            &nbsp;
            <button v-on:click="add()" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-edit"></i>
                新增
            </button>
            &nbsp;
            <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-refresh"></i>
                刷新
            </button>
        </p>
        <pagination ref="pagination" v-bind:list="list"></pagination>
        <table id="simple-table" class="table  table-bordered table-hover">
            <Title></Title>
            <tbody>
            <tr v-for="chapter in chapters">
                <td>{{chapter.id}}</td>
                <td>{{chapter.name}}</td>
                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button v-on:click="toSection(chapter)" class="btn btn-xs btn-info">
                            小节
                        </button>
                        <button v-on:click="edit(chapter)" class="btn btn-xs btn-info">
                            编辑
                        </button>
                        <button v-on:click="del(chapter.id)" class="btn btn-xs btn-danger">
                            删除
                        </button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">表单</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input v-model="chapter.name" class="form-control" placeholder="名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">{{course.name}}</p>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</template>
<script>
    import Title from '../admin/title';
    import Pagination from '../../components/pagination';

    export default {
        name: 'chapter',
        data: function () {
            return {
                chapter: {},
                chapters: [],
                course: {},
            }
        },
        components: {Title, Pagination},
        mounted: function () {
            // 页面激活方式一
            // this.$parent.activeSidebar("business-chapter-sidebar")
            let _this = this;
            _this.$refs.pagination.size = 5;
            let course = SessionStorage.get("course") || {};
            if (Tool.isEmpty(course)){
                _this.$router.push("/welcome");
            }
            _this.course = course;
            console.info("--课程：",course);
            _this.list(1);
        },
        methods: {
            add() {
                let _this = this;
                _this.chapter = {};
                $(".modal").modal("show");
            },
            edit(chapter) {
                let _this = this;
                _this.chapter = $.extend({}, chapter);
                $(".modal").modal("show");
            },
            toSection(chapter) {
                let _this = this;
                SessionStorage.set("chapter",chapter);
                _this.$router.push("/business/section");
            },

            /**
             * 查询
             */
            list(page) {
                let _this = this;
                Loading.show();
                _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/chapter/list', {
                    page: page,
                    size: _this.$refs.pagination.size,
                    courseId: _this.course.id
                }).then((response) => {
                    Loading.hide();
                    let resp = response.data;
                    _this.chapters = resp.content.list;
                    _this.$refs.pagination.render(page, resp.content.total);
                })
            },

            /**
             * 保存
             */
            save() {
                let _this = this;
                if (!Validator.require(_this.chapter.name, "名称")
                    || !Validator.length(_this.chapter.courseId, "课程id", 1, 8)
                ) {
                    return;
                }
                _this.chapter.courseId = _this.course.id;
                Loading.show();
                _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/chapter/save',
                    _this.chapter).then((response) => {
                    Loading.hide();
                    let resp = response.data;
                    if (resp.success) {
                        $(".modal").modal("hide");
                        _this.list(1);
                        Toast.success("保存成功！")
                    } else {
                        Toast.warning(resp.message)
                    }
                })
            },

            /**
             * 删除
             */
            del(id) {
                let _this = this;
                Confirm.show("删除后不可恢复，确认删除?", function () {
                    Loading.show();
                    _this.$ajax.delete(process.env.VUE_APP_SERVER + '/business/admin/chapter/delete/' + id).then((response) => {
                        Loading.hide();
                        let resp = response.data;
                        if (resp.success) {
                            _this.list(1);
                            Toast.success("删除成功！")
                        }
                    })
                });

            }
        }
    }
</script>
