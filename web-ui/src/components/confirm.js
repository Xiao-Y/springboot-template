import Vue from 'vue';
import confirm from './confirm.vue';

let confirmConstructor = Vue.extend(confirm);

let theConfirm = function (text) {
    //promise封装，ok执行resolve，no执行rejectlet
    return new Promise((res, rej) => {
        let confirmDom = new confirmConstructor({
            el: document.createElement('div')
        })
        //new一个对象，然后插入body里面
        document.body.appendChild(confirmDom.$el);
        //为了使confirm的扩展性更强，这个采用对象的方式传入，所有的字段都可以根据需求自定义
        Object.assign(confirmDom.text,text);
        confirmDom.ok = function () {
            res()
            confirmDom.isShow = false
        }
        confirmDom.close = function () {
            rej()
            confirmDom.isShow = false
        }
    })
}

export default theConfirm;
