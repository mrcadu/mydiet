<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="userDiet">
        <h2 class="jh-entity-heading" data-cy="userDietDetailsHeading"><span>UserDiet</span> {{ userDiet.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Username</span>
          </dt>
          <dd>
            <span>{{ userDiet.username }}</span>
          </dd>
          <dt>
            <span>Password</span>
          </dt>
          <dd>
            <span>{{ userDiet.password }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./user-diet-details.component.ts"></script>
