<template>
    <v-row justify="center">
        <v-col cols="12" sm="10" md="8" lg="6">
            <Titulo titulo="Leilões"/>
            <Tabela/>
        </v-col>
    </v-row>
</template>

<script>
    import Titulo from '@/components/Titulo.vue'
    import Tabela from './Tabela.vue'

    export default {
        components: {
            Titulo, Tabela
        }
    }
</script>

<style>

</style>