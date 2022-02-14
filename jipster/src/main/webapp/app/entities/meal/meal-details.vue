<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="meal">
        <h2 class="jh-entity-heading" data-cy="mealDetailsHeading"><span>Meal</span> {{ meal.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Name</span>
          </dt>
          <dd>
            <span>{{ meal.name }}</span>
          </dd>
          <dt>
            <span>Diet</span>
          </dt>
          <dd>
            <div v-if="meal.diet">
              <router-link :to="{ name: 'DietView', params: { dietId: meal.diet.id } }">{{ meal.diet.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./meal-details.component.ts"></script>
