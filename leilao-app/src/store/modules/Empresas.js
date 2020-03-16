export default {
    state: {
        mostrarTabelaEmpresas: false,
        empresas: []
    },
    mutations: {
        setMostrarTabelaEmpresas(state, mostrarTabelaEmpresas) {
            state.mostrarTabelaEmpresas = mostrarTabelaEmpresas;
        },
        setEmpresas(state, empresas) {
            state.empresas = empresas;
        }
    },
    actions: {
        setMostrarTabelaEmpresas({commit}, mostrarTabelaEmpresas) {
            commit('setMostrarTabelaEmpresas', mostrarTabelaEmpresas);
        },
        setEmpresas({commit}, empresas) {
            commit('setEmpresas', empresas);
        }
    },
    getters: {
        getMostrarTabelaEmpresas(state) {
            return state.mostrarTabelaEmpresas;
        },
        getEmpresas(state) {
            return state.empresas;
        }
    }

}