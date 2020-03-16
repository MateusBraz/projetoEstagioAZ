import Vue from "vue"

export default new Vue({
    methods: {
        setAtualizarUnidade(unidade) {
            this.$emit('atualizarUnidade', unidade);
        },
        onAtualizarUnidade(callback) {
            this.$on('atualizarUnidade', callback);
        },
        setDeletarUnidade(unidade) {
            this.$emit('deletarUnidade', unidade);
        },
        onDeletarUnidade(callback) {
            this.$on('deletarUnidade', callback);
        },
        setAtualizarEmpresa(empresa) {
            this.$emit('atualizarEmpresa', empresa);
        },
        onAtualizarEmpresa(callback) {
            this.$on('atualizarEmpresa', callback);
        },
        setDeletarEmpresa(empresa) {
            this.$emit('deletarEmpresa', empresa);
        },
        onDeletarEmpresa(callback) {
            this.$on('deletarEmpresa', callback);
        }
    }
})