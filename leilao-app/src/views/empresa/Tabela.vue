<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-data-table
            class="mt-5 indigo lighten-3"
            :headers="cabecalhos"
            :items="empresas"
            :single-select="true"
            item-key="id"
    >
        <template v-slot:item.actions="{ item }">
            <v-icon
                    small
                    class="mr-2"
                    @click="editarItem(item)"
            >
                mdi-pencil
            </v-icon>
            <v-icon
                    small
                    @click="deletarItem(item)"
            >
                mdi-delete
            </v-icon>
        </template>
    </v-data-table>
</template>

<script>
    import barramento from '../../barramento'

    export default {
        data() {
            return {
                cabecalhos: [
                    {
                        text: 'CNPJ',
                        align: 'start',
                        sortable: false,
                        value: 'cnpj'
                    },
                    {
                        text: 'Razão Social',
                        align: 'start',
                        sortable: false,
                        value: 'razaoSocial'
                    },
                    {
                        text: 'Telefone',
                        align: 'start',
                        sortable: false,
                        value: 'telefone'
                    },
                    {
                        text: 'Email',
                        align: 'start',
                        sortable: false,
                        value: 'email'
                    },
                    {text: 'Ações', value: 'actions', sortable: false, align: 'right'}
                ]
            }
        },
        computed: {
            empresas() {
                return this.$store.getters.getEmpresas;
            }
        },
        methods: {
            editarItem(item) {
                barramento.setAtualizarEmpresa(item);
            },
            deletarItem(item) {
                confirm('Tem certeza de que deseja excluir esta empresa?') && this.$store.dispatch('setMostrarTabelaEmpresas', false) && barramento.setDeletarEmpresa(item);
            }
        }
    }
</script>

<style>

</style>