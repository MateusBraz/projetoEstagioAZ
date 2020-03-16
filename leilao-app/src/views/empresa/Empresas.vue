<template>
    <v-row justify="center">
        <v-col cols="12" sm="10" md="8" lg="6">
            <Titulo titulo="Empresa"/>
            <Formulario @criarEmpresa="salvarEmpresa($event)" @deletarEmpresa="deletar($event)"/>
        </v-col>
        <v-col cols="12" sm="10" md="8" lg="6">
            <Titulo titulo="Lista de Empresas"/>
            <transition enter-active-class="animated bounceInUp" leave-active-class="animated bounceOutDown">
                <Tabela v-if="mostrarTabela"/>
            </transition>
        </v-col>
    </v-row>
</template>

<script>
    import Titulo from '@/components/Titulo.vue';
    import Formulario from './Formulario.vue';
    import Tabela from './Tabela.vue';

    export default {
        components: {
            Titulo, Formulario, Tabela
        },
        computed: {
            mostrarTabela() {
                return this.$store.getters.getMostrarTabelaEmpresas;
            }
        },
        methods: {
            salvarEmpresa(empresa) {
                if (empresa.id == null) {
                    this.cadastrar(empresa);
                } else {
                    this.atualizar(empresa);
                }

            },
            cadastrar(empresa) {
                this.get$_isHttp.post(`/empresas`, empresa)
                    .then(response => {
                        alert("Cadastrado com sucesso!");
                        this.info = response.data.bpi
                    }).catch(error => {
                    alert(error.response.data.message);
                })
            },
            atualizar(empresa) {
                this.get$_isHttp.put(`/empresas/${empresa.id}`, empresa)
                    .then(response => {
                        alert("Atualizado com sucesso!");
                        this.info = response.data.bpi
                    }).catch(error => {
                    alert(error.response.data.message);
                })
            },
            deletar(id) {
                this.get$_isHttp.delete(`/empresas/${id}`)
                    .then(response => {
                        alert("Excluido com sucesso!");
                        this.info = response.data.bpi
                    }).catch(error => {
                    alert(error.response.data.message);
                })
            }
        }
    }
</script>

<style>

</style>