<template>
    <v-toolbar color="indigo">

        <transition enter-active-class="animated bounceInRight" appear>
            <HeaderTitle/>
        </transition>

        <v-spacer></v-spacer>

        <v-toolbar-items>
            <v-btn class="headline white--text font-weight-light" text to="/">Início</v-btn>
            <v-btn class="headline white--text font-weight-light" text to="/unidades">Unidades</v-btn>
            <v-btn class="headline white--text font-weight-light" text to="/empresas">Empresas</v-btn>
            <v-btn class="headline white--text font-weight-light" text to="/leiloes">Leilões</v-btn>
        </v-toolbar-items>
    </v-toolbar>
</template>

<script>
    import HeaderTitle from "./HeaderTitle.vue"

    export default {
        components: {HeaderTitle},
        computed: {}
    };
</script>

<style>
    span {
        color: white;
    }

    .titulo1 {
        font-size: 2rem;
    }

</style>