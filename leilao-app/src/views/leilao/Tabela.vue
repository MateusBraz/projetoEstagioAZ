<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-data-table
            class="mt-5 indigo lighten-3"
            :headers="cabecalhos"
            :items="leiloes"
            :single-select="true"
            item-key="id"
    >
    </v-data-table>
</template>

<script>
    export default {
        data() {
            return {
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