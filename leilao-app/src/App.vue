<template>
    <v-app>

        <div>
            <Header/>
        </div>

        <v-content>
            <v-img src="https://scalpertrader.com.br/wp-content/uploads/fundo.jpg"
                   aspect-ratio="1"
            >
                <v-container>
                    <transition enter-active-class="animated bounceInRight" leave-active-class="animated bounceOutLeft"
                                mode="out-in" apper>
                        <router-view></router-view>
                    </transition>
                </v-container>
            </v-img>
        </v-content>

        <Footer/>

    </v-app>
</template>

<script>

    import Header from "./components/template/Header.vue"
    import Footer from "./components/template/Footer.vue"

    export default {
        components: {
            Header,
            Footer
        },
        data: () => ({
            //
        }),
    };
</script>

