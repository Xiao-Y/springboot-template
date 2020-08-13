<template>
    <div id="app">
        <form class="search">
            <div class="row">
                <div class="col col-md-10">
                    <input type="text" class="form-control" placeholder="品牌名称" v-model="queryFilter.brandName">
                </div>
                <div class="col col-md-2">
                    <button type="button" class="btn btn-primary" @click="getList"> Query</button>
                    &nbsp;&nbsp;
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                            @click="openAdd">
                        Add
                    </button>
                </div>
            </div>
        </form>

        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">品牌名称</th>
                <th scope="col">分类排序</th>
                <th scope="col">是否有效</th>
                <th scope="col">更新时间</th>
                <th scope="col">更新人</th>
                <th scope="col">创建时间</th>
                <th scope="col">创建人</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(page,index) in pageData" :key="page.id">
                <th scope="row">{{index}}</th>
                <td>{{page.brandName}}</td>
                <td>{{page.brandSort}}</td>
                <td>{{page.validInd}}</td>
                <td>{{page.creatorCode}}</td>
                <td>{{page.createTime | dateformat('YYYY-MM-DD HH:mm:ss')}}</td>
                <td>{{page.updaterCode}}</td>
                <td>{{page.updateTime | dateformat('YYYY-MM-DD HH:mm:ss')}}</td>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                                @click="openEdit(page.id)">Edit
                        </button>
                        <button type="button" class="btn btn-warning" :disabled="!page.validInd"
                                @click="prohibitData(page)">Prohibit
                        </button>
                        <button type="button" class="btn btn-danger" @click="deleteData(page.id)">Delete</button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-end">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </nav>

        <test-edit ref="editRef" :id="editId" @saveData="saveData" @updateData="updateData"></test-edit>
    </div>
</template>

<script>

    import TestEdit from '../components/TestEdit';

    export default {
        components: {
            TestEdit
        },
        data() {
            return {
                queryFilter: {
                    brandName: null
                },
                pageData: [],
                page: {
                    current: 0,
                    pageSize: 10,
                    total: 0
                },
                editId: null,
                message: null
            }
        },
        created() {
            this.getList();
        },
        methods: {
            getList() {
                const url = "/api/goodsBrandApi/findListByPage";
                let param = this.queryFilter;
                this.$http.post(url, param).then(res => {
                    console.info(res);
                    this.$set(this, "pageData", res.data.records)
                    this.page.current = res.data.current;
                    this.page.total = res.data.total;
                })
            },
            openAdd() {
                this.$refs.editRef.setEmpty();
                this.editId = null;
            },
            openEdit(id) {
                this.$refs.editRef.setEmpty();
                this.editId = id;
            },
            deleteData(id) {
                console.info("delete id:" + id);
                this.$confirm({
                    title: '删除',
                    msg: '是否删除这条信息？'
                }).then(() => {
                    console.log('ok')
                    const url = "/api/goodsBrandApi/delById/" + id;
                    this.$http.delete(url).then(res => {
                        console.info("delete success:" + res.data);
                        this.getList();
                    });
                }).catch(() => {
                    console.log('no')
                });

            },
            prohibitData(page) {
                console.info("prohibit id:" + page.id);
                this.$confirm({
                    title: '禁用',
                    msg: '是否禁用这条信息？'
                }).then(() => {
                    console.log('ok')
                    const url = "/api/goodsBrandApi/prohibitById/" + page.id;
                    this.$http.put(url).then(res => {
                        console.info("prohibit success:" + res.data);
                        page.validInd = false;

                    });
                }).catch(() => {
                    console.log('no')
                });
            },
            saveData(brand) {
                const url = "/api/goodsBrandApi/add";
                this.$http.post(url, brand).then(res => {
                    console.info("save success:" + res.data);
                    this.getList();
                });
            },
            updateData(brand) {
                const url = "/api/goodsBrandApi/update";
                this.$http.put(url, brand).then(res => {
                    console.info("update success:" + res.data);
                    this.getList();
                });
            }
        }
    }
</script>
<style>
    .search {
        margin-bottom: 6px;
    }
</style>
