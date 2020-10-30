<template>
    <div>
    <p>
        <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
            <i class="ace-icon fa fa-refresh red2"></i>
            刷新
        </button>
    </p>
    <pagination ref="pagination" v-bind:list="list"></pagination>
    <table id="simple-table" class="table  table-bordered table-hover">
        <Title></Title>
        <tbody>
        <tr v-for="chapter in chapters">
            <td>{{chapter.id}}</td>
            <td>{{chapter.courseId}}</td>
            <td>{{chapter.name}}</td>
            <td>
                <div class="hidden-sm hidden-xs btn-group">
                    <button class="btn btn-xs btn-success">
                        <i class="ace-icon fa fa-check bigger-120"></i>
                    </button>

                    <button class="btn btn-xs btn-info">
                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                    </button>

                    <button class="btn btn-xs btn-danger">
                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                    </button>

                    <button class="btn btn-xs btn-warning">
                        <i class="ace-icon fa fa-flag bigger-120"></i>
                    </button>
                </div>

                <div class="hidden-md hidden-lg">
                    <div class="inline pos-rel">
                        <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"
                                data-position="auto">
                            <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                        </button>

                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                            <li>
                                <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                                                    <span class="blue">
                                                                        <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                    </span>
                                </a>
                            </li>

                            <li>
                                <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                                    <span class="green">
                                                                        <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                    </span>
                                </a>
                            </li>

                            <li>
                                <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                    <span class="red">
                                                                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                    </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
    </div>
</template>
<script>
    import Title from '../admin/title';
    import Pagination from '../../components/pagination';

    export default {
        name: 'chapter',
        data: function () {
            return {
                chapters: []
            }
        },
        components: {Title,Pagination},
        mounted: function () {
            // 页面激活方式一
            // this.$parent.activeSidebar("business-chapter-sidebar")
            let _this = this;
            _this.$refs.pagination.size = 5;
            _this.list(1);
        },
        methods: {
            list(page) {
                let _this = this;
                _this.$ajax.post('http://127.0.0.1:9000/business/admin/chapter/list', {
                    page: page,
                    size: _this.$refs.pagination.size,
                }).then((response) => {
                    console.log("查询大章列表结果:", response);
                    _this.chapters = response.data.list;
                    _this.$refs.pagination.render(page, response.data.total);
                })
            }
        }
    }
</script>
