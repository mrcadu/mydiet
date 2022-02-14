<template>
  <div class="home row">
    <div class="col-md-9">
      <h1 class="display-4">Welcome, Java Hipster!</h1>
      <div>
        <div class="alert alert-warning" v-if="!authenticated">
          <span>If you want to </span>
          <a class="alert-link" v-on:click="openLogin()">sign in</a
          ><span
            >, you can try the default accounts:<br />- Administrator (login="admin" and password="admin") <br />- User (login="user" and
            password="user").</span
          >
        </div>
        <div class="alert alert-warning" v-if="!authenticated">
          <span>You don't have an account yet?</span>&nbsp;
          <router-link class="alert-link" to="/register">Register a new account</router-link>
        </div>
      </div>

      <p>If you have any question on JHipster:</p>

      <ul>
        <li>
          <a href="https://www.jhipster.tech/" target="_blank" rel="noopener noreferrer">JHipster homepage</a>
        </li>
        <li>
          <a href="http://stackoverflow.com/tags/agilekip/info" target="_blank" rel="noopener noreferrer">JHipster on Stack Overflow</a>
        </li>
        <li>
          <a href="https://github.com/agilekip/generator-jhipster-agilekip/issues?state=open" target="_blank" rel="noopener noreferrer"
            >JHipster bug tracker</a
          >
        </li>
        <li>
          <a href="https://twitter.com/agilekip" target="_blank" rel="noopener noreferrer">follow @agilekip on Twitter</a>
        </li>
      </ul>

      <p>
        <span>If you like AgileKip Generator, don't forget to give us a star on</span>
        <a href="https://github.com/agilekip/generator-jhipster-agilekip" target="_blank" rel="noopener noreferrer">GitHub</a>!
      </p>
    </div>
  </div>
</template>

<script lang="ts" src="./home.component.ts"></script>
