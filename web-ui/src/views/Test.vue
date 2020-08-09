<template>
    <div class="about">
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
            </tr>
            </thead>
            <tbody>
            <tr v-for="(page,index) in pageData" :key="page.id">
                <th scope="row">{{index}}</th>
                <td>{{page.brandName}}</td>
                <td>{{page.brandSort}}</td>
                <td>{{page.validInd}}</td>
                <td>{{page.updateTime}}</td>
                <td>{{page.updaterCode}}</td>
                <td>{{page.createTime}}</td>
                <td>{{page.creatorCode}}</td>
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
    </div>
</template>

<script>
    export default {
        data() {
            return {
                pageData: [],
                page: {
                    current: 0,
                    pageSize: 10,
                    total: 0
                }
            }
        },
        created() {
            this.getList();
        },
        methods: {
            getList() {
                const url = "/api/goodsBrandApi/findListByPage";
                var param = {};
                this.$http.post(url, param).then(res => {
                    console.info(res);
                    this.pageData = res.data.records;
                    this.page.current = res.data.current;
                    this.page.total = res.data.total;
                })
            }
        }
    }
</script>
