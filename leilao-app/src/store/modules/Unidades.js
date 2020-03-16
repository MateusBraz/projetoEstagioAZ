export default {
    state: {
        mostrarTabelaUnidades: false,
        unidades: []
    },
    mutations: {
        setMostrarTabelaUnidades(state, mostrarTabelaUnidades) {
            state.mostrarTabelaUnidades = mostrarTabelaUnidades;
        },
        setUnidades(state, unidades) {
            state.unidades = unidades;
        }
    },
    actions: {
        setMostrarTabelaUnidades({commit}, mostrarTabelaUnidades) {
            commit('setMostrarTabelaUnidades', mostrarTabelaUnidades);
        },
        setUnidades({commit}, unidades) {
            commit('setUnidades', unidades);
        }
    },
    getters: {
        getMostrarTabelaUnidades(state) {
            return state.mostrarTabelaUnidades;
        },
        getUnidades(state) {
            return state.unidades;
        }
    }
}