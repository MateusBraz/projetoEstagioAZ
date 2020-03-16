import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from "../views/Home"

Vue.use(VueRouter);

const Unidades = () =>
    import ( /* webpackChunkName: "unidade" */ '../views/unidade/Unidades');

const Empresas = () =>
    import ( /* webpackChunkName: "empresa" */ '../views/empresa/Empresas');

const Leiloes = () =>
    import ( /* webpackChunkName: "leilao" */ '../views/leilao/Leiloes');

const router = new VueRouter({
    routes: [
        {
            name: "home",
            path: "/",
            component: Home
        },
        {
            name: "unidades",
            path: "/unidades",
            component: Unidades
        },
        {
            name: "Empresas",
            path: "/empresas",
            component: Empresas
        },
        {
            name: "Leiloes",
            path: "/leiloes",
            component: Leiloes
        },
        {
            path: "*",
            redirect: "/"
        }]
});

export default router


