export default {
    state: {
        mostrarTabelaLeiloes: false,
        leiloes: []
    },
    mutations: {
        setMostrarTabelaLeiloes(state, mostrarTabelaLeiloes) {
            state.mostrarTabelaLeiloes = mostrarTabelaLeiloes;
        },
        setLeiloes(state, leiloes) {
            state.leiloes = leiloes;
        }
    },
    actions: {
        setMostrarTabelaLeiloes({commit}, mostrarTabelaLeiloes) {
            commit('setMostrarTabelaLeiloes', mostrarTabelaLeiloes);
        },
        setLeiloes({commit}, leiloes) {
            commit('setLeiloes', leiloes);
        }
    },
    getters: {
        getMostrarTabelaLeiloes(state) {
            return state.mostrarTabelaLeiloes;
        },
        getLeiloes(state) {
            return state.leiloes;
        }
    }

}