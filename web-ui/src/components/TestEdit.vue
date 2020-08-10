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
        props: {
            id: {
                default: null,
                type: String
            }
        },
        data() {
            return {
                testEditHidden: true,
                brand: {
                    id: null,
                    brandName: null,
                    brandSort: null,
                }
            }
        },
        methods: {
            setEmpty(){
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