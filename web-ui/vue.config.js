const webpack = require("webpack");

module.exports = {
    devServer: {
        port: 8090,// 端口
        proxy: {
            //名字可以自定义，这里我用的是api
            '/api': {
                target: 'http://127.0.0.1:8080',//设置你调用的接口域名和端口号 别忘了加http
                changeOrigin: true,//这里设置是否跨域
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    },
    lintOnSave: false,// 取消 eslint 验证
    configureWebpack: {
        plugins: [
            new webpack.ProvidePlugin({
                $: 'jquery',
                jQuery: 'jquery',
                'window.jQuery': 'jquery',
                Popper: ['popper.js', 'default']
            })
        ]
    }
}