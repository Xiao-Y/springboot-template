<template>
    <div id="app">
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Message</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">brandName:</label>
                                <input type="text" class="form-control" id="recipient-name" v-model="brand.brandName">
                            </div>
                            <div class="form-group">
                                <label for="brandSort-name" class="col-form-label">brandSort:</label>
                                <input type="text" class="form-control" id="brandSort-name" v-model="brand.brandSort">
                            </div>
                            <div class="form-group">
                                <label for="updateTime-name" class="col-form-label">updateTime:</label>
                                <input type="text" class="form-control" id="updateTime-name" v-model="brand.updateTime"
                                       @click="activeIndex = 0">
                                <calendar v-show="activeIndex !== -1" ref="updateTime" @choseDay="clickDay"></calendar>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" @click="save">Save</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>


    </div>
</template>

<script>

    export default {
        components: {},
        props: {
            id: {
                default: null,
                type: String
            }
        },
        data() {
            return {
                activeIndex: -1,
                brand: {
                    id: null,
                    brandName: null,
                    brandSort: null,
                    updateTime: Date.parse(new Date()).toString()
                }
            }
        },
        methods: {
            clickDay(dateInfo) {
                this.brand.updateTime = dateInfo;
                this.activeIndex = -1;
            },
            setEmpty() {
                this.brand.id = null;
                this.brand.brandName = null;
                this.brand.brandSort = null;
            },
            queryDataById() {
                if (!this.id) {
                    this.setEmpty();
                    return;
                }
                this.$http.get("/api/goodsBrandApi/findById/" + this.id).then(res => {
                    Object.assign(this.brand, res.data);
                });

            },
            save() {
                if (this.brand.id) {
                    this.$emit("updateData", this.brand);
                } else {
                    this.$emit("saveData", this.brand);
                }
                $("#exampleModal").modal('hide');
            }
        },
        watch: {
            id(newVal, oldVal) {
                console.info("newVal:{},oldVal:{}", newVal, oldVal)
                this.queryDataById();
            }
        }
    }
</script>

<style>
    .card div:nth-child(1) {
        background-color: #BDC0BA;
        padding-bottom: 0;
    }

    .card div:nth-child(3) div, .card div:nth-child(2) div {
        height: 35px;
        width: 35px;
    }

    .wh_content_all[data-v-2ebcbc83] {
        background-color: #000;
    }

    /*今天*/
    .wh_content_item .wh_isToday[data-v-2ebcbc83] {
        background-color: rgb(139, 175, 241);
    }

    /*日历点击*/
    .wh_content_item .wh_chose_day[data-v-2ebcbc83] {
        background-color: transparent;
    }

    /*日历划过*/
    .wh_item_date[data-v-2ebcbc83]:hover {
        background-color: rgb(111, 223, 223);
        border-radius: 100%;
    }
</style>