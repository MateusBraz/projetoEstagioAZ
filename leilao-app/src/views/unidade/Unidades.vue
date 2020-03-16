<template>
    <v-row justify="center">
        <v-col cols="12" sm="10" md="8" lg="6">
            <Titulo titulo="Unidade"/>
            <Formulario @criarUnidade="salvarUnidade($event)" @deletarUnidade="deletar($event)"/>
        </v-col>
        <v-col cols="12" sm="10" md="8" lg="6">
            <Titulo titulo="Lista de Unidades"/>
            <transition enter-active-class="animated bounceInUp" leave-active-class="animated bounceOutDown">
                <Tabela v-if="mostrarTabela"/>
            </transition>
        </v-col>
    </v-row>
</template>

<script>
    import Formulario from "./Formulario.vue"
    import Titulo from "../../components/Titulo.vue"
    import Tabela from "./Tabela.vue"

    export default {
        components: {
            Formulario, Titulo, Tabela
        },
        data() {
            return {
                info: null,
            }
        },
        computed: {
            mostrarTabela() {
                return this.$store.getters.getMostrarTabelaUnidades;
            },
            exibir() {
                return this.$store.getters.getExibirAlerta;
            }
        },
        methods: {
            salvarUnidade(unidade) {
                if (unidade.id == null) {
                    this.cadastrar(unidade);
                } else {
                    this.atualizar(unidade);
                }
            },
            cadastrar(unidade) {
                this.get$_isHttp.post(`/unidades`, unidade)
                    .then(response => {
                        alert("Cadastrado com sucesso!");
                        this.info = response.data.bpi
                    })
            },
            atualizar(unidade) {
                this.get$_isHttp.put(`/unidades/${unidade.id}`, unidade)
                    .then(response => {
                        alert("Atualizado com sucesso!");
                        this.info = response.data.bpi
                    })
            },
            deletar(id) {
                this.get$_isHttp.delete(`/unidades/${id}`)
                    .then(response => {
                        alert("Excluido com sucesso!");
                        this.info = response.data.bpi
                    })
            }
        }
    }
</script>

<style>

</style>