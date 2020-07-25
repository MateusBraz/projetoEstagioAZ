<template>
    <div>
        <h1 class="display-3 font-weight-light d-none d-md-flex">{{ titulo }}</h1>
        <h1 class="display-1 font-weight-light d-flex d-md-none">{{ titulo }}</h1>
        <v-divider class="mb-5"></v-divider>
    </div>
</template>

<script>
    export default {
        props: {
            titulo: {
                type: String,
                required: true
            }
        }
    }
</script>

<style>
    h1 {
        color: white;
    }
</style>