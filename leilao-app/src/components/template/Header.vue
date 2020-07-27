<template>
    <v-toolbar color="indigo">

        <v-app-bar-nav-icon @click="mostrarNavigationDrawer" color="white"
                            class="d-flex d-md-none"></v-app-bar-nav-icon>

        <transition enter-active-class="animated bounceInRight" appear>
            <router-link to="/">
                <HeaderTitle/>
            </router-link>
        </transition>

        <v-spacer></v-spacer>

        <v-toolbar-items class="d-none d-md-flex">
            <v-btn class="headline white--text font-weight-light" text to="/">Início</v-btn>
            <v-btn class="headline white--text font-weight-light" text to="/unidades">Unidades</v-btn>
            <v-btn class="headline white--text font-weight-light" text to="/empresas">Empresas</v-btn>
            <v-btn class="headline white--text font-weight-light" text to="/leiloes">Leilões</v-btn>
        </v-toolbar-items>

    </v-toolbar>
</template>

<script>
    import HeaderTitle from "./HeaderTitle.vue"
    import barramento from "@/barramento";

    export default {
        components: {HeaderTitle},
        computed: {},
        methods: {
            mostrarNavigationDrawer() {
                barramento.setMostrarNavigationDrawer();
            }
        }
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