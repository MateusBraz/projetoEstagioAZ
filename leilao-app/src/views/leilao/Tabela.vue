<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-card dark class="indigo darken-1">
        <v-card-title>
            Leilões
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
                class="mt-5 indigo darken-1"
                :headers="cabecalhos"
                :items="leiloes"
                :single-select="true"
                :search="buscar"
                item-key="id"
        >
        </v-data-table>

    </v-card>

</template>

<script>
    export default {
        data() {
            return {
                buscar: '',
                leiloes: [],
                cabecalhos: [
                    {
                        text: 'Vendedor',
                        align: 'start',
                        sortable: false,
                        value: 'vendedor'
                    },
                    {
                        text: 'Inicio Previsto',
                        align: 'start',
                        sortable: false,
                        value: 'inicioPrevisto'
                    },
                    {
                        text: 'Total do Leilão',
                        align: 'start',
                        sortable: false,
                        value: 'totalLeilao'
                    }
                ]
            }
        },
        created() {
            this.get$_isHttp.get(`/leiloes`).then(response => {
                this.leiloes = response.data;
                if (response.data.length == 0) {
                    alert("Você não possui nenhum leilão cadastrada!");
                }
            }).catch(error => {
                console.log(error.response)
            })
        }
    }
</script>

<style>

</style>