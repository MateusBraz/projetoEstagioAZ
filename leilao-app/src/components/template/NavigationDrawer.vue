<template>
    <v-navigation-drawer
            style="background-color: #37474F;"
            dark
            v-model="drawer"
            absolute
            temporary
    >
        <v-list
                nav
                dense
        >
            <v-list-item-group
                    active-class="deep-purple--text text--accent-4"
            >
                <v-list-item @click="drawer = false">
                    <v-btn width="100%" text to="/">
                        <v-list-item-icon>
                            <v-icon>fa-home</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title to="/">Início</v-list-item-title>
                    </v-btn>
                </v-list-item>

                <v-list-item @click="drawer = false">
                    <v-btn width="100%" text to="/unidades">
                        <v-list-item-icon>
                            <v-icon>fa-archive</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Unidades</v-list-item-title>
                    </v-btn>
                </v-list-item>

                <v-list-item @click="drawer = false">
                    <v-btn width="100%" text to="/empresas">
                        <v-list-item-icon>
                            <v-icon>fa-building</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Empresas</v-list-item-title>
                    </v-btn>
                </v-list-item>

                <v-list-item @click="drawer = false">
                    <v-btn width="100%" text to="/leiloes">
                        <v-list-item-icon>
                            <v-icon>fa-gavel</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title>Leilões</v-list-item-title>
                    </v-btn>
                </v-list-item>

            </v-list-item-group>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
    import barramento from "@/barramento"

    export default {
        name: "NavigationDrawer",
        data: () => {
            return {
                drawer: false
            }
        },
        created() {
            barramento.onMostrarNavigationDrawer(() => {
                this.drawer = true;
            })
        }
    }
</script>

<style scoped>

</style>