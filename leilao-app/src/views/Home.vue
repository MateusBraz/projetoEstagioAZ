<template>
    <div>
        <Titulo titulo="Faça os seus Cadastros"/>

        <transition enter-active-class="animated pulse" appear>
            <v-sheet :elevation="6" class="pa-2 mt-3" color="indigo  lighten-2">
                <span class="headline white--text font-weight-light">Cadastro de Unidades</span>
            </v-sheet>
        </transition>

        <transition enter-active-class="animated pulse" appear>
            <v-sheet :elevation="6" class="pa-2 mt-3" color="indigo  lighten-2">
                <span class="headline white--text font-weight-light">Busca de Unidades</span>
            </v-sheet>
        </transition>

        <transition enter-active-class="animated pulse" appear>
            <v-sheet :elevation="6" class="pa-2 mt-3" color="indigo darken-2">
            <span class="headline white--text font-weight-light"
            >Cadastros de Empresas</span>
            </v-sheet>
        </transition>

        <transition enter-active-class="animated pulse" appear>
            <v-sheet :elevation="6" class="pa-2 mt-3" color="indigo darken-2">
            <span class="headline white--text font-weight-light"
            >Busca de Empresas</span>
            </v-sheet>
        </transition>

        <transition enter-active-class="animated pulse" appear>
            <v-sheet :elevation="6" class="pa-2 mt-3" color="indigo darken-4">
            <span class="headline white--text font-weight-light"
            >Busca de Leilões</span>
            </v-sheet>
        </transition>

    </div>
</template>

<script>
    import Titulo from '../components/Titulo.vue';

    export default {
        components: {
            Titulo
        }
    };
</script>

<style>
</style>