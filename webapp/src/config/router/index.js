import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import ProductList from '@/views/products/ProductList';
import NewProduct from '../../views/products/NewProduct';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/products',
    name: 'product-list',
    component: ProductList
  },
  {
    path: '/products/new',
    name: 'product-new',
    component: NewProduct
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
