<template>
    <v-app>

        <div>
            <Header/>
        </div>

        <NavigationDrawer/>

        <v-main style="background-color: #5C6BC0; height: 100%">
            <v-container>
                <transition name="slide" mode="out-in" apper>
                    <router-view></router-view>
                </transition>
            </v-container>
        </v-main>

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

    @keyframes slide-in {
        from {
            transform: translateY(-30px);
            opacity: 0;
        }
        to {
            transform: translateY(0px);
            opacity: 1;
        }
    }

    @keyframes slide-out {
        from {
            transform: translateY(0px);
            opacity: 1;
        }
        to {
            transform: translateY(-30px);
            opacity: 0;
        }
    }

    .slide-enter-active {
        animation: slide-in 0.3s ease;
    }

    .slide-leave-active {
        animation: slide-out 0.3s ease;
    }
</style>

