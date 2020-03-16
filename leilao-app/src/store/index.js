import Vue from 'vue'
import Vuex from 'vuex'

import unidades from './modules/Unidades'
import empresas from './modules/Empresas'
import leiloes from './modules/Leiloes'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        unidades, empresas, leiloes
    },
    state: {},
    mutations: {},
    actions: {},
})
