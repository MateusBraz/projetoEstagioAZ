<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-card dark class="indigo darken-1">
        <v-card-title>
            Unidades
            <v-spacer></v-spacer>
            <v-text-field
                    v-model="buscar"
                    append-icon="mdi-magnify"
                    label="Buscar"
                    single-line
                    hide-details
            ></v-text-field>
        </v-card-title>
        <v-data-table
                class="mt-5 indigo lighten-3"
                :headers="cabecalhos"
                :items="unidades"
                :single-select="true"
                :search="buscar"
                item-key="nome"
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
    </v-card>
</template>

<script>
    import barramento from '../../barramento'

    export default {
        data() {
            return {
                buscar: '',
                cabecalhos: [
                    {
                        text: 'Nome',
                        align: 'center',
                        sortable: false,
                        value: 'nome'
                    },
                    {text: 'Ações', value: 'actions', sortable: false, align: 'right'}
                ]
            }
        },
        computed: {
            unidades() {
                return this.$store.getters.getUnidades;
            }
        },
        methods: {
            editarItem(item) {
                barramento.setAtualizarUnidade(item);
            },
            deletarItem(item) {
                confirm('Tem certeza de que deseja excluir esta unidade?') && this.$store.dispatch('setMostrarTabelaUnidades', false) && barramento.setDeletarUnidade(item);
            }
        }
    }
</script>