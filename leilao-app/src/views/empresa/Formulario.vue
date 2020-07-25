<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-card dark ref="form" class="pt-2 pb-2 pl-2 pr-2" color="indigo darken-1">
        <v-text-field
                ref="razaoSocial"
                v-model.trim="razaoSocial"
                :rules="[
              () => !!razaoSocial || 'Razão social é obrigatório',
              () => !!razaoSocial && razaoSocial.length <= 64 || 'Máximo 64 caracteres.']"
                label="* Razão social"
                :error-messages="errorMessages"
                placeholder="digite a razão social aqui."
                required
        ></v-text-field>

        <v-text-field
                ref="cnpj"
                v-model.trim="cnpj"
                :rules="[
              () => !!cnpj || 'CNPJ é obrigatório',
              () => !!cnpj && cnpj.length <= 32 || 'Máximo 32 caracteres.']"
                label="* CNPJ"
                type="number"
                :error-messages="errorMessages"
                placeholder="digite o CNPJ aqui."
                required
        ></v-text-field>

        <v-text-field
                ref="logradouro"
                v-model.trim="logradouro"
                :rules="[
                () => logradouro == null || logradouro.length <= 64 || 'Máximo 64 caracteres.']"
                label="Logradouro"
                :error-messages="errorMessages"
                placeholder="digite logradouro aqui."
        ></v-text-field>

        <v-text-field
                ref="municipio"
                v-model.trim="municipio"
                :rules="[
                () => municipio == null || municipio.length <= 64 || 'Máximo 64 caracteres.']"
                label="Município"
                :error-messages="errorMessages"
                placeholder="digite município aqui."
        ></v-text-field>

        <v-text-field
                ref="numero"
                v-model.trim="numero"
                :rules="[
                () => numero == null || numero.length <= 10 || 'Máximo 10 caracteres.']"
                type="number"
                label="Número"
                :error-messages="errorMessages"
                placeholder="digite o número aqui."
        ></v-text-field>

        <v-text-field
                ref="complemento"
                v-model.trim="complemento"
                :rules="[
                () => complemento == null || complemento.length <= 64 || 'Máximo 64 caracteres.']"
                label="Complemento"
                :error-messages="errorMessages"
                placeholder="digite o complemento aqui."
        ></v-text-field>

        <v-text-field
                ref="bairro"
                v-model.trim="bairro"
                :rules="[
                () => bairro == null || bairro.length <= 64 || 'Máximo 64 caracteres.']"
                label="Bairro"
                :error-messages="errorMessages"
                placeholder="digite o bairro aqui."
        ></v-text-field>

        <v-text-field
                ref="cep"
                v-model.trim="cep"
                :rules="[
                () => cep == null || cep.length <= 10 || 'Máximo 10 caracteres.']"
                type="number"
                label="CEP"
                :error-messages="errorMessages"
                placeholder="digite o cep aqui."
        ></v-text-field>

        <v-text-field
                ref="telefone"
                v-model.trim="telefone"
                :rules="[
                () => telefone == null || telefone.length <= 32 || 'Máximo 32 caracteres.']"
                type="number"
                label="Telefone"
                :error-messages="errorMessages"
                placeholder="digite o telefone aqui."
        ></v-text-field>

        <v-text-field
                ref="email"
                v-model.trim="email"
                :rules="regrasEmail"
                label="* Email"
                :error-messages="errorMessages"
                placeholder="digite o email aqui."
                type="email"
                required
        ></v-text-field>

        <v-text-field
                ref="site"
                v-model.trim="site"
                :rules="[
                () => site == null || site.length <= 254 || 'Máximo 254 caracteres.']"
                label="Site"
                :error-messages="errorMessages"
                placeholder="digite o site aqui."
        ></v-text-field>

        <v-text-field
                ref="usuario"
                v-model.trim="usuario"
                :rules="[
                () => !!usuario || 'Usuário é obrigatório',
                () => !!usuario && usuario.length <= 20 || 'Máximo 20 caracteres.']"
                label="* Usuário"
                :error-messages="errorMessages"
                placeholder="digite o usuário aqui."
                required
        ></v-text-field>

        <v-text-field
                ref="senha"
                v-model.trim="senha"
                :append-icon="mostrar ? 'mdi-eye' : 'mdi-eye-off'"
                :rules="[
                () => senha == null || senha.length <= 128 || 'Máximo 128 caracteres.'
                ]"
                :type="mostrar ? 'text' : 'password'"
                label="Senha"
                :error-messages="errorMessages"
                placehordel="digite a senha aqui."
                hint="Máximo 128 caracteres."
                @click:append="mostrar = !mostrar"
        >
        </v-text-field>


        <v-card-actions>
            <v-btn text @click="buscarEmpresas">Buscar Empresas</v-btn>

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
                validacoes: 0,
                id: null,
                mostrar: false,
                formularioPossuiErros: false,
                errorMessages: null,
                razaoSocial: null,
                cnpj: null,
                logradouro: null,
                municipio: null,
                numero: null,
                complemento: null,
                bairro: null,
                cep: null,
                telefone: null,
                email: null,
                site: null,
                usuario: null,
                senha: null,
                regrasEmail: [
                    v => !!v || 'E-mail é obrigatório.',
                    v => /.+@.+\..+/.test(v) || 'E-mail deve ser válido.'
                ],
            }
        },
        created() {
            barramento.onAtualizarEmpresa(empresa => {
                this.id = empresa.id;
                this.razaoSocial = empresa.razaoSocial;
                this.cnpj = empresa.cnpj;
                this.logradouro = empresa.logradouro;
                this.municipio = empresa.municipio;
                this.numero = empresa.numero;
                this.complemento = empresa.complemento;
                this.bairro = empresa.bairro;
                this.cep = empresa.cep;
                this.telefone = empresa.telefone;
                this.email = empresa.email;
                this.site = empresa.site;
                this.usuario = empresa.usuario;
                this.senha = empresa.senha;
            }),
                barramento.onDeletarEmpresa(empresa => {
                    this.$emit('deletarEmpresa', empresa.id);
                    this.resetarFormulario();
                })
        },
        computed: {
            form() {
                return {
                    razaoSocial: "",
                    cnpj: "",
                    logradouro: "",
                    municipio: "",
                    numero: "",
                    complemento: "",
                    bairro: "",
                    cep: "",
                    telefone: "",
                    email: "",
                    site: "",
                    usuario: "",
                    senha: ""
                }
            },
        },
        methods: {
            buscarEmpresas() {
                this.get$_isHttp.get(`/empresas`).then(response => {
                    this.$store.dispatch('setEmpresas', response.data);
                    this.$store.dispatch('setMostrarTabelaEmpresas', true);
                    if (response.data.length == 0) {
                        alert("Você não possui nenhuma empresa cadastrada!");
                    }
                })
            },
            resetarFormulario() {
                this.errorMessages = [];
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
                        if (this.$refs[f].validate(true)) {
                            this.validacoes++;
                        }
                    }
                })
                if (this.validacoes == 13) {
                    const empresa = {
                        id: this.id,
                        razaoSocial: this.razaoSocial,
                        cnpj: this.cnpj,
                        logradouro: this.logradouro,
                        municipio: this.municipio,
                        numero: this.numero,
                        complemento: this.complemento,
                        bairro: this.bairro,
                        cep: this.cep,
                        telefone: this.telefone,
                        email: this.email,
                        site: this.site,
                        usuario: this.usuario,
                        senha: this.senha,
                        createdAt: "",
                        updatedAt: ""
                    };
                    this.$emit('criarEmpresa', empresa);
                    this.$store.dispatch('setMostrarTabelaEmpresas', false);
                    this.resetarFormulario();
                    this.id = null;
                    this.validacoes = 0;
                } else {
                    this.validacoes = 0;
                }
            }
        }
    }
</script>

<style>

</style>