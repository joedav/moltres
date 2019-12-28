<template>
  <b-form @submit.prevent="save">
    <b-form-group label="Sku">
      <b-input type="text" v-model="sku" />
    </b-form-group>

    <b-form-group label="Name">
      <b-input type="text" v-model="name" />
    </b-form-group>

    <b-form-group label="Preço">
      <b-input type="number" v-model="price" />
    </b-form-group>

    <b-button
      type="submit"
      variant="success">Salvar
    </b-button>
    <b-button
      type="reset"
      variant="secondary">Limpar
    </b-button>
  </b-form>
</template>

<script>
  import axios from 'axios';

  export default {
    name: 'NewProduct',
    data,
    methods: {
      save
    }
  };

  function data() {
    return {
      sku: null,
      name: null,
      price: 0
    };
  }

  function save() {
    const newProduct = {
      sku: this.sku,
      name: this.name,
      price: this.price
    };

    axios.post('/api/products', newProduct)
      .then(({ data }) => {
        alert(`Produto ${this.sku} inserido com ID: ${data.id}`);
        console.log(data);
        this.$router.push({ name: 'product-list' });
      })
      .catch(error => {
        console.log(error, error.response);
      });
  }
</script>

<style scoped>

</style>
