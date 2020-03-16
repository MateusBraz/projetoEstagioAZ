import Vue from 'vue'
import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8081';

Vue.use({
    install(Vue) {
        Vue.prototype.get$_isHttp = axios;
    }
})