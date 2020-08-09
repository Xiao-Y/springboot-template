<template>
        <div class="modal-dialog" v-if="isShow" tabindex="-1">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">{{text.type}}</h5>
                    <button type="button" class="close" @click="isShow=false" aria-label="Close">
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
</template>
<script>
    export default {
        data() {
            return {
                isShow: true,
                text: {
                    type: '提示',
                    msg: '确定删除此条信息？',
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
        }
    }
</script>
