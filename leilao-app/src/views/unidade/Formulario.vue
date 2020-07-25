<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-card dark ref="form" class="pt-2 pb-2 pl-2 pr-2" color="indigo darken-1">
        <v-text-field
                ref="nome"
                v-model.trim="nome"
                :rules="[
              () => !!nome || 'nome é obrigatório',
              () => !!nome && nome.length <= 128 || 'O nome deve ter menos de 129 caracteres.',
            ]"
                label="Nome da Unidade"
                placeholder="digite o nome aqui."
                required
        ></v-text-field>

        <v-card-actions>
            <v-btn text @click="buscarUnidades">Buscar Unidades</v-btn>

            <v-spacer></v-spacer>
            <v-slide-x-reverse-transition>
                <v-tooltip
                        v-if="formularioPossuiErros"
                        left
                >
                    <template v-slot:activator="{ on }">
                        <v-btn
                                icon
                                class="my-0"
                                @click="resetarFormulario"
                                v-on="on"
                        >
                            <v-icon>mdi-refresh</v-icon>
                        </v-btn>
                    </template>
                    <span>Refresh form</span>
                </v-tooltip>
            </v-slide-x-reverse-transition>
            <v-btn color="teal accent-3" text @click="verificar">Salvar</v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    import barramento from '../../barramento'

    export default {
        data() {
            return {
                nome: "",
                id: null,
                mensagensDeErro: '',
                formularioPossuiErros: false,
            }
        },
        created() {
            barramento.onAtualizarUnidade(unidade => {
                this.nome = unidade.nome;
                this.id = unidade.id;
            }),
                barramento.onDeletarUnidade(unidade => {
                    this.$emit('deletarUnidade', unidade.id);
                    this.resetarFormulario();
                })
        },
        computed: {
            form() {
                return {
                    nome: ""
                }
            },
        },
        methods: {
            buscarUnidades() {
                this.get$_isHttp.get(`/unidades`).then(response => {
                    this.$store.dispatch('setUnidades', response.data);
                    this.$store.dispatch('setMostrarTabelaUnidades', true);
                    if (response.data.length == 0) {
                        alert("Você não possui nenhuma unidade cadastrada!");
                    }
                })
            },
            resetarFormulario() {
                this.mensagensDeErro = [];
                this.formularioPossuiErros = false;

                Object.keys(this.form).forEach(f => {
                    this.$refs[f].reset()
                })
            },
            verificar() {
                this.formularioPossuiErros = false;
                Object.keys(this.form).forEach(f => {
                    if (!this.form[f]) {
                        this.formularioPossuiErros = true;
                        this.$refs[f].validate(true);
                    }
                    if (this.$refs[f].validate(true)) {
                        const unidadeAserSalva = {
                            id: this.id,
                            nome: this.nome
                        };
                        this.$emit('criarUnidade', unidadeAserSalva);
                        this.$store.dispatch('setMostrarTabelaUnidades', false);
                        this.resetarFormulario();
                        this.id = null
                    }
                })
            }
        }
    }
</script>

<style>

</style>