<template>
  <div>
    <b-button to="/products/new" variant="primary">Novo produto</b-button>

    <table class="table table-responsive table-striped">
      <thead class="thead-dark">
      <tr>
        <th>Sku</th>
        <th>Nome</th>
        <th>Preço</th>
        <th>Ativo</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="product in products" :key="product.sku">
        <td>{{ product.sku }}</td>
        <td>{{ product.name }}</td>
        <td>{{ product.price }}</td>
        <td>
          <b-badge v-if="product.active" variant="success">Sim</b-badge>
          <b-badge v-else variant="danger">Não</b-badge>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    name: 'ProductList',
    data,
    mounted
  };

  function data() {
    return {
      products: []
    };
  }

  function mounted() {
    axios.get('/api/products')
      .then(({ data }) => {
        this.products = data;
      })
      .catch(error => {
        console.log(error, error.response);
      })
  }
</script>

<style scoped>

</style>
