<template>
    <v-app>

        <div>
            <Header/>
        </div>

        <NavigationDrawer/>

        <v-content style="background-color: #5C6BC0">
            <v-container>
                <transition enter-active-class="animated bounceInRight" leave-active-class="animated bounceOutLeft"
                            mode="out-in" apper>
                    <router-view></router-view>
                </transition>
            </v-container>
        </v-content>

        <Footer/>

    </v-app>
</template>

<script>

    import Header from "./components/template/Header.vue"
    import NavigationDrawer from "./components/template/NavigationDrawer.vue";
    import Footer from "./components/template/Footer.vue"

    export default {
        components: {
            Header,
            NavigationDrawer,
            Footer
        },
        data: () => ({
            //
        }),
    };
</script>

<style>
    * {
        user-select: none;
    }
</style>

