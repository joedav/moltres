<template>
  <b-container>
    <b-navbar type="dark" variant="info">
      <b-navbar-nav>
        <b-nav-item to="/">Home</b-nav-item>
        <b-nav-item to="/products">Produtos</b-nav-item>
      </b-navbar-nav>
    </b-navbar>
    <br/>
    <router-view />
  </b-container>
</template>

<script>
  export default {};
</script>

<style lang="scss">

</style>
