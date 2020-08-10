<template>
    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel"
         aria-hidden="true" v-if="isShow">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">{{text.title}}</h5>
                    <button type="button" class="close" aria-label="Close" @click="isShow = false">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>{{text.msg}}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" @click="close()" v-if="text.btn.no">
                        {{text.btn.no}}
                    </button>
                    <button type="button" class="btn btn-secondary" @click="ok()" v-if="text.btn.ok">{{text.btn.ok}}
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                isShow: true,
                text: {
                    title: '提示',
                    msg: '确定提交此操作？',
                    btn: {
                        ok: '确定',
                        no: '取消'
                    },
                }
            }
        },
        methods: {
            close() {
                console.log('关闭');
            },
            ok() {
                console.log('确定')
            }
        },
        // 页面发生更新的时候进行回调
        updated() {
            $("#confirmModal").modal('show');
        },
        watch: {
            isShow(newVal) {
                if (!newVal) {
                    $("#confirmModal").modal('hide');
                }
            }
        }
    }
</script>
